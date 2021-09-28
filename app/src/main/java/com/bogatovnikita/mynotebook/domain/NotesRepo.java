package com.bogatovnikita.mynotebook.domain;

import java.util.List;

import javax.annotation.Nullable;

public interface NotesRepo {

    List<NoteEntity> getNotes();

    boolean deleteNotes(int id);

    @Nullable
    Integer createNotes(NoteEntity note);

    boolean updateNotes(int id, NoteEntity note);
}
