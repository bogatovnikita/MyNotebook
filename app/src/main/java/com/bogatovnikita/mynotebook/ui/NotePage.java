package com.bogatovnikita.mynotebook.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.Repository;

public class NotePage extends AppCompatActivity {
    private String title = "";
    private String noteEdit = "";
    EditText titleEditText;
    EditText noteEditEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_page);
        titleEditText = findViewById(R.id.title_edit_text);
        noteEditEditText = findViewById(R.id.note_text_edit_text);
        savedNote();
    }

    private void savedNote() {
        Button button = findViewById(R.id.save_note_button);
        button.setOnClickListener(view -> {
            title = titleEditText.getText().toString();
            noteEdit = noteEditEditText.getText().toString();
            Repository.repo.createNotes(new NoteEntity(null, title, noteEdit));
            Intent intent = new Intent(NotePage.this, NotepadPages.class);
            startActivity(intent);
        });
    }
}
