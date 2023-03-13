package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Courses> list;
	
	public CourseServiceImpl() {
		
		list=new ArrayList<>();
		list.add(new Courses(33,"Java Course,","This course contains basics of JAVA."));
		list.add(new Courses(34,"Spring Core Course","This course contains basics of Spring."));
		list.add(new Courses(35,"Spring Boot Course","This course contains basics of Spring Boot."));
		
		
	}

	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Courses getCourse(long courseId) {
		Courses c=null;
		for(Courses course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Courses addCourse(Courses co) {
		list.add(co);
		return co;
	}

	@Override
	public void deleteCourse(long ID) {
		//Courses o=new Courses();
		for(Courses cour:list)
		{
			if(cour.getId()==ID)
			{
				list.remove(cour);
				break;
			}
		}
		//return o;
	}


	/*public List<Courses> updateCourse(long id,String title,String discp,Courses cm) {
		//Courses updateCourse = Courses.findId(id);
	
	//Courses oo = null;
	for(Courses obj:list)
	{
		if(obj.getId()==id)
		{
			list.remove(obj);
		
		
		obj.setTitle(obj.getTitle());
		obj.setDescription(obj.getDescription());
		
		}}
		
		Courses updateCourse = new Courses(id,title,discp);

		
			
		return List.of(updateCourse);
	
	}*/
	
	public List<Courses> updateCourse(Courses cm,long id,String title,String discp) {
	for(Courses obj:list)
	{
		if(obj.getId()==id)
		{
		
		obj.setTitle(obj.getTitle());
		obj.setDescription(obj.getDescription());
		
		}}
		
		Courses updateCourse = new Courses(id,title,discp);
	    return List.of(updateCourse);
}

	



}
