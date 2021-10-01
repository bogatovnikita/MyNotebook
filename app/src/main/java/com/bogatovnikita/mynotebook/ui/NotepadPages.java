package com.bogatovnikita.mynotebook.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.Repository;

public class NotepadPages extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private NotesAdapter adapter = new NotesAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad_pages);

        initToolbar();

        initRecyclerView();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//заменяем штатный тулбар своим
    }

    /**
     * метод для работы меню
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.notes_list_menu, menu);
        return true;//возвращает истину, если меню создано
    }

    /**
     * метод для работы меню
     */
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

    private void onItemClick(NoteEntity item) {
        Intent intent = new Intent(this, NotePage.class);
        intent.putExtra("clickItem", (Parcelable) item);
        startActivity(intent);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this::onItemClick);
        adapter.setData(Repository.repo.getNotes());

    }
}