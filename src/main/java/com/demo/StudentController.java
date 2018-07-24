package com.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;

	@RequestMapping("/")
	public String get() {
		return "Hello spring";
	}
	
	@RequestMapping(value="/getStudent", method = RequestMethod.GET)
	public List<Student> getStudent() {
		List<Student> s = (List<Student>) repo.findAll();
		return s;
	}
	
	@RequestMapping(value="/createStudent", method = RequestMethod.POST)
	public Student createStudent(@Valid @RequestBody Student student) {
		return repo.save(student);
	}
	
	@RequestMapping(value="/deleteStudent", method = RequestMethod.DELETE)
	public String deleteStudent(@RequestParam("id") Long id) {
		repo.delete(id);
		return "Student deleted successfully";
	}
	
	@RequestMapping(value="/updateStudent", method = RequestMethod.PUT)
	public Student updateStudent(@Valid @RequestBody Student student) {
		
		return repo.save(student);
	}
}
