package com.asiainfo.qm.manage.exception;


public class ConvertBeanException extends RuntimeException {

    private static final long serialVersionUID = -567786786333301727L;

    public ConvertBeanException(String message) {
        super(message);
    }

    public ConvertBeanException(String message, Throwable cause) {
        super(message, cause);

    }
}
