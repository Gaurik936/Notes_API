package com.example.connectdb.notes.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface notesRepository extends JpaRepository<Notes, Long> {

}
