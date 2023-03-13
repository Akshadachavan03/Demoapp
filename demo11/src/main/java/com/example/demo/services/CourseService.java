package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Courses;

@Service
public interface CourseService {
	
	public List<Courses> getCourses();
	
	public Courses getCourse(long courseId);
	
	public Courses addCourse(Courses co);
	
	public Courses updateCourse(long l, Courses cm);
	
	public void deleteCourse(long ID);

}
