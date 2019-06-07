package com.vishal.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishal.data.entity.BookEntity;
import com.vishal.data.model.Book;
import com.vishal.data.repository.BookRepository;

@Service
public class BoolServiceImpl implements BookSerive {

	@Autowired
	private BookRepository repository;

	@Override
	public Long save(Book bookModel) {
		BookEntity entity = new BookEntity();
		BeanUtils.copyProperties(bookModel, entity);
		entity = repository.save(entity);
		return entity.getBookId();
	}

	@Override
	public List<Book> getAllBooks() {
		List<BookEntity> bookEntities = repository.findAll();
		List<Book> bookModels = new ArrayList<Book>();
		for (BookEntity bookEntity : bookEntities) {
			Book bookModel = new Book();
			BeanUtils.copyProperties(bookEntity, bookModel);
			bookModels.add(bookModel);
		}
		return bookModels;
	}

	@Override
	public boolean delete(Long bookId) {
		try {
			repository.deleteById(bookId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Book searchById(Long bookId) {
		BookEntity bookEntity = repository.findById(bookId).get();
		if (bookEntity == null)
			return null;
		else {
			Book bookModel = new Book();
			BeanUtils.copyProperties(bookEntity, bookModel);
			return bookModel;
		}
	}

	@Override
	public List<Book> getBooksByAuthorName(String author) {
		List<BookEntity> bookEntities = repository.findByAuthor(author);
		List<Book> bookModels = new ArrayList<Book>();
		for (BookEntity bookEntity : bookEntities) {
			Book bookModel = new Book();
			BeanUtils.copyProperties(bookEntity, bookModel);
			bookModels.add(bookModel);
		}
		return bookModels;
	}

}
