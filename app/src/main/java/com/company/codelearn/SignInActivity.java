package com.company.codelearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {
    private AccountManager accountManager;

    private EditText mailTextField;
    private EditText passwordTextField;

    private Button signInBasicButton;
    private Button signInFacebookButton;
    private Button signInGoogleButton;

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
    }

    private void initSignInBasicButton() {
        signInBasicButton.setOnClickListener(view -> {
            String mail = mailTextField.getText().toString();
            String password = passwordTextField.getText().toString();

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
}
