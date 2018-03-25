package com.imit.omsu;

public enum ErrorCode {
    SIZE_INVALID("Size is invalid. Enter positive size for matrix."),
    ZERO_DETERMINANT("Determinant is equals to 0."),
    FILE_NOT_FOUND("File not found.");


    private String errorCode;

    private ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
