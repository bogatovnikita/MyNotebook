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
    EditText noteEditText;
    private static final String TITLE_TEXT = "TITLE_TEXT";
    private static final String NOTE_TEXT = "NOTE_TEXT";
    Button saveNoteButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_page_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleEditText = view.findViewById(R.id.title_edit_text);
        noteEditText = view.findViewById(R.id.note_edit_text);

        Bundle args = getArguments();
        if (args != null) {
            String titleText = args.getString(TITLE_TEXT);
            String noteText = args.getString(NOTE_TEXT);
            titleEditText.setText(titleText);
            noteEditText.setText(noteText);
        }

        saveNoteButton = view.findViewById(R.id.save_note_button);
        saveNoteButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString();
            String note = noteEditText.getText().toString();
            Repository.repo.createNotes(new NoteEntity(id, title, note));
            getActivity().getSupportFragmentManager().popBackStack();
        });

    }

    public static NotePageFragment newInstance(NoteEntity item) {
        NotePageFragment notePageFragment = new NotePageFragment();
        if (item != null) {
            Bundle bundle = new Bundle();
            bundle.putString(TITLE_TEXT, item.getTitle());
            bundle.putString(NOTE_TEXT, item.getNoteText());
            notePageFragment.setArguments(bundle);
            Repository.repo.deleteNotes(item.getId());
        }
        return notePageFragment;
    }
}
