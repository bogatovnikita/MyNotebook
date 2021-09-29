package com.bogatovnikita.mynotebook.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.NotesRepo;
import com.bogatovnikita.mynotebook.impl.NotesRepoImpl;

public class NotePage extends AppCompatActivity {
    String title = "";
    String noteEdit = "";
    private NotesRepo repo = new NotesRepoImpl();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_page);

        initEditText();
        repo.createNotes(new NoteEntity(null, title, noteEdit));
    }

    private void initEditText() {
        EditText titleEditText = findViewById(R.id.title_edit_text);
        titleEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.concat(titleEditText.getText().toString());
            }
        });
        EditText noteEditEditText = findViewById(R.id.note_text_edit_text);
        noteEditEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteEdit.concat(noteEditEditText.getText().toString());
            }
        });
    }
}
