package com.bogatovnikita.mynotebook.impl;

import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.NotesRepo;

import java.util.ArrayList;
import java.util.List;

public class NotesRepoImpl implements NotesRepo {
    private final ArrayList<NoteEntity> allNotes = new ArrayList<>();
    private int count = 0;

    @Override
    public List<NoteEntity> getNotes() {
        return new ArrayList<>(allNotes);
    }

    @Override
    public void deleteNotes(Integer id) {
        for (int i = 0; i < allNotes.size(); i++) {
            if (allNotes.get(i).getId().equals(id)) {
                allNotes.remove(i);
            }
        }
    }

    @Override
    public void createNotes(NoteEntity note) {
        note.setId(++count);
        allNotes.add(note);
    }
}
