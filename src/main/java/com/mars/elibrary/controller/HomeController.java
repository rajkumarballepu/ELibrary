package com.mars.elibrary.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mars.elibrary.dao.LibDao;
import com.mars.elibrary.entity.Librarian;

@Controller
public class HomeController {
	
	@Autowired
	private LibDao dao;
	
	@RequestMapping("/login") 
	public ModelAndView home(@RequestParam("message") String message) {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("login");
		andView.addObject("message", message);
		return andView;
	}
	
	@GetMapping("/") 
	public ModelAndView loginRoute() {
		ModelAndView andView = new ModelAndView();
		andView.addObject("message", "");
		andView.setViewName("redirect:/login");
		return andView;
	}
	
	@PostMapping("/adminLogin")
	public ModelAndView adminLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView view = new ModelAndView();
		if (email.equals("ballepurajkumar@gmail.com") && password.equals("12345")) {
			view.setViewName("admin");
		} else if (email.isBlank() || password.isBlank()) {
			view.addObject("message", "Provide Username and password");
			view.setViewName("redirect:/login");
		} 
		else {
			view.addObject("message", "Invalid Username or password");
			view.setViewName("redirect:/login");
		}
		return view;
	}
	
	@GetMapping("/admin") 
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/addForm") 
	public ModelAndView addLib() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addForm");
		Librarian librarian = new Librarian();
		librarian.setName("");
		librarian.setEmail("");
		librarian.setNumber("");
		modelAndView.addObject("librarian", librarian);
		return modelAndView;
	}
	
	@PostMapping("/addLibrarian")
	public String addLibrarian(@ModelAttribute("librarian") Librarian librarian) {
		dao.addLibrarian(librarian);
		return "admin";
	}
	
	@GetMapping("/viewLibrarians")
	public ModelAndView viewLibrarian() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("librarians");
		List<Librarian> librarians = dao.getLibrarians();
		System.out.println(librarians);
		modelAndView.addObject("librarians1", librarians);
		return modelAndView;
	}
	
	@PostMapping("getLibrarians")
	public String getLibra(@ModelAttribute("librarian") Librarian librarian) {
		System.out.println(librarian);
		dao.updateLibrarian(librarian);
		return "redirect:/viewLibrarians";
	}
	
	@GetMapping("/updateLibrarian")
	public ModelAndView updateLib(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("librarian", dao.getLibrarian(id));
		modelAndView.setViewName("addForm");
		return modelAndView;
	}; 
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Logout successfull..!");
		modelAndView.setViewName("redirect:/login");
		return modelAndView;
	}
	
	
	
}
