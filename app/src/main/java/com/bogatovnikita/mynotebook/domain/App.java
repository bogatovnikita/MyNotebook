package com.bogatovnikita.mynotebook.domain;

import android.app.Application;

import com.bogatovnikita.mynotebook.data.NotesRepoImpl;

public class App extends Application {
    private final NotesRepo repo = new NotesRepoImpl();

    public NotesRepo getRepo() {
        return repo;
    }
}
