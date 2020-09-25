package com.example.easynotes.controller;

import com.example.easynotes.exception.*;
import com.example.easynotes.model.*;
import com.example.easynotes.repository.*;
import java.awt.print.*;
import java.util.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.util.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.*;

@Controller
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    // Get All Notes
    @GetMapping ("/")
    public String notesList (Model model) {
        model.addAttribute("note", noteRepository.findAll());
        return "index";
    }

    @PostMapping ("/save")
    @ResponseBody
    public ResponseEntity createOrEdit(@RequestBody Note note) {
        try {
            return ResponseEntity.ok(noteRepository.save(note));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping ("/findOne/{id}")
    @ResponseBody
    public Note getNoteById (@PathVariable (value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }
    // Get All Notes
    @GetMapping("/notes")
    public ResponseEntity getAllNotes() {
        return new ResponseEntity(noteRepository.findAll(),HttpStatus.OK);
    }
//
//    @PostMapping ("/notesList")
//    public Note createNote (@Valid @RequestBody Note note) {
//        return noteRepository.save(note);
//    }
//
//    // Get a Single Note
//    @GetMapping ("/notes/{id}")
//    public Note getNoteById (@PathVariable (value = "id") Long noteId) {
//        return noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//    }
//
//    // Update a Note
//    @PutMapping ("/notes/{id}")
//    public Note updateNote (@PathVariable (value = "id") Long noteId,
//                            @Valid @RequestBody Note noteDetails) {
//
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        note.setTitle(noteDetails.getTitle());
//        note.setContent(noteDetails.getContent());
//
//        Note updatedNote = noteRepository.save(note);
//        return updatedNote;
//    }
//
//    // Delete a Note
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteNote (@PathVariable (value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }

}
