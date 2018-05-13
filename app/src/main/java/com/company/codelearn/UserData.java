package com.company.codelearn;

import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;

class UserData implements Serializable {
    private final String userId;
    private final String name;
    private final String email;

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
}
