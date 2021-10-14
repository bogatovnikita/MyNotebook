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

public class NotePageActivity extends AppCompatActivity {
    Integer id;
    EditText titleEditText;
    EditText noteEditEditText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_page_activity);

        initView();

        initSaveButton();

    }

    private void initSaveButton() {
        Button button = findViewById(R.id.save_note_button);
        button.setOnClickListener(view -> {

            String title = titleEditText.getText().toString();
            String noteEdit = noteEditEditText.getText().toString();
            Repository.repo.createNotes(new NoteEntity(id, title, noteEdit));

            Intent intent = new Intent(NotePageActivity.this, NotepadPagesActivity.class);
            startActivity(intent);
        });
    }

    private void initView() {
        titleEditText = findViewById(R.id.title_edit_text);
        noteEditEditText = findViewById(R.id.note_edit_text);
        if (getIntent().getExtras() != null) {
            id = getIntent().getIntExtra("id", 1);
            titleEditText.setText(getIntent().getStringExtra("title"));
            noteEditEditText.setText(getIntent().getStringExtra("noteText"));
            Repository.repo.deleteNotes(id);
        }
    }
}
