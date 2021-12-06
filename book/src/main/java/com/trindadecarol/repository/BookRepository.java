package com.trindadecarol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trindadecarol.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}