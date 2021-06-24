package com.beemdevelopment.aegis.db.slots;

import com.beemdevelopment.aegis.crypto.CryptParameters;
import com.beemdevelopment.aegis.crypto.CryptoUtils;
import com.beemdevelopment.aegis.crypto.MasterKey;
import com.beemdevelopment.aegis.crypto.SCryptParameters;
import com.beemdevelopment.aegis.encoding.Hex;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.json.JSONException;
import org.json.JSONObject;

public class PasswordSlot extends RawSlot {
  private boolean _repaired;
  private SCryptParameters _params;

  public PasswordSlot() { super(); }

  protected PasswordSlot(final UUID uuid, final byte[] key,
                         final CryptParameters keyParams,
                         final SCryptParameters scryptParams,
                         final boolean repaired) {
    super(uuid, key, keyParams);
    _params = scryptParams;
    _repaired = repaired;
  }

  @Override
  public JSONObject toJson() {
    try {
      JSONObject obj = super.toJson();
      obj.put("n", _params.getN());
      obj.put("r", _params.getR());
      obj.put("p", _params.getP());
      obj.put("salt", Hex.encode(_params.getSalt()));
      obj.put("repaired", _repaired);
      return obj;
    } catch (JSONException e) {
      throw new RuntimeException(e);
    }
  }

  public SecretKey deriveKey(final char[] password,
                             final SCryptParameters params) {
    SecretKey key = CryptoUtils.deriveKey(password, params);
    _params = params;
    return key;
  }

  public SecretKey deriveKey(final char[] password) {
    return CryptoUtils.deriveKey(password, _params);
  }

  public SecretKey deriveKey(final byte[] data) {
    return CryptoUtils.deriveKey(data, _params);
  }

  @Override
  public void setKey(final MasterKey masterKey, final Cipher cipher)
      throws SlotException {
    super.setKey(masterKey, cipher);
    _repaired = true;
  }

  /**
   * Reports whether this slot was repaired and is no longer affected by issue
   * #95.
   */
  public boolean isRepaired() { return _repaired; }

  @Override
  public byte getType() {
    return TYPE_DERIVED;
  }
}
