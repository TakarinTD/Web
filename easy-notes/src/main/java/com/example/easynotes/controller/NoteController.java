package com.example.easynotes.controller;

import com.example.easynotes.exception.*;
import com.example.easynotes.model.*;
import com.example.easynotes.repository.*;
import java.util.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    @Autowired
    NoteRepository noteRepository;
    // Get All Notes
   @GetMapping("/")
    public String notesList(Model model,@RequestParam(defaultValue = "0") int page ) {
        model.addAttribute("notes",noteRepository.findAll());
        return "index";
    }

    @PostMapping("/save")
    public String save(Note note){
       noteRepository.save(note);
       return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") long id){
        Note note = noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
        noteRepository.delete(note);
        return "redirect:/";
    }

    @GetMapping ("/findOne/{id}")
    @ResponseBody
    public Note getNoteById (@PathVariable (value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }
    // Get All Notes
//    @GetMapping("/notes")
//    public List<Note> getAllNotes() {
//        return noteRepository.findAll();
//    }
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
//    @DeleteMapping ("/notes/{id}")
//    public ResponseEntity<?> deleteNote (@PathVariable (value = "id") Long noteId) {
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        noteRepository.delete(note);
//
//        return ResponseEntity.ok().build();
//    }

}
