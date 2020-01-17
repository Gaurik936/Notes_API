package com.example.connectdb.notes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class notesController {

    @Autowired
    notesRepository notesrepository;

    @GetMapping("/notes")
    public List<Notes> getAllNotes(){
        return notesrepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Notes getNote(@PathVariable Long id){
        return notesrepository.findById(id)
                .orElseThrow(() -> new notesException("Note", "id", id));
    }

    @PostMapping("/notes")
    public void createNote(@Valid @RequestBody Notes notes){
        notesrepository.save(notes);
    }

    @PutMapping("/notes/{id}")
    public Notes updateNote(@PathVariable Long id, @Valid @RequestBody Notes noteValue){
        Notes note = notesrepository.findById(id)
                .orElseThrow(() -> new notesException("Note", "id", id));
        note.setContent(noteValue.getContent());
        note.setTitle(noteValue.getTitle());
        Notes updatedNote = notesrepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id){
        notesrepository.deleteById(id);
        return ResponseEntity.ok().build();
    }




}
