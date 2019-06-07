package com.vishal.data.service;

import java.util.List;

import com.vishal.data.model.Book;

public interface BookSerive {
	public Long  save(Book bookModel);
	public List<Book> getAllBooks();
	public boolean delete(Long bookId);
	public Book searchById(Long bookId);
	public List<Book> getBooksByAuthorName(String author);
}
