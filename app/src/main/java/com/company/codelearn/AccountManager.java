package com.company.codelearn;

import android.app.Activity;
import android.util.Patterns;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.io.Serializable;

import static com.company.codelearn.AccountManager.CredentialsState.*;

class AccountManager implements Serializable {
    private FirebaseAuth auth;

    public AccountManager() {
        this.auth = FirebaseAuth.getInstance();
    }

    public UserData getUserData() {
        return new UserData(auth.getCurrentUser());
    }

    public enum CredentialsState {VALID, NAME_EMPTY ,EMAIL_EMPTY, E_MAIL_INCORRECT, PASSWORD_EMPTY, PASSWORD_LENGTH, REPEAT_EMPTY, REEPAT_NOT_SAME;}

    public CredentialsState validateCredentials(String mail, String password) {
        if (mail == null || mail.isEmpty()) {
            return EMAIL_EMPTY;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            return E_MAIL_INCORRECT;
        }

        if (password == null || password.isEmpty()) {
            return PASSWORD_EMPTY;
        }

        return VALID;
    }

    public CredentialsState validateCredentials(String name, String mail, String password, String repeatPassword) {
        if(name == null || name.isEmpty()) {
            return NAME_EMPTY;
        }

        if (mail == null || mail.isEmpty()) {
            return EMAIL_EMPTY;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            return E_MAIL_INCORRECT;
        }

        if (password == null || password.isEmpty()) {
            return PASSWORD_EMPTY;
        }

        if (password.length() < 6) {
            return PASSWORD_LENGTH;
        }

        if (repeatPassword == null || repeatPassword.isEmpty()) {
            return REPEAT_EMPTY;
        }

        if (!password.equals(repeatPassword)) {
            return REEPAT_NOT_SAME;
        }

        return VALID;
    }

    public Task<AuthResult> signIn(Activity activity, String mail, String password) {
        return this.auth.signInWithEmailAndPassword(mail, password);
    }

    public Task<AuthResult> signUp(String mail, String password) {
        return auth.createUserWithEmailAndPassword(mail, password);
    }

    public Task<Void> updateDisplayName(String name) {
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        builder.setDisplayName(name);

        return auth.getCurrentUser().updateProfile(builder.build());
    }
}
