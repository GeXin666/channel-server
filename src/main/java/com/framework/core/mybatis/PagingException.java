package com.framework.core.mybatis;

public class PagingException extends RuntimeException {
	
	private static final long serialVersionUID = 7351454777961692439L;

	/**
     * Creates a new PagingException.
     */
    public PagingException() {
        super();
    }

    /**
     * Constructs a new PagingException.
     *
     * @param message the reason for the exception
     */
    public PagingException(String message) {
        super(message);
    }

    /**
     * Constructs a new PagingException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public PagingException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new PagingException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public PagingException(String message, Throwable cause) {
        super(message, cause);
    }
}
