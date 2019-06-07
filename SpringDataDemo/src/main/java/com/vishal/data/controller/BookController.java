package com.vishal.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vishal.data.model.Book;
import com.vishal.data.properties.AppProperties;
import com.vishal.data.service.BookSerive;

@Controller
public class BookController {
	@Autowired
	private AppProperties props;

	@Autowired
	private BookSerive service;

	@GetMapping(value = { "/", "/home" })
	public String showHomePage(Model model, @ModelAttribute("msg") String msg) {
		model.addAttribute("book", new Book());
		List<Book> bookModels = service.getAllBooks();
		model.addAttribute("bookList", bookModels);
		model.addAttribute("msg", msg);
		return "books";
	}

	@PostMapping("/save")
	private String saveOrUpdateBookRecord(@ModelAttribute("book") Book book, RedirectAttributes ra) {
		System.out.println("Received : " + book);
		Long bookId = service.save(book);
		if (book.getBookId() == null) {
			if (bookId > 0) {
				ra.addFlashAttribute("msg", props.getProperties().get("saveSuccessMsg"));
			}
			ra.addFlashAttribute("msg", props.getProperties().get("saveFailMsg"));
		} else {
			if (bookId > 0) {
				ra.addFlashAttribute("msg", props.getProperties().get("updateSuccessMsg"));
			} else {
				ra.addFlashAttribute("msg", props.getProperties().get("updateFailsMsg"));
			}
		}

		System.out.println("Saved ID: " + bookId);

		return "redirect:/";
	}

	@GetMapping("/update")
	private String updateBookRecord(@RequestParam("bookId") Long bookId, Model model) {
		Book book = service.searchById(bookId);
		if (book == null) {
			model.addAttribute("book", new Book());
			model.addAttribute("msg", props.getProperties().get("bookSearchFailMsg"));
		} else {
			model.addAttribute("book", book);
		}
		List<Book> bookModels = service.getAllBooks();
		model.addAttribute("bookList", bookModels);

		return "books";
	}

	@GetMapping("/delete")
	private String deleteBookRecord(@RequestParam("bookId") Long bookId, RedirectAttributes ra) {
		System.out.println("Received ID : " + bookId);
		if (service.delete(bookId)) {
			ra.addFlashAttribute("msg", props.getProperties().get("deleteSuccessMsg"));
		} else {
			ra.addFlashAttribute("msg", props.getProperties().get("deleteFailMsg"));
		}
		return "redirect:/";
	}

	@GetMapping("/getByAuthor")
	public @ResponseBody List<Book> getBooksByAuthorName(@RequestParam("author") String author) {
		return service.getBooksByAuthorName(author);
	}
}
