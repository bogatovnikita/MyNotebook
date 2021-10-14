package com.bogatovnikita.mynotebook.domain;

import java.util.List;

import javax.annotation.Nullable;

public interface NotesRepo {

    List<NoteEntity> getNotes();

    void deleteNotes(Integer id);

    @Nullable Integer createNotes(NoteEntity note);

    void updateNotes(@Nullable Integer id, NoteEntity note);
}
