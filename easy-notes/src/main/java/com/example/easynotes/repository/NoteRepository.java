package com.example.easynotes.repository;

import com.example.easynotes.model.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query (value = "select notes.id, notes.content, notes.title, notes.date, notes.created_at, notes.updated_at, notes.n_users_id from notes where notes.n_users_id=?1", nativeQuery = true)
    List<Note> getListNote (long userId);
}
