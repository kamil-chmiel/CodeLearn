package com.example.kamil.codelearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {
    private EditText mailTextField;
    private EditText passwordTextField;

    private Button signInBasicButton;
    private Button signInFacebookButton;
    private Button signInGoogleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mailTextField = findViewById(R.id.signInEmailText);
        passwordTextField = findViewById(R.id.signInPasswordText);

        signInBasicButton = findViewById(R.id.signInBasicButton);
        signInFacebookButton = findViewById(R.id.signInFacebookButton);
        signInGoogleButton = findViewById(R.id.signInGoogleButton);
    }
}
