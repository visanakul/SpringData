package com.vishal.data.model;

import lombok.Data;

@Data
public class Book {
	private Long bookId;
	private String name;
	private String author;
	private Double price;
}
