package com.company.codelearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth auth;

    private EditText mailTextField;
    private EditText passwordTextField;
    private EditText repeatPasswordTextField;

    private Button signUpBasicButton;
    private Button signInSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        mailTextField = findViewById(R.id.signUpEmailText);
        passwordTextField = findViewById(R.id.signUpPasswordText);
        repeatPasswordTextField = findViewById(R.id.signUpRepeatPasswordText);

        signUpBasicButton = findViewById(R.id.signUpBasicButton);
        signInSocial = findViewById(R.id.signInSocial);

        signUpBasicButton.setOnClickListener(view -> {
            String mail = mailTextField.getText().toString();
            String password = passwordTextField.getText().toString();
            String repeatPassword = repeatPasswordTextField.getText().toString();

            boolean isFormValid = true;

            if(mail == null || mail.isEmpty()) {
                mailTextField.setError("E-mail cannot be empty.");
                isFormValid = false;
            } else {
                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    mailTextField.setError("E-mail has incorrect format.");
                    isFormValid = false;
                }
            }

            if(password == null || password.isEmpty()) {
                passwordTextField.setError("Password cannot be empty.");
                isFormValid = false;
            } else {
                if(password.length() < 6) {
                    passwordTextField.setError("Password should have at least 6 characters.");
                    isFormValid = false;
                }

                if(repeatPassword == null || repeatPassword.isEmpty()) {
                    repeatPasswordTextField.setError("Repeat your password.");
                    isFormValid = false;
                } else {
                    if(!password.equals(repeatPassword)) {
                        repeatPasswordTextField.setError("Passwords are not identical!");
                        isFormValid = false;
                    }
                }
            }

            if(!isFormValid) {
                return;
            }

            // TODO: show loading popup
            auth.createUserWithEmailAndPassword(mail,
                    passwordTextField.getText().toString())
                    .addOnCompleteListener(this, (authResultTask) -> {
                        if (authResultTask.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                        Log.d( "createUserWithEmail:success");
                            // TODO: store userID in database???

                            Toast.makeText(this, "Account created!",
                                    Toast.LENGTH_SHORT).show();

                            FirebaseUser user = auth.getCurrentUser();

                            Intent intent = new Intent(this,
                                    SignInActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);

                            Toast.makeText(this, "Now, you can log in!",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            // If sign in fails, display a message to the user.
//                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                        System.out.println("Failed!\n\t" + authResultTask.getException());
                            Toast.makeText(this, "Authentication failed. " + authResultTask.getException(),
                                    Toast.LENGTH_LONG).show();

//                        updateUI(null);
                        }
                    });
        });

        signInSocial.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this , SignInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Can be used in other activites (?)
//        FirebaseUser currentUser = auth.getCurrentUser();
    }
}
