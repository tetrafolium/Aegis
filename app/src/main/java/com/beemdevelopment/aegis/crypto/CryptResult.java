package com.beemdevelopment.aegis.crypto;

public class CryptResult {
  private byte[] _data;
  private CryptParameters _params;

  public CryptResult(final byte[] data, final CryptParameters params) {
    _data = data;
    _params = params;
  }

  public byte[] getData() { return _data; }

  public CryptParameters getParams() { return _params; }
}
