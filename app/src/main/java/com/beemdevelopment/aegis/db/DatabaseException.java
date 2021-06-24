package com.beemdevelopment.aegis.db;

public class DatabaseException extends Exception {
    public DatabaseException(final Throwable cause) {
        super(cause);
    }

    public DatabaseException(final String message) {
        super(message);
    }
}
