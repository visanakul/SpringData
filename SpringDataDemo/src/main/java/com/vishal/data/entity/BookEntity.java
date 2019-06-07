package com.vishal.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name = "BOOK_MASTER")
@Data
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BOOK_SEQ")
	@SequenceGenerator(sequenceName = "book_id_seq",allocationSize = 1,name = "BOOK_SEQ")
	private Long bookId;
	
	@Column(name = "BOOK_NAME")
	private String name;
	
	@Column(name = "AUTHOR_NAME")
	private String author;
	
	@Column(name="BOOK_PRICE")
	private Double price;
}
