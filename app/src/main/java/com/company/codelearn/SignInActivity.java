package com.company.codelearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.company.codelearn.database.DatabaseHelper;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.Arrays;


public class SignInActivity extends AppCompatActivity {
    private AccountManager accountManager;

    private EditText mailTextField;
    private EditText passwordTextField;

    private Button signInBasicButton;
    private LoginButton signInFacebookButton;
    private Button signInGoogleButton;

    // Google sign-in related stuff
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;
    private CallbackManager callbackManager;

    private boolean isFirstStart = true;

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
        initSignInGoogleButton();
        initSignInFacebookButton();
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
                                    new DatabaseHelper(getApplicationContext()).createUserIfNotExist(data);
                                    Intent intent;
                                    if(isFirstStart) {
                                        intent = new Intent(this, LevelActivity.class);
                                        isFirstStart = false;
                                    } else {
                                        intent = new Intent(this, MainActivity.class);
                                    }
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

    private void initSignInGoogleButton() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        signInGoogleButton.setOnClickListener(event -> {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        });
    }

    private void initSignInFacebookButton() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        callbackManager = CallbackManager.Factory.create();


        signInFacebookButton.setOnClickListener(event -> {
            signInFacebookButton.setReadPermissions("email", "public_profile");

            signInFacebookButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    System.out.println("Success");
                    handleFacebookAccessToken(loginResult.getAccessToken());
                }

                @Override
                public void onCancel() {
                    // App code
                }

                @Override
                public void onError(FacebookException exception) {
                    System.out.println("FacebookException " + exception.toString());
                }
            });
        });
    }

    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        System.out.println("Facebook sign in success!");
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                        UserData data = accountManager.getUserData();
                        data.setEmail("developercodelearn@gmail.com");

                        new DatabaseHelper(getApplicationContext()).createUserIfNotExist(data);
                        Intent intent;
                        if(isFirstStart) {
                            intent = new Intent(this, LevelActivity.class);
                            isFirstStart = false;
                        } else {
                            intent = new Intent(this, MainActivity.class);
                        }
                        intent.putExtra("UserData", data);
                        startActivity(intent);
                    } else {
                        System.out.println("Facebook Exception " + task.getException());
                    }
                });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // FB
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        // Google
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            System.out.println("SIGN IN!");
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                System.out.println("ApiException " + CommonStatusCodes.getStatusCodeString(e.getStatusCode()));
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
                        new DatabaseHelper(getApplicationContext()).createUserIfNotExist(data);
                        Intent intent;
                        if(isFirstStart) {
                            intent = new Intent(this, LevelActivity.class);
                            isFirstStart = false;
                        } else {
                            intent = new Intent(this, MainActivity.class);
                        }
                        intent.putExtra("UserData", data);
                        startActivity(intent);
                    } else {
                        System.out.println("Failed");
                    }
                });
    }
}
