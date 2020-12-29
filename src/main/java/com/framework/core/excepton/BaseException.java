package com.framework.core.excepton;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -6000583436059919480L;

    private String code;

    public BaseException(final String code) {
        super(code);
        this.code = code;
    }

    public BaseException(final String code, final Throwable throwable) {
        super(code, throwable);
        this.code = code;
    }

    public final String getCode() {
        return this.code;
    }

}
