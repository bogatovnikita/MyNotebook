package com.bogatovnikita.mynotebook.domain;

public class NoteEntity {

    private String title;
    private String noteText;

    public NoteEntity(String title, String noteText) {
        this.title = title;
        this.noteText = noteText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

}
