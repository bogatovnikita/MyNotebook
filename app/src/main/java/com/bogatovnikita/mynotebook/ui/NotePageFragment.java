package com.bogatovnikita.mynotebook.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.Repository;

public class NotePageFragment extends Fragment {
    Integer id;
    EditText titleEditText;
    EditText noteEditEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_page_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleEditText = view.findViewById(R.id.title_edit_text);
        noteEditEditText = view.findViewById(R.id.note_edit_text);
        if (getArguments() != null) {
            id = getArguments().getInt("id");
            titleEditText.setText(getArguments().getString("title"));
            noteEditEditText.setText(getArguments().getString("noteText"));
            Repository.repo.deleteNotes(id);
        } else {
            Button button = view.findViewById(R.id.save_note_button);
            button.setOnClickListener(view1 -> {
                String title = titleEditText.getText().toString();
                String noteEdit = noteEditEditText.getText().toString();
                Repository.repo.createNotes(new NoteEntity(id, title, noteEdit));
            });
        }
    }
}