package com.example.demo.sampleDemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.sampleDemo.model.Student;
import com.example.demo.sampleDemo.repository.IStudentRepository;

@Controller
public class StudentController {
	@Autowired
	IStudentRepository isRepo;
	@GetMapping("/signup")
	public String showSignUpForm(Student student) {
		return "add-student";
	}

	@PostMapping("/addstudent")
	public String addUser(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

		isRepo.save(student);
		model.addAttribute("students", isRepo.findAll());
		return "student-index";
	}
}
