package com.vishal.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vishal.data.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
	
	public List<BookEntity> findByAuthor(String author);
}
