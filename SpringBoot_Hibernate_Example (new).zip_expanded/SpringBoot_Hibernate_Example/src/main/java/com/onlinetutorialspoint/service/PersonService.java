package com.onlinetutorialspoint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.model.Person;
@Service
public interface PersonService {
	
	public List<Person> getallPerson();
	
	public Person getPersonById(Long id);
	
	public boolean saveOrUpdatePerson(Person person);
	
	public boolean deletePerson(Long id);
}