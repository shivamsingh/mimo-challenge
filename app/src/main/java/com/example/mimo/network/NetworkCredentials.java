package com.example.mimo.network;

public class NetworkCredentials {
    private String apiUrl;
    private String clientId;
    private String connection;
    private String grantType;
    private String scope;

    public NetworkCredentials(String apiUrl, String clientId, String connection, String grantType, String scope) {
        this.apiUrl = apiUrl;
        this.clientId = clientId;
        this.connection = connection;
        this.grantType = grantType;
        this.scope = scope;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getClientId() {
        return clientId;
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
