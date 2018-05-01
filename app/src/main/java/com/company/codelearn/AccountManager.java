package com.company.codelearn;

import android.app.Activity;
import android.util.Patterns;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;

import static com.company.codelearn.AccountManager.CredentialsState.EMAIL_EMPTY;
import static com.company.codelearn.AccountManager.CredentialsState.E_MAIL_INCORRECT;
import static com.company.codelearn.AccountManager.CredentialsState.PASSWORD_EMPTY;
import static com.company.codelearn.AccountManager.CredentialsState.VALID;

class AccountManager implements Serializable {
    private FirebaseAuth auth;

    public AccountManager() {
        this.auth = FirebaseAuth.getInstance();
    }

    public UserData getUserData() {
        return new UserData(auth.getCurrentUser());
    }

    public enum CredentialsState {VALID, EMAIL_EMPTY, E_MAIL_INCORRECT, PASSWORD_EMPTY, PASSWORD_LENGTH;}

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

    public CredentialsState validateCredentials(String mail, String password, String repeatPassword) {
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

    public Task<AuthResult> signIn(Activity activity, String mail, String password) {
        return this.auth.signInWithEmailAndPassword(mail, password);
    }
}
