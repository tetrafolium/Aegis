package com.beemdevelopment.aegis.ui.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.beemdevelopment.aegis.R;

public class GroupHolder extends RecyclerView.ViewHolder {
private TextView _slotName;
private ImageView _buttonDelete;

public GroupHolder(final View view) {
	super(view);
	_slotName = view.findViewById(R.id.text_slot_name);
	_buttonDelete = view.findViewById(R.id.button_delete);
}

public void setData(final String groupName) {
	_slotName.setText(groupName);
}

public void setOnDeleteClickListener(final View.OnClickListener listener) {
	_buttonDelete.setOnClickListener(listener);
}
}
