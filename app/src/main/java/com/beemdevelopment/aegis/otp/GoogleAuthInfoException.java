package com.beemdevelopment.aegis.otp;

public class GoogleAuthInfoException extends Exception {
    public GoogleAuthInfoException(final Throwable cause) {
        super(cause);
    }

    public GoogleAuthInfoException(final String message) {
        super(message);
    }

    public GoogleAuthInfoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        Throwable cause = getCause();
        if (cause == null) {
            return super.getMessage();
        }
        return String.format("%s (%s)", super.getMessage(), cause.getMessage());
    }
}
