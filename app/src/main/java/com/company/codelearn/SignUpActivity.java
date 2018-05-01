package com.company.codelearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private AccountManager accountManager;

    private EditText nameTextField;
    private EditText mailTextField;
    private EditText passwordTextField;
    private EditText repeatPasswordTextField;

    private Button signUpBasicButton;
    private Button signInSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        accountManager = new AccountManager();

        nameTextField = findViewById(R.id.signUpNameText);
        mailTextField = findViewById(R.id.signUpEmailText);
        passwordTextField = findViewById(R.id.signUpPasswordText);
        repeatPasswordTextField = findViewById(R.id.signUpRepeatPasswordText);

        signUpBasicButton = findViewById(R.id.signUpBasicButton);
        signInSocial = findViewById(R.id.signInSocial);

        initActions();
    }

    private void initActions() {
        initSignUpButton();
        initSignInSocialButton();
    }

    private void initSignUpButton() {
        signUpBasicButton.setOnClickListener(view -> {
            String name = nameTextField.getText().toString().trim();
            String mail = mailTextField.getText().toString().trim();
            String password = passwordTextField.getText().toString().trim();
            String repeatPassword = repeatPasswordTextField.getText().toString().trim();

            AccountManager.CredentialsState state = accountManager.validateCredentials(name, mail, password, repeatPassword);
            switch (state) {
                case NAME_EMPTY:
                    nameTextField.setError("Name cannot be empty.");
                    break;
                case EMAIL_EMPTY:
                    mailTextField.setError("E-mail cannot be empty.");
                    break;
                case E_MAIL_INCORRECT:
                    mailTextField.setError("E-mail has incorrect format.");
                    break;
                case PASSWORD_EMPTY:
                    passwordTextField.setError("Password cannot be empty.");
                    break;
                case PASSWORD_LENGTH:
                    passwordTextField.setError("Password must have at least 6 characters.");
                    break;
                case REPEAT_EMPTY:
                    repeatPasswordTextField.setError("Repeat your password.");
                    break;
                case REEPAT_NOT_SAME:
                    repeatPasswordTextField.setError("Passwords are not identical!");
                    break;
                case VALID:
                default:
                    accountManager.signUp(mail, password)
                            .addOnCompleteListener(this, (authResultTask) -> {
                                if (authResultTask.isSuccessful()) {
                                    accountManager.updateDisplayName(name);
                                    // TODO: store userID in database?
                                    Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show();
                                    // TODO: Go to sign in or sign in instantly?
                                    Intent intent = new Intent(this, SignInActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(this, "Now, you can log in!", Toast.LENGTH_LONG).show();
                                } else {
                                    Snackbar.make(view, "Signing up failed!", Snackbar.LENGTH_LONG)
                                            .setAction("RETRY", v -> {
                                                signUpBasicButton.callOnClick();
                                            })
                                            .show();
                                }
                            });
                    break;
            }
        });
    }

    private void initSignInSocialButton() {
        signInSocial.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
