package com.beemdevelopment.aegis.helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import me.dm7.barcodescanner.core.ViewFinderView;

public class SquareFinderView extends ViewFinderView {

  public SquareFinderView(final Context context) {
    super(context);
    init();
  }

  public SquareFinderView(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() { setSquareViewFinder(true); }

  @Override
  public void onDraw(final Canvas canvas) {
    super.onDraw(canvas);
  }
}
