package com.mars.elibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mars.elibrary.dao.LibDao;
import com.mars.elibrary.entity.Book;
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
	
	@GetMapping("/addBook")
	public ModelAndView addBook(@RequestParam("message") String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.addObject("librarian", librarian);
		modelAndView.setViewName("bookForm");
		return modelAndView; 
	}
	
	@PostMapping("/saveBook")
	public ModelAndView saveBook(@ModelAttribute("book") Book book) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Book added successfull");
		dao.addBook(book);
		modelAndView.setViewName("redirect:/addBook");
		return modelAndView;
	};
	
	@GetMapping("/librarianHome")
	public ModelAndView libHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("librarian", librarian);
		System.out.println(librarian);
		modelAndView.setViewName("librarian");
		return modelAndView;
	}
}
