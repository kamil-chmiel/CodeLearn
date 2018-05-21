package com.company.codelearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignInActivity extends AppCompatActivity {
    private AccountManager accountManager;

    private EditText mailTextField;
    private EditText passwordTextField;

    private Button signInBasicButton;
    private Button signInFacebookButton;
    private Button signInGoogleButton;

    // Google sign-in related stuff
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        accountManager = new AccountManager();

        mailTextField = findViewById(R.id.signInEmailText);
        passwordTextField = findViewById(R.id.signInPasswordText);

        signInBasicButton = findViewById(R.id.signInBasicButton);
        signInFacebookButton = findViewById(R.id.signInFacebookButton);
        signInGoogleButton = findViewById(R.id.signInGoogleButton);

        initActions();
    }

    private void initActions() {
        initSignInBasicButton();
        iniSignInFacebookButton();
    }

    private void initSignInBasicButton() {
        signInBasicButton.setOnClickListener(view -> {
            String mail = mailTextField.getText().toString().trim();
            String password = passwordTextField.getText().toString().trim();

            AccountManager.CredentialsState state = accountManager.validateCredentials(mail, password);

            switch (state) {
                case EMAIL_EMPTY:
                    mailTextField.setError("E-mail cannot be empty.");
                    break;
                case E_MAIL_INCORRECT:
                    mailTextField.setError("E-mail has incorrect format.");
                    break;
                case PASSWORD_EMPTY:
                    passwordTextField.setError("Password cannot be empty.");
                    break;
                case VALID:
                default:
                    // TODO: add progressbar/loading-bar here
                    accountManager.signIn(this, mail, password)
                            .addOnCompleteListener(this, authResultTask -> {
                                if (authResultTask.isSuccessful()) {
                                    UserData data = accountManager.getUserData();
                                    Intent intent = new Intent(this, MainActivity.class);
                                    intent.putExtra("UserData", data);
                                    startActivity(intent);
                                } else {
                                    Snackbar.make(view, "Authentication failed", Snackbar.LENGTH_LONG)
                                            .setAction("RETRY", v -> {
                                                signInBasicButton.callOnClick();
                                            })
                                            .show();
                                }
                            });
                    break;
            }
        });
    }

    private void iniSignInFacebookButton() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestIdToken("667568430002-jrsn43u40nv9544igp1qfvo4ojrtnr8s.apps.googleusercontent.com")
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        signInGoogleButton.setOnClickListener(event -> {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            System.out.println("SIGN IN!");
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                System.out.println("ApiException " + e.getMessage());
                // Google Sign In failed, update UI appropriately
//                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        System.out.println("\tonStart");

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(this, authResultTask -> {
                    if (authResultTask.isSuccessful()) {
                        UserData data = accountManager.getUserData();
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.putExtra("UserData", data);
                        startActivity(intent);
                    } else {
                        System.out.println("Failed");
                    }
                });
    }
}
