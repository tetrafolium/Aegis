package com.beemdevelopment.aegis.db.slots;

import com.beemdevelopment.aegis.crypto.CryptParameters;
import java.util.UUID;

public class FingerprintSlot extends RawSlot {
public FingerprintSlot() {
	super();
}

FingerprintSlot(final UUID uuid, final byte[] key,
                final CryptParameters keyParams) {
	super(uuid, key, keyParams);
}

@Override
public byte getType() {
	return TYPE_FINGERPRINT;
}
}
