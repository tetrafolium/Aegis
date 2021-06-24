package com.beemdevelopment.aegis.crypto;

import com.beemdevelopment.aegis.encoding.Hex;
import com.beemdevelopment.aegis.encoding.HexException;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class CryptParameters implements Serializable {
private byte[] _nonce;
private byte[] _tag;

public CryptParameters(final byte[] nonce, final byte[] tag) {
	_nonce = nonce;
	_tag = tag;
}

public JSONObject toJson() {
	JSONObject obj = new JSONObject();

	try {
		obj.put("nonce", Hex.encode(_nonce));
		obj.put("tag", Hex.encode(_tag));
	} catch (JSONException e) {
		throw new RuntimeException(e);
	}

	return obj;
}

public static CryptParameters fromJson(final JSONObject obj)
throws JSONException, HexException {
	byte[] nonce = Hex.decode(obj.getString("nonce"));
	byte[] tag = Hex.decode(obj.getString("tag"));
	return new CryptParameters(nonce, tag);
}

public byte[] getNonce() {
	return _nonce;
}

public byte[] getTag() {
	return _tag;
}
}
