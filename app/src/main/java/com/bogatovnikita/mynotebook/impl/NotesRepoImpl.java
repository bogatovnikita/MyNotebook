package com.bogatovnikita.mynotebook.impl;

import androidx.annotation.Nullable;

import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.NotesRepo;

import java.util.ArrayList;
import java.util.List;

public class NotesRepoImpl implements NotesRepo {
    private final ArrayList<NoteEntity> allNotes = new ArrayList<>();
    private int counter = 0;

    @Override
    public List<NoteEntity> getNotes() {
        return new ArrayList<>(allNotes);
    }

    @Override
    public boolean deleteNotes(int id) {
        for (int i = 0; i < allNotes.size(); i++) {
            if (allNotes.get(i).getId() == id) {
                allNotes.remove(i);
                counter--;
                return true;
            }
        }
        return false;
    }

    @Nullable
    @Override
    public Integer createNotes(NoteEntity note) {
        note.setId(++counter);
        allNotes.add(note);
        return counter;
    }

    @Override
    public boolean updateNotes(int id, NoteEntity note) {
        deleteNotes(id);
        note.setId(id);
        allNotes.add(note);
        return true;
    }
}
