package com.bogatovnikita.mynotebook.ui;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;

public class NotepadPagesActivity extends AppCompatActivity implements NotepadPagesFragment.Contract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad_list_activity);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initNotepadListFragment();
        } else {
            initNotepadListFragmentLand();
            openNewNoteLand(null);
        }
    }

    protected void initNotepadListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_notepad_list_container, new NotepadPagesFragment())
                .commit();
    }

    @Override
    public void openNewNote(NoteEntity item) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_notepad_list_container, NotePageFragment.newInstance(item))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void openNewNoteLand(NoteEntity item) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_notepad_list_container_two, NotePageFragment.newInstance(item))
                .addToBackStack(null)
                .commit();
    }

    protected void initNotepadListFragmentLand() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_notepad_list_container, new NotepadPagesFragment())
                .commit();
    }
}