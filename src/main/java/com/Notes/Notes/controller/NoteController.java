package com.Notes.Notes.controller;

import com.Notes.Notes.models.Note;
import com.Notes.Notes.repository.NoteRepository;
import com.Notes.Notes.services.NoteService;
import com.Notes.Notes.services.UserService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserService userService;

    @GetMapping
    public List<Note> findAllNotes() {
        return null;
    }

    @GetMapping("/{userId}")
    public List<Note> findAllNotesByUserId(@PathVariable("userId") int userId) {
        return noteService.findAllNotesByUserId(userId);
    }

//    @GetMapping("/{noteId}")
//    public Note findNoteById(@PathVariable("noteId") int noteId) throws Exception{
//        return noteService.findNoteById(noteId);
//    }

    @PostMapping("/create-note/{userId}")
    public Note createNote(@RequestBody Note note, @PathVariable int userId) throws Exception {
        return noteService.createNewNote(note, userId);
    }

//    @PostMapping("create-note/{userId}")
//    public ResponseEntity<Note> createNewNote(@RequestBody Note note, @PathVariable int userId) throws Exception {
//        Note newNote = noteService.createNewNote(note, userId);
//        return new ResponseEntity<>(newNote, HttpStatus.ACCEPTED);
//    }

    @PutMapping("/update-note")
    public Note updateNote(@RequestBody Note note) {
        return null;
    }

}
