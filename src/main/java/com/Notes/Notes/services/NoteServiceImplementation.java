package com.Notes.Notes.services;

import com.Notes.Notes.models.Note;
import com.Notes.Notes.models.User;
import com.Notes.Notes.repository.NoteRepository;
import com.Notes.Notes.repository.UserRepository;
import org.aspectj.weaver.ast.Not;
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
            throw new Exception("cannot delete note with given id!");
        }
        noteRepository.delete(note);
        return "successfully deleted note!";
    }

    @Override
    public Note editNote(Note note, int id) throws Exception {
        return null;
    }

    @Override
    public List<Note> findAllNotesByUserId(int userId) {
//        return noteRepository.findAllNotesByUserId(userId);
        return noteRepository.findAllByUserId(userId);
    }

    @Override
    public List<Note> searchNotes(String prompt) {
        return List.of();
    }


}
