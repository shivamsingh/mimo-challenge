package com.example.mimo.model.remote.entity;

import com.example.mimo.di.module.NetworkModule;
import com.example.mimo.model.remote.entity.RemoteError;
import com.example.mimo.model.remote.entity.RemoteErrorResponse;
import com.example.mimo.utils.Constant;

import java.io.IOException;

import retrofit2.Response;

public class DefaultRemoteErrorResponse implements RemoteErrorResponse {

    @Override
    public String errorMessage(Response response) {
        RemoteError remoteError = null;
        try {
            remoteError = new NetworkModule().gson()
                    .fromJson(response.errorBody().string(), RemoteError.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (remoteError == null || remoteError.getErrorDescription().equals(""))
            return Constant.UNKNOWN_ERROR_MESSAGE;
        return remoteError.getErrorDescription();
    }
}
