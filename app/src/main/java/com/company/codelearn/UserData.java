package com.company.codelearn;

import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;

public class UserData implements Serializable {
    private String userId;
    private String name;
    private String email;

    public UserData(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public UserData(FirebaseUser user) {
        this.name = user.getDisplayName();
        this.userId = user.getUid();
        this.email = user.getEmail();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
