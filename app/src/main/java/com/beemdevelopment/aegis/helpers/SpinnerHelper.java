package com.beemdevelopment.aegis.helpers;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.ArrayRes;
import java.util.List;

public class SpinnerHelper {
  private SpinnerHelper() {}

  public static void fillSpinner(final Context context, final Spinner spinner,
                                 final @ArrayRes int textArrayResId) {
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
        context, textArrayResId, android.R.layout.simple_spinner_item);
    initSpinner(spinner, adapter);
  }

  public static <T> void fillSpinner(final Context context,
                                     final Spinner spinner,
                                     final List<T> items) {
    ArrayAdapter adapter = new ArrayAdapter<>(
        context, android.R.layout.simple_spinner_item, items);
    initSpinner(spinner, adapter);
  }

  private static void initSpinner(final Spinner spinner,
                                  final ArrayAdapter adapter) {
    adapter.setDropDownViewResource(
        android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    spinner.invalidate();
  }
}
