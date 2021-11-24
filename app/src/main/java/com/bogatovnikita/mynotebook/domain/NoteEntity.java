package com.bogatovnikita.mynotebook.domain;

import javax.annotation.Nullable;

public class NoteEntity {

    @Nullable
    private Integer id;
    private String title;
    private String noteText;

    public NoteEntity(@Nullable Integer id, String title, String noteText) {
        this.id = id;
        this.title = title;
        this.noteText = noteText;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
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
