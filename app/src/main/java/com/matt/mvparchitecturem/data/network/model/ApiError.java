package com.matt.mvparchitecturem.data.network.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiError {
    private int errorCode;

    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("message")
    private String message;

    public ApiError(int errorCode, String statusCode, String message) {
        this.errorCode = errorCode;
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ApiError apiError = (ApiError) obj;
        if (errorCode != apiError.errorCode) return false;
        if (statusCode != null ? !apiError.statusCode.equals(statusCode) : apiError.statusCode != null) {
            return false;
        }
        return message != null ? message.equals(apiError.message) : apiError.message == null;
    }

    @Override
    public int hashCode() {
        int result = errorCode;
        result = 31 * result + (statusCode != null ? statusCode.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
