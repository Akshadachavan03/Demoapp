package com.onlinetutorialspoint.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.onlinetutorialspoint.dao.PersonRepo;
//import com.onlinetutorialspoint.dao.PersonDAO;
import com.onlinetutorialspoint.model.Person;
import com.onlinetutorialspoint.service.PeersonServiceImpl;
import com.onlinetutorialspoint.service.PersonService;



@RestController
public class PersonController{
	
	@Autowired
	PeersonServiceImpl personserviceimpl; 
	

    
		
		@GetMapping("/get")
		public List<Person> getallPerson(){
			return personserviceimpl.getallPerson() ;
			
		}
	

		public Person getPersonById(@PathVariable String Id) {
			return personserviceimpl.getPersonById(Long.parseLong(Id));
			
		}
	
	
		public boolean saveOrUpdatePerson(Person person) {
			return false;
		}
		
		public boolean deletePerson(Long id) {
			return false;
		}
}

/*@Controller
@RequestMapping(value = "/person")
public class PersonController {
	@Autowired
	private PersonDAO personDao;

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Person person = new Person();
			person.setId(id);
			personDao.delete(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully deleted!";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String create(String name, String city) {
		try {
			Person person = new Person();
			person.setName(name);
			person.setCity(city);
			personDao.savePerson(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully saved!";
	}
	@RequestMapping(value = "/allPersons")
	@ResponseBody
	public List<Person> getAllPersons() {
		try {
			return personDao.getAllPersons();
		} catch (Exception ex) {
			return null;
		}
	}
}*/
