package com.example.mimo.entity.account;

public class SignUpResponse {
    boolean emailVerified;
    private String email;

    public SignUpResponse() {
    }

    public SignUpResponse(boolean emailVerified, String email) {
        this.emailVerified = emailVerified;
        this.email = email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public String getEmail() {
        return email;
    }
}
