package com.stack_java.studentroster.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stack_java.studentroster.models.Dorm;
import com.stack_java.studentroster.models.Student;
import com.stack_java.studentroster.services.DormService;
import com.stack_java.studentroster.services.StudentService;

@Controller
public class MainController {

	@Autowired
	DormService dormService;

	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public String index(Model model) {

		List<Dorm> allDorms = dormService.allDorms();
		model.addAttribute("allDorms", allDorms);

		return "index.jsp";
	}

	@GetMapping("/dorm/create")
	public String dorm(@ModelAttribute("dorm") Dorm dorm) {
		return "createDorm.jsp";
	}

	@PostMapping("/dorm/create/success")
	public String dormCreate(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if (result.hasErrors()) {
			return "createDorm.jsp";
		}
		dormService.createDorm(dorm);

		return "redirect:/";
	}

	@GetMapping("/student/create")
	public String student(@ModelAttribute("student") Student student, Model model) {

		List<Dorm> allDorms = dormService.allDorms();
		model.addAttribute("allDorms", allDorms);

		return "newStudent.jsp";
	}

	@PostMapping("/student/create/success")
	public String studentCreate(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "newStudent.jsp";
		}

		studentService.createStudent(student);

		return "redirect:/";
	}

	@GetMapping("/dorm/show/{id}")
	public String showDorm(@ModelAttribute("student") Student student, @PathVariable("id") Long id, Model model) {
		model.addAttribute("oneDorm", dormService.findDorm(id));

		model.addAttribute("someStudents", studentService.allStudents());

		return "showDorm.jsp";
	}

	@PostMapping("/student/create/{id}")
	public String studentCreate1(@PathVariable("id") Long id,
			@RequestParam(value = "studentId", required = false) Long studentId) {
		Student student = studentService.findStudent(studentId);

		studentService.addToDorm(student, dormService.findDorm(id));

		return "redirect:/";
	}

	@PostMapping("student/delete/{id}")
	public String deleteDorm(@PathVariable("id") Long id) {
		Student student = studentService.findStudent(id);

		studentService.delDorm(student);

		return "redirect:/";
	}
}
