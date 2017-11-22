package com.example.mimo.model.remote.entity;

import retrofit2.Response;

public interface RemoteErrorResponse {

    String errorMessage(Response response);
}
