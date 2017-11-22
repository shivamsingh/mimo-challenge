package com.example.mimo.entity.account;

public class LoginRequest {
    private String username;
    private String password;
    private String clientId;
    private String connection;
    private String grantType;
    private String scope;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password, String clientId, String connection,
                        String grantType, String scope) {
        this.clientId = clientId;
        this.username = username;
        this.password = password;
        this.connection = connection;
        this.grantType = grantType;
        this.scope = scope;
    }

    public String getClientId() {
        return clientId;
    }

    public String getUsername() {
        return username;
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
