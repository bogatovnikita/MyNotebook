package com.bogatovnikita.mynotebook.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bogatovnikita.mynotebook.R;

public class NotepadPages extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad_pages);

        initToolbar();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//заменяем штатный тулбар своим
    }

    /**
     * методы для работы меню
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.notes_list_menu, menu);
        return true;//возвращает истину, если меню создано
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.new_note_menu) {
            openNewNote();
            return true;//возвращает истину, если обработали нажатие
        }
        return super.onOptionsItemSelected(item);
    }

    private void openNewNote() {
        Intent intent = new Intent(this, NotePage.class);
        startActivity(intent);
    }
}