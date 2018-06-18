package com.company.codelearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.company.codelearn.database.DatabaseHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class EditProfileActivity extends AppCompatActivity {
    private String currentName;
    private String currentEmail;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        currentName = user.getDisplayName();
        currentEmail = user.getEmail();

        EditText currentNameField = findViewById(R.id.editCurrentName);
        EditText currentEmailField = findViewById(R.id.editCurrentEmail);
        currentNameField.setText(user.getDisplayName());
        currentEmailField.setText(user.getEmail());

        initButtonsActions();
    }

    private void initButtonsActions() {
        Button saveButton = findViewById(R.id.saveEditProfile);
        saveButton.setOnClickListener((View view) -> {

            EditText editedNameField = findViewById(R.id.editCurrentName);
            EditText editedEmailField = findViewById(R.id.editCurrentEmail);
            EditText passwordField = findViewById(R.id.editPassword);
            EditText passwordRepeatedField = findViewById(R.id.editRepeatedPassword);

            String editedName = editedNameField.getText().toString();
            String editedEmail = editedEmailField.getText().toString();
            String password = passwordField.getText().toString();
            String repeatPassword = passwordRepeatedField.getText().toString();

            AccountManager accountManager = new AccountManager();
            AccountManager.CredentialsState state = accountManager.validateCredentials(editedName, editedEmail, password, repeatPassword);
            switch (state) {
                case NAME_EMPTY:
                    editedNameField.setError("Name can't be empty");
                    break;
                case EMAIL_EMPTY:
                    editedEmailField.setError("Email can't be empty");
                    break;
                case E_MAIL_INCORRECT:
                    editedEmailField.setError("Email is incorrect!");
                    break;
                case PASSWORD_LENGTH:
                    passwordField.setError("Password is to short! Minimum 6 length!");
                    break;
                case REPEAT_EMPTY:
                    passwordRepeatedField.setError("Field can't be empty!");
                    break;
                case REEPAT_NOT_SAME:
                    passwordRepeatedField.setError("Password are not the same!");
                    break;
                case PASSWORD_EMPTY:
                case VALID:
                default:
                {
                    if(!currentName.equals(editedNameField.getText().toString())) {
                        new DatabaseHelper(getApplicationContext()).updateUserInfo(new UserData(user.getUid(), editedName, user.getEmail()));
                        user.updateProfile(new UserProfileChangeRequest.Builder().setDisplayName(editedName).build());
                    }
                    if(!currentEmail.equals(editedEmailField.getText().toString())) {
                        new DatabaseHelper(getApplicationContext()).updateUserInfo(new UserData(user.getUid(), user.getDisplayName(), editedEmail));
                        user.updateEmail(editedEmail);
                    }

                    //Possibly changing password
                    if(passwordField.getText().length() > 0) {
                        if(passwordField.getText().toString().equals(passwordRepeatedField.getText().toString())) {
                            System.out.println(password);
                            user.updatePassword(password);
                        } else {
                            passwordRepeatedField.setError("Password are not the same");
                        }
                    }
                }
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
