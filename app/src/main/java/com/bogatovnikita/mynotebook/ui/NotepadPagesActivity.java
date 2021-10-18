package com.bogatovnikita.mynotebook.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bogatovnikita.mynotebook.R;

public class NotepadPagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad_list_activity);

       initNotepadListFragment();
    }

    protected void initNotepadListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_notepad_list_container, new NotepadPagesFragment())
                .commit();
    }

    private void initNotePageScreenFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_notepad_list_container, new NotePageFragment())
                .commit();
    }

}