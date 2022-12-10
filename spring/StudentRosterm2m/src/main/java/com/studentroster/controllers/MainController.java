package com.studentroster.controllers;

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

import com.studentroster.models.Clas;
import com.studentroster.models.Dorm;
import com.studentroster.models.Student;
import com.studentroster.services.ClassService;
import com.studentroster.services.DormService;
import com.studentroster.services.StudentService;

@Controller
public class MainController {

	@Autowired
	DormService dormService;

	@Autowired
	StudentService studentService;

	@Autowired
	ClassService classService;

//	======================== DORMS ========================
//	show all
	@GetMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("allDorms", dormService.allDorms());
		return "allDorms.jsp";
	}

//	show one
	@GetMapping("/show/dorm/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneDorm", dormService.getOne(id));
		return "oneDorm.jsp";
	}

//	create dorm
	@GetMapping("/dorm/create")
	public String dorm(Model model) {
		model.addAttribute("dorm", new Dorm());
		return "createDorm.jsp";
	}

	@PostMapping("/dorm/create/success")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/dorm/create";
		}
		Dorm oneDorm = dormService.createDorm(dorm);
		return "redirect:/dorm/show/" + oneDorm.getId();
	}

//	======================== STUDENTS ========================
//	create student
	@GetMapping("/student/create")
	public String student(Model model) {
		model.addAttribute("student", new Student());
		return "createStudent.jsp";
	}

	@PostMapping("/student/create/success")
	public String createStudent(@Valid @ModelAttribute("student") Student student, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "createStudent.jsp";
		}
		Student oneStudent = studentService.createStudent(student);
		return "redirect:/student/show/" + oneStudent.getId();
	}

//	one student
	@GetMapping("/student/show/{id}")
	public String showStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneStudent", studentService.oneStudent(id));
		model.addAttribute("someClasses", studentService.someClasses(studentService.oneStudent(id)));
		return "oneStudent.jsp";
	}

//	======================== CLASSES ========================
//	create class
	@GetMapping("/class/create")
	public String clas(Model model) {
		model.addAttribute("clas", new Clas());
		return "createClass.jsp";
	}

	@PostMapping("/class/create/success")
	public String createClas(@Valid @ModelAttribute("clas") Clas clas, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "createClass.jsp";
		}
		Clas oneClas = classService.createClass(clas);
		return "redirect:/class/show/" + oneClas.getId();
	}

//	all classes
	@GetMapping("/classes")
	public String allClasses(Model model) {
		model.addAttribute("allClasses", classService.allClasses());
		return "allClasses.jsp";
	}

//	one class
	@GetMapping("/class/show/{id}")
	public String oneClass(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneClas", classService.oneClas(id));
		return "oneClass.jsp";
	}

//	======================== CLASSES MANY TO MANY ========================
//	add a class to a student
	@PostMapping("/class/add/{id}")
	public String addClass(@PathVariable("id") Long studentId, @RequestParam(value = "classId") Long classId, Model model) {
		studentService.addClass(studentId, classId);
		return "redirect:/student/show/{id}";
	}

//	delete a class from a student
	@PostMapping("/class/delete/{id}")
	public String delClass(@PathVariable("id") Long studentId, @RequestParam(value = "classId") Long classId, Model model) {
		studentService.delClass(studentId, classId);
		return "redirect:/student/show/{id}";
	}
}
