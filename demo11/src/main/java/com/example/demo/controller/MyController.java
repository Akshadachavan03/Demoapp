package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Courses;
import com.example.demo.services.CourseService;

@RestController
public class MyController {
	
	@Autowired(required=true)
	private CourseService cs; 
	
	@GetMapping("/home")
	public String home() {
		
		
		return "Welcome to Courses Application!!!";
	}
     //get the courses
	
	
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		return this.cs.getCourses();
	}
	
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) 
	{
		return this.cs.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses co) 
	{
		return this.cs.addCourse(co);
	}
	
	@PutMapping("/courses/{courseId}")
	public Courses updateCourse( @RequestBody Courses cc,@PathVariable String Id) 
	{
	    return this.cs.updateCourse(Long.parseLong(Id),cc);	
	}
	
	@DeleteMapping("/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId)
	{
		 this.cs.deleteCourse(Long.parseLong(courseId));
	}

	
}
