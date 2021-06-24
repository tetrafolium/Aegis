package com.beemdevelopment.aegis.helpers;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.beemdevelopment.aegis.db.DatabaseEntry;
import com.beemdevelopment.aegis.ui.views.EntryAdapter;
import java.util.Map;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

  private DatabaseEntry _selectedEntry;

  private final ItemTouchHelperAdapter _adapter;
  private boolean _positionChanged = false;
  private boolean _isLongPressDragEnabled = true;

  public SimpleItemTouchHelperCallback(final ItemTouchHelperAdapter adapter) {
    _adapter = adapter;
  }

  @Override
  public boolean isLongPressDragEnabled() {
    return _isLongPressDragEnabled;
  }

  public void setIsLongPressDragEnabled(final boolean enabled) {
    _isLongPressDragEnabled = enabled;
  }

  public void setSelectedEntry(final DatabaseEntry entry) {
    _selectedEntry = entry;
  }

  @Override
  public boolean isItemViewSwipeEnabled() {
    return false;
  }

  @Override
  public int getMovementFlags(final RecyclerView recyclerView,
                              final RecyclerView.ViewHolder viewHolder) {
    int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
    int swipeFlags = 0;

    int position = viewHolder.getAdapterPosition();
    EntryAdapter adapter = (EntryAdapter)recyclerView.getAdapter();
    if (adapter.getEntryAt(position) != _selectedEntry) {
      dragFlags = 0;
    }

    return makeMovementFlags(dragFlags, swipeFlags);
  }

  @Override
  public boolean onMove(final RecyclerView recyclerView,
                        final RecyclerView.ViewHolder viewHolder,
                        final RecyclerView.ViewHolder target) {
    _adapter.onItemMove(viewHolder.getAdapterPosition(),
                        target.getAdapterPosition());
    _positionChanged = true;
    return true;
  }

  @Override
  public void onSwiped(final RecyclerView.ViewHolder viewHolder,
                       final int direction) {
    _adapter.onItemDismiss(viewHolder.getAdapterPosition());
  }

  @Override
  public void clearView(final RecyclerView recyclerView,
                        final RecyclerView.ViewHolder viewHolder) {
    super.clearView(recyclerView, viewHolder);

    if (_positionChanged) {
      _adapter.onItemDrop(viewHolder.getAdapterPosition());
      _positionChanged = false;
    }
  }
}
