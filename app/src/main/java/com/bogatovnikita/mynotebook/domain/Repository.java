package com.bogatovnikita.mynotebook.domain;

import com.bogatovnikita.mynotebook.impl.NotesRepoImpl;

public class Repository {
    public static final NotesRepo repo = new NotesRepoImpl();
}
