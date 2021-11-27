package com.bogatovnikita.mynotebook.domain;

import android.app.Application;

import com.bogatovnikita.mynotebook.impl.NotesRepoImpl;

public class Repository extends Application {
    private final NotesRepo repo = new NotesRepoImpl();

    public NotesRepo getRepo() {
        return repo;
    }
}
