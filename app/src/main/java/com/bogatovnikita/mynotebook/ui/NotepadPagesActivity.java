package com.bogatovnikita.mynotebook.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.Repository;

public class NotepadPagesActivity extends AppCompatActivity implements NotepadPagesFragment.Contract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad_list_activity);

        Repository.repo.createNotes(new NoteEntity(null, "Заметка 1", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 2", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 3", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 4", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 1", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 2", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 3", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 4", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 1", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 2", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 3", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 4", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 1", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 2", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 3", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        Repository.repo.createNotes(new NoteEntity(null, "Заметка 4", "Это очень длинная заметка аааааааааааааааааааааааааааааааааааа"));
        initNotepadListFragment();
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
}