package com.framework.core.excepton;

public class OperationException extends BaseException {

    public OperationException(String code) {
        super(code);
    }

    public OperationException(final String code, final Throwable throwable) {
        super(code, throwable);
    }
}
