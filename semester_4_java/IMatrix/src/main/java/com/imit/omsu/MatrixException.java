package com.imit.omsu;

public class MatrixException extends Exception {
    public MatrixException(ErrorCode errorCode){
        errorCode.getErrorCode();
    }
}
