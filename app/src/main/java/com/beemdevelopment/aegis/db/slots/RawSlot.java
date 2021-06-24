package com.beemdevelopment.aegis.db.slots;

import com.beemdevelopment.aegis.crypto.CryptParameters;

import java.util.UUID;

public class RawSlot extends Slot {
    public RawSlot() {
        super();
    }

    protected RawSlot(final UUID uuid, final byte[] key, final CryptParameters keyParams) {
        super(uuid, key, keyParams);
    }

    @Override
    public byte getType() {
        return TYPE_RAW;
    }
}
