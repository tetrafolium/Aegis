package com.beemdevelopment.aegis.db;

public class DatabaseFileException extends Exception {
public DatabaseFileException(final Throwable cause) {
	super(cause);
}

public DatabaseFileException(final String message) {
	super(message);
}
}
