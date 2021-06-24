package com.beemdevelopment.aegis.ui.preferences;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;

public class SwitchPreference extends SwitchPreferenceCompat {
  private Preference.OnPreferenceChangeListener _listener;

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  public SwitchPreference(final Context context, final AttributeSet attrs,
                          final int defStyleAttr, final int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  public SwitchPreference(final Context context, final AttributeSet attrs,
                          final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public SwitchPreference(final Context context, final AttributeSet attrs) {
    super(context, attrs);
  }

  public SwitchPreference(final Context context) { super(context); }

  @Override
  public void
  setOnPreferenceChangeListener(final OnPreferenceChangeListener listener) {
    super.setOnPreferenceChangeListener(listener);
    _listener = listener;
  }

  @Override
  public void setChecked(final boolean checked) {
    setChecked(true, false);
  }

  public void setChecked(final boolean checked, final boolean silent) {
    if (silent) {
      super.setOnPreferenceChangeListener(null);
    }
    super.setChecked(checked);
    if (silent) {
      super.setOnPreferenceChangeListener(_listener);
    }
  }
}
