package com.beemdevelopment.aegis.importers;

public class DatabaseImporterException extends Exception {
    public DatabaseImporterException(final Throwable cause) {
        super(cause);
    }

    public DatabaseImporterException(final String message) {
        super(message);
    }
}
