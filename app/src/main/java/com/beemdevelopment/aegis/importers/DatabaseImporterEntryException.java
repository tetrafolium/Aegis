package com.beemdevelopment.aegis.importers;

public class DatabaseImporterEntryException extends Exception {
  private String _text;

  public DatabaseImporterEntryException(final Throwable cause,
                                        final String text) {
    super(cause);
    _text = text;
  }

  public String getText() { return _text; }
}
