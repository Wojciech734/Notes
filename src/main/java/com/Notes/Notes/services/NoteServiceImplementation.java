package com.Notes.Notes.services;

import com.Notes.Notes.models.Note;
import com.Notes.Notes.models.User;
import com.Notes.Notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImplementation implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserService userService;


    @Override
    public Note createNewNote(Note note, int userId) throws Exception {
        User user = userService.findUserById(userId);
        Note newNote = new Note();
        newNote.setCreatedAt(LocalDateTime.now());
        newNote.setId(note.getId());
        newNote.setUser(user);
        newNote.setContent(note.getContent());
        return noteRepository.save(newNote);
    }

    @Override
    public Note findNoteById(int id) throws Exception{
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        }
        throw new Exception("note doesn't exist!");
    }

    @Override
    public String deleteNote(int noteId, int userId) throws Exception {
        Note note = findNoteById(noteId);
        User user = userService.findUserById(userId);
        if (note.getUser().getId()!=user.getId()) {
            throw new Exception("you can't edit and delete notes that aren't yours!");
        }
        noteRepository.delete(note);
        return "successfully deleted note!";
    }

    @Override
    public Note editNote(Note note, int noteId, int userId) throws Exception {
        Optional<Note> noteToEdit = noteRepository.findById(noteId);

        if (noteToEdit.isEmpty()) {
            throw new Exception("note doesn't exists!");
        }
        Note oldNote = noteToEdit.get();

        if (oldNote.getUser().getId() != userId) {
            throw new Exception("you can't edit notes that aren't yours!");
        }

        if (note.getName() != null) {
            oldNote.setName(note.getName());
        }
        if (note.getContent() != null) {
            oldNote.setContent(note.getContent());
        }
        oldNote.setEditedAt(LocalDateTime.now());
        return noteRepository.save(oldNote);
    }

    @Override
    public List<Note> findAllNotesByUserId(int userId) {
        return noteRepository.findAllByUserId(userId);
    }

    @Override
    public List<Note> searchNotes(String prompt) {
        return List.of();
    }


}
