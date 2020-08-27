package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.form.*;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class NoteController {

    @Autowired
    NoteRepository noteRepository;
    // Get All Notes
    @RequestMapping(value = {"/notesList"}, method = RequestMethod.GET)
    public String notesList(Model model) {
        model.addAttribute("notes",noteRepository.findAll());
        return "notesList";
    }

    @RequestMapping(value = { "/addNote" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        Note note = new Note();
        model.addAttribute("note", note);

        return "addNote";
    }

    @RequestMapping(value = { "/addNote" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
                             @ModelAttribute("note") Note note) {

        String title = note.getTitle();
        String content = note.getContent();

        if (title != null && title.length() > 0 //
                && content != null && content.length() > 0) {
            Note newNote = new Note(title, content);
            noteRepository.save(newNote);
            return "redirect:/notesList";
        }

        model.addAttribute("errorMessage", "Title & Content is required!");
        return "addNote";
    }

    @RequestMapping(value={"/noteDelete/{id}"})
    public String deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        noteRepository.delete(note);
        return "redirect:/notesList";
    }

    @RequestMapping(value={"/edit/{id}"}, method = RequestMethod.GET)
    public String updateNote(@PathVariable(value = "id") Long noteId,
                             Model model) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        model.addAttribute("note", note);
        return "noteUpdate";
    }

    @RequestMapping(value = {"/noteUpdate/{id}"},method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") long id, @Valid Note note,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            note.setId(id);
            return "noteUpdate";
        }

        noteRepository.save(note);
        model.addAttribute("note", noteRepository.findAll());
        return "redirect:/notesList";
    }

//    @PostMapping("/notesList")
//    public Note createNote(@Valid @RequestBody Note note) {
//        return noteRepository.save(note);
//    }

//    // Get a Single Note
//    @GetMapping("/notes/{id}")
//    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
//        return noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//    }
//
//    // Update a Note
//    @PutMapping("/notes/{id}")
//    public Note updateNote(@PathVariable(value = "id") Long noteId,
//                           @Valid @RequestBody Note noteDetails) {
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
//    @DeleteMapping("/notes/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        noteRepository.delete(note);
//
//        return ResponseEntity.ok().build();
//    }

}
