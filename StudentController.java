package com.bank.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.bank.account.entity.StudentEntity;
import com.bank.account.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService services;
	
//	Handler method to return model and view with list of all students
	@GetMapping("/students")
	public String getListOfStudents(Model model) {
		model.addAttribute("students", services.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/create")
	public String createStudentForm(Model model) {		
//		To add student form data
		StudentEntity student = new StudentEntity();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudentForm(@ModelAttribute("student") StudentEntity student) {
		services.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable("id") Long student_id, Model model) {
		model.addAttribute("student", services.getStudentById(student_id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudentById(@PathVariable("id") Long student_id, 
			@ModelAttribute("student") StudentEntity student,
			Model model) {
		StudentEntity newlyStudent = services.getStudentById(student_id);
		newlyStudent.setId(student.getId());
		newlyStudent.setFirstName(student.getFirstName());
		newlyStudent.setLastName(student.getLastName());
		newlyStudent.setEmail(student.getEmail());
		services.updateStudent(newlyStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudentById(@PathVariable("id") Long student_id) {
		services.deleteStudentById(student_id);
		return "redirect:/students";
	}
}
