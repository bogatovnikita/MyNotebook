package com.bogatovnikita.mynotebook.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bogatovnikita.mynotebook.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public TextView titleTextView = itemView.findViewById(R.id.title_text_view);
    public TextView noteTextView = itemView.findViewById(R.id.note_text_view);
}
