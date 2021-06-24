package com.beemdevelopment.aegis.helpers.comparators;

import com.beemdevelopment.aegis.db.DatabaseEntry;
import java.util.Comparator;

public class AccountNameComparator implements Comparator<DatabaseEntry> {
@Override
public int compare(final DatabaseEntry a, final DatabaseEntry b) {
	return a.getName().compareToIgnoreCase(b.getName());
}
}
