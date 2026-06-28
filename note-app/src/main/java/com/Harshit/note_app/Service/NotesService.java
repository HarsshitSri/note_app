package com.Harshit.note_app.Service;

import com.Harshit.note_app.Model.Notes;
import com.Harshit.note_app.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    // Create Note
    public Notes createNote(Notes note) {
        return notesRepository.save(note);
    }

    // Get All Notes (with search & pagination)
    public Page<Notes> getAllNotes(Optional<String> keyword, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return keyword.map(k -> notesRepository.searchNotes(k, pageable))
                .orElseGet(() -> notesRepository.findAll(pageable));
    }

    // Get Note by ID
    public Optional<Notes> getNoteById(Long id) {
        return notesRepository.findById(id);
    }

    // Update Note
    public Notes updateNote(Long id, Notes updatedNote) {
        return notesRepository.findById(id).map(note -> {
            note.setTitle(updatedNote.getTitle());
            note.setContent(updatedNote.getContent());
            return notesRepository.save(note);
        }).orElseThrow(() -> new RuntimeException("Note not found with id " + id));
    }

    // Delete Note
    public void deleteNote(Long id) {
        notesRepository.deleteById(id);
    }
}