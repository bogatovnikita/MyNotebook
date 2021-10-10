package com.bogatovnikita.mynotebook.domain;

import java.util.List;

public interface NotesRepo {

    List<NoteEntity> getNotes();

    void deleteNotes(NoteEntity note);

    void createNotes(NoteEntity note);

    void updateNotes(NoteEntity note);
}
