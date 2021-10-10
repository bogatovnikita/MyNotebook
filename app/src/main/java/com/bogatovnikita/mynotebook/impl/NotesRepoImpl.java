package com.bogatovnikita.mynotebook.impl;

import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.NotesRepo;

import java.util.ArrayList;
import java.util.List;

public class NotesRepoImpl implements NotesRepo {
    private final ArrayList<NoteEntity> allNotes = new ArrayList<>();

    @Override
    public List<NoteEntity> getNotes() {
        return new ArrayList<>(allNotes);
    }

    @Override
    public void deleteNotes(NoteEntity note) {
        allNotes.remove(note);
    }

    @Override
    public void createNotes(NoteEntity note) {
        deleteNotes(note);
        updateNotes(note);
    }

    @Override
    public void updateNotes(NoteEntity note) {
        allNotes.add(note);
    }
}
