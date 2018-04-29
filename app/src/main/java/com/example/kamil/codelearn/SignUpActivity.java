package com.example.kamil.codelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
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

        mailTextField = findViewById(R.id.signUpEmailText);
        passwordTextField = findViewById(R.id.signUpPasswordText);
        passwordTextField = findViewById(R.id.signUpRepeatPasswordText);

        signUpBasicButton = findViewById(R.id.signUpBasicButton);
        signUpFacebookButton = findViewById(R.id.signUpFacebookButton);
        signUpGoogleButton = findViewById(R.id.signUpGoogleButton);
    }
}
