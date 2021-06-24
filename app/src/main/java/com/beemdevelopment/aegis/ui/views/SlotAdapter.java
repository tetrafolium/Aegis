package com.beemdevelopment.aegis.ui.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.beemdevelopment.aegis.R;
import com.beemdevelopment.aegis.db.slots.Slot;
import java.util.ArrayList;

public class SlotAdapter extends RecyclerView.Adapter<SlotHolder> {
private Listener _listener;
private ArrayList<Slot> _slots;

public SlotAdapter(final Listener listener) {
	_listener = listener;
	_slots = new ArrayList<>();
}

public void addSlot(final Slot slot) {
	_slots.add(slot);

	int position = getItemCount() - 1;
	if (position == 0) {
		notifyDataSetChanged();
	} else {
		notifyItemInserted(position);
	}
}

public void updateSlot(final Slot slot) {
	notifyItemChanged(_slots.indexOf(slot));
}

public void removeSlot(final Slot slot) {
	int position = _slots.indexOf(slot);
	_slots.remove(position);
	notifyItemRemoved(position);
}

@Override
public SlotHolder onCreateViewHolder(final ViewGroup parent,
                                     final int viewType) {
	View view = LayoutInflater.from(parent.getContext())
	            .inflate(R.layout.card_slot, parent, false);
	return new SlotHolder(view);
}

@Override
public void onBindViewHolder(final SlotHolder holder, final int position) {
	holder.setData(_slots.get(position));
	holder.setOnEditClickListener(v->{
			int position1 = holder.getAdapterPosition();
			_listener.onEditSlot(_slots.get(position1));
		});
	holder.setOnDeleteClickListener(v->{
			int position12 = holder.getAdapterPosition();
			_listener.onRemoveSlot(_slots.get(position12));
		});
}

@Override
public int getItemCount() {
	return _slots.size();
}

public interface Listener {
void onEditSlot(Slot slot);
void onRemoveSlot(Slot slot);
}
}
