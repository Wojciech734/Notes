package com.Notes.Notes.services;

import com.Notes.Notes.models.Note;

import java.util.List;

public interface NoteService {

    public Note createNewNote(Note note, int userId) throws Exception;

    public Note findNoteById(int id) throws Exception;

    public String deleteNote(int noteId, int userId) throws Exception;

    public Note editNote(Note note, int id) throws Exception;

    public List<Note> findAllNotesByUserId(int userId);

    public List<Note> searchNotes(String prompt);

}
