package com.example.mimo.model.remote.entity;

import com.example.mimo.model.ResponseCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteResponseCallback<T> implements Callback<T> {

    private ResponseCallback<T> responseCallback;
    private RemoteErrorResponse remoteErrorResponse;

    public RemoteResponseCallback(ResponseCallback<T> responseCallback) {
        this.responseCallback = responseCallback;
    }

    RemoteResponseCallback(ResponseCallback<T> responseCallback, RemoteErrorResponse remoteErrorResponse) {
        this.responseCallback = responseCallback;
        this.remoteErrorResponse = remoteErrorResponse;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful())
            responseCallback.onSuccess(response.body());
        else {
            responseCallback.onFailure(error(response));
        }
    }

    private String error(Response<T> response) {
        if (remoteErrorResponse != null)
            return remoteErrorResponse.errorMessage(response);
        if (response.code() == 400)
            return new DefaultRemoteBadRequestErrorResponse().errorMessage(response);
        return new DefaultRemoteErrorResponse().errorMessage(response);
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        responseCallback.onFailure(t.getMessage());
    }
}
