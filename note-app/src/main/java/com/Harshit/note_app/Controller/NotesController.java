package com.Harshit.note_app.Controller;

import com.Harshit.note_app.Model.Notes;
import com.Harshit.note_app.Service.NotesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    // Create Note with Validation
    @PostMapping
    public ResponseEntity<Notes> createNote(@Valid @RequestBody Notes note) {
        return ResponseEntity.ok(notesService.createNote(note));
    }

    // Get Notes with Pagination, Sorting, and Search capabilities
    @GetMapping
    public ResponseEntity<Page<Notes>> getNotes(
            @RequestParam Optional<String> search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "updatedAt") String sortBy
    ) {
        return ResponseEntity.ok(notesService.getAllNotes(search, page, size, sortBy));
    }

    // Get Note by ID
    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable Long id) {
        return notesService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Note with Validation
    @PutMapping("/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable Long id, @Valid @RequestBody Notes noteDetails) {
        try {
            return ResponseEntity.ok(notesService.updateNote(id, noteDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Note
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        notesService.deleteNote(id);
        return ResponseEntity.ok("Note deleted successfully.");
    }
}