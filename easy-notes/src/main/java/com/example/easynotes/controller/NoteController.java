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


@Controller
public class NoteController {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserRepository userRepository;

    // Get All Notes
    @GetMapping ("/index")
    public String notesList (Model model) {
        System.out.println("user");
        model.addAttribute("notes", noteRepository.findAll());
        return "/index";
    }

    @PostMapping ("/save/{id}")
    @ResponseBody
    public ResponseEntity create (@RequestBody Note note, @PathVariable (value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        note.setNUsers(userId);
        System.out.println(user.getRoles().getClass());
        if (note.getContent().equals("") || note.getTitle().equals("")) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            try {
                return ResponseEntity.ok(noteRepository.save(note));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
            }
        }
    }

    @PostMapping ("/edit/{id}")
    @ResponseBody
    public ResponseEntity edit (@RequestBody Note note, @PathVariable (value = "id") Long userId) {
        note.setNUsers(userId);
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
    @GetMapping ("/index/{id}")
    public String notesUserList (Model model, @PathVariable (value = "id") Long userId) {
        model.addAttribute("userId", userId);
        model.addAttribute("role", userRepository.findUserRole(userId));
        model.addAttribute("notes", noteRepository.getListNote(userId));
        return "/index";
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
//    @GetMapping ("/delete/{id}")
//    public ResponseEntity<?> deleteNoteGet (@PathVariable (value = "id") Long noteId) {
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//        noteRepository.delete(note);
//        return ResponseEntity.ok().build();
//    }

}
