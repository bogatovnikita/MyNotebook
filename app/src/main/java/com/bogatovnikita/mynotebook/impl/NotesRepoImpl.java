package com.bogatovnikita.mynotebook.impl;

import androidx.annotation.Nullable;

import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.NotesRepo;

import java.util.List;

public class NotesRepoImpl implements NotesRepo {
    @Override
    public List<NoteEntity> getNotes() {
        return null;
    }

    @Override
    public boolean deleteNotes(int id) {
        return false;
    }

    @Nullable
    @Override
    public Integer createNotes(NoteEntity note) {
        return null;
    }

    @Override
    public boolean updateNotes(int id, NoteEntity note) {
        return false;
    }
}
