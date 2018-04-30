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

public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth auth;

    private EditText mailTextField;
    private EditText passwordTextField;

    private Button signInBasicButton;
    private Button signInFacebookButton;
    private Button signInGoogleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        auth = FirebaseAuth.getInstance();

        mailTextField = findViewById(R.id.signInEmailText);
        passwordTextField = findViewById(R.id.signInPasswordText);

        signInBasicButton = findViewById(R.id.signInBasicButton);
        signInFacebookButton = findViewById(R.id.signInFacebookButton);
        signInGoogleButton = findViewById(R.id.signInGoogleButton);

        signInBasicButton.setOnClickListener(view -> {
            String mail = mailTextField.getText().toString();
            String password = passwordTextField.getText().toString();

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
                    passwordTextField.setError("Password is too short.");
                    isFormValid = false;
                }
            }

            if(!isFormValid) {
                return;
            }

            auth.signInWithEmailAndPassword(mailTextField.getText().toString(), passwordTextField.getText().toString())
                    .addOnCompleteListener(this, authResultTask -> {
                        if (authResultTask.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
                            System.out.println("Success!");
                            FirebaseUser user = auth.getCurrentUser();

                            Intent intent = new Intent(this,
                                    MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}
