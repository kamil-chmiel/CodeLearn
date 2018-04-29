package com.company.codelearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private Button signUpFacebookButton;
    private Button signUpGoogleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        mailTextField = findViewById(R.id.signUpEmailText);
        passwordTextField = findViewById(R.id.signUpPasswordText);
        passwordTextField = findViewById(R.id.signUpRepeatPasswordText);

        signUpBasicButton = findViewById(R.id.signUpBasicButton);
        signUpFacebookButton = findViewById(R.id.signUpFacebookButton);
        signUpGoogleButton = findViewById(R.id.signUpGoogleButton);

        signUpBasicButton.setOnClickListener(view -> {
            auth.createUserWithEmailAndPassword(mailTextField.getText().toString(),
                                                passwordTextField.getText().toString())
                .addOnCompleteListener(this, (authResultTask) -> {
                    if (authResultTask.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
//                        Log.d( "createUserWithEmail:success");
                        System.out.println("Success");
                        FirebaseUser user = auth.getCurrentUser();

//                        updateUI(user);
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Can be used in other activites (?)
//        FirebaseUser currentUser = auth.getCurrentUser();
    }
}
