package com.mars.elibrary.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mars.elibrary.dao.LibDao;
import com.mars.elibrary.entity.Book;
import com.mars.elibrary.entity.Borrower;
import com.mars.elibrary.entity.Librarian;

@Controller
public class LibrarianController {
	
	private Librarian librarian;
	
	@Autowired
	private LibDao dao;
	
	@GetMapping("/librarian")
	public ModelAndView librarianLogin(@RequestParam("message") String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("loginLibrarian");
		return modelAndView;
	}
	
	@PostMapping("/librarianLogin")
	public ModelAndView lbrnLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView modelAndView = new ModelAndView();
		librarian = dao.librarian(email,password);
		if (librarian != null) {
			modelAndView.addObject("librarian", librarian);
			modelAndView.setViewName("librarian");
		} else {
			modelAndView.addObject("message", "Invalid username or password");
			modelAndView.setViewName("redirect:/librarian");
		}
		return modelAndView;
	}
	
	@GetMapping("/librarian/addBook")
	public ModelAndView addBook(@RequestParam("message") String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.addObject("librarian", librarian);
		modelAndView.setViewName("bookForm");
		return modelAndView; 
	}
	
	@PostMapping("/librarian/saveBook")
	public ModelAndView saveBook(@ModelAttribute("book") Book book) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Book added successfull");
		dao.addBook(book);
		modelAndView.setViewName("redirect:/librarian/addBook");
		return modelAndView;
	};
	
	@GetMapping("/librarianHome")
	public ModelAndView libHome() {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(librarian);
		modelAndView.addObject("librarian", librarian);
		modelAndView.setViewName("librarian");
		return modelAndView;
	}
	
	@GetMapping("/librarian/viewBooks")
	public ModelAndView viewBooks() {
		ModelAndView modelAndView = new ModelAndView();
		List<Book> books = dao.getBooks();
		modelAndView.addObject("books", books);
		modelAndView.addObject("librarian", librarian);
		modelAndView.setViewName("books");
		return modelAndView;
	}
	
	@GetMapping("/librarian/issueBook")
	public ModelAndView issueBook(@RequestParam("m") String message) {
		ModelAndView modelAndView = new ModelAndView();
		List<Book> books = dao.getBooks();
		modelAndView.addObject("books", books);
		modelAndView.addObject("m", message);
		modelAndView.setViewName("issueBook");
		return modelAndView;
	}
	
	@PostMapping("/librarian/issueBook/book")
	public ModelAndView issue(@ModelAttribute("borrower") Borrower borrower) {
		ModelAndView mav = new ModelAndView();
		String date = new SimpleDateFormat().format(new Date()).split(",")[0];
		borrower.setDate(date);
		borrower.setBook_name(dao.getBook(borrower.getBook_id()).getName());
		dao.issueBook(borrower);
		mav.setViewName("redirect:/librarian/issueBook?m=Book issued Successfully");
		return mav;
	}; 
	
	@GetMapping("/librarian/returnBook")
	public ModelAndView returnForm(@RequestParam("m") String m) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("returnForm");
		List<Book> books = dao.getBooks();
		mav.addObject("m", m);
		mav.addObject("books", books);
		return mav;
	}
	
	@PostMapping("/librarian/returnBook/book")
	public ModelAndView returnBook(@ModelAttribute("borrower") Borrower borrower) {
		ModelAndView mav = new ModelAndView();
		String message = "";
		int i = dao.returnBook(borrower);
		if (i > 0) {
			message = "Book returned successfully..";
		} else {
			message = "No details found... Please enter valid details";
		}
		mav.setViewName("redirect:/librarian/returnBook?m="+message);
		return mav;
	}
	
	@GetMapping("/librarian/logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Logout successfull..!");
		modelAndView.setViewName("redirect:/librarian");
		return modelAndView;
	}
}