package com.Notes.Notes.restControllers;

import com.Notes.Notes.models.Note;
import com.Notes.Notes.repository.NoteRepository;
import com.Notes.Notes.services.NoteService;
import com.Notes.Notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteRestController {

    @Autowired
    NoteService noteService;

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserService userService;


    @GetMapping("/{userId}")
    public List<Note> findAllNotesByUserId(@PathVariable("userId") int userId) {
        return noteService.findAllNotesByUserId(userId);
    }

    @PostMapping("/create-note/user/{userId}")
    public Note createNote(
            @RequestBody Note note,
            @PathVariable int userId) throws Exception {
        return noteService.createNewNote(note, userId);
    }

    @PutMapping("/edit-note/{noteId}/user/{userId}")
    public Note editNote(
            @RequestBody Note note,
            @PathVariable("noteId") int noteId,
            @PathVariable("userId") int userId) throws Exception {
        return noteService.editNote(note, noteId, userId);
    }

    @DeleteMapping("/delete/{noteId}/user/{userId}")
    public String deleteNote(
            @PathVariable("noteId") int noteId,
            @PathVariable("userId") int userId) throws Exception {
        return noteService.deleteNote(noteId, userId);
    }

}
