package com.beemdevelopment.aegis.importers;

import android.content.Context;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FreeOtpPlusImporter extends DatabaseImporter {
private static final String _subPath = "shared_prefs/tokens.xml";
private static final String _pkgName = "org.liberty.android.freeotpplus";

public FreeOtpPlusImporter(final Context context) {
	super(context);
}

@Override
protected String getAppPkgName() {
	return _pkgName;
}

@Override
protected String getAppSubPath() {
	return _subPath;
}

@Override
public State read(final FileReader reader) throws DatabaseImporterException {
	State state;

	if (reader.isInternal()) {
		state = new FreeOtpImporter(getContext()).read(reader);
	} else {
		try {
			String json = new String(reader.readAll(), StandardCharsets.UTF_8);
			JSONObject obj = new JSONObject(json);
			JSONArray array = obj.getJSONArray("tokens");

			List<JSONObject> entries = new ArrayList<>();
			for (int i = 0; i < array.length(); i++) {
				entries.add(array.getJSONObject(i));
			}

			state = new FreeOtpImporter.State(entries);
		} catch (IOException | JSONException e) {
			throw new DatabaseImporterException(e);
		}
	}

	return state;
}
}
