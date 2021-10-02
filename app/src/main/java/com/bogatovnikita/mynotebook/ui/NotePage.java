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
    EditText titleEditText;
    EditText noteEditEditText;
    NoteEntity noteEntity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_page_activity);

        initView();

        if (getIntent().getExtras() != null) {
            initItem();
        }
    }

    private void initSaveBotton() {
        Button button = findViewById(R.id.save_note_button);
        button.setOnClickListener(view -> {
            String title = titleEditText.getText().toString();
            String noteEdit = noteEditEditText.getText().toString();
            if (!title.isEmpty() || !noteEdit.isEmpty())
                Repository.repo.createNotes(new NoteEntity(null, title, noteEdit));
            Intent intent = new Intent(NotePage.this, NotepadPages.class);
            startActivity(intent);
        });
    }

    private void initItem() {
        noteEntity = getIntent().getExtras().getParcelable("clickItem");
        titleEditText.setText(noteEntity.getTitle());
        noteEditEditText.setText(noteEntity.getNoteText());
    }

    private void initView() {
        titleEditText = findViewById(R.id.title_edit_text);
        noteEditEditText = findViewById(R.id.note_text_edit_text);
        initSaveBotton();
    }
}
