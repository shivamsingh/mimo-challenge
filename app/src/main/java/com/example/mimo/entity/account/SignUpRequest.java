package com.example.mimo.entity.account;

public class SignUpRequest {
    private String clientId;
    private String email;
    private String password;
    private String connection;
    private String grantType;
    private String scope;

    public SignUpRequest() {
    }

    public SignUpRequest(String email, String password, String clientId, String connection, String grantType, String scope) {
        this.email = email;
        this.password = password;
        this.clientId = clientId;
        this.connection = connection;
        this.grantType = grantType;
        this.scope = scope;
    }

    public String getClientId() {
        return clientId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConnection() {
        return connection;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getScope() {
        return scope;
    }
}
