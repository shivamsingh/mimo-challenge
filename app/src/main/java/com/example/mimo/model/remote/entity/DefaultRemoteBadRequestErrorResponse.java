package com.example.mimo.model.remote.entity;

import com.example.mimo.di.module.NetworkModule;
import com.example.mimo.utils.Constant;

import java.io.IOException;

import retrofit2.Response;

public class DefaultRemoteBadRequestErrorResponse implements RemoteErrorResponse {

    @Override
    public String errorMessage(Response response) {
        RemoteBadRequestError remoteBadRequestError = null;
        try {
            remoteBadRequestError = new NetworkModule().gson()
                    .fromJson(response.errorBody().string(), RemoteBadRequestError.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String errorMessage = errorMessage(remoteBadRequestError);

        if (errorMessage.equals(""))
            return Constant.UNKNOWN_ERROR_MESSAGE;
        return errorMessage;
    }

    private String errorMessage(RemoteBadRequestError error) {
        if (error == null)
            return "";
        if (error.getDescription() != null)
            return error.getDescription();
        if (error.getErrorDescription() != null)
            return error.getErrorDescription();
        if (error.getError() != null)
            return error.getError();
        return "";
    }
}
