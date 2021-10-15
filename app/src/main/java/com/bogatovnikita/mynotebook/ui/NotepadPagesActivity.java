package com.bogatovnikita.mynotebook.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bogatovnikita.mynotebook.R;

public class NotepadPagesActivity extends AppCompatActivity {
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad_pages_activity);

        initToolbar();
        initNotepadPageFragment();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.notes_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.new_note_menu) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initNotepadPageFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_notepad_page_container, new NotepadPagesFragment())
                .commit();
    }

}