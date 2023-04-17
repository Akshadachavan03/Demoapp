package com.onlinetutorialspoint.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.dao.PersonDAO;
import com.onlinetutorialspoint.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
		@Autowired
		PersonDAO persondao;
		
		@Override
		public List<Person> getallPerson() {
			List<Person> Personlist = new ArrayList<>();
			persondao.findAll().forEach(person -> Personlist.add(person));
			return Personlist;
		}

		@Override
		public Person getPersonById(Long id) {
			
			return persondao.findById(id).get();
		}

		@Override
		public boolean saveOrUpdatePerson(Person person) {
			Person updatedPerson = persondao.save(person);
			
			if(persondao.findById(updatedPerson.getId() != null)) {
				return true;
			}
			return false;
		}

		@Override
		public boolean deletePerson(Long id) {
			persondao.deleteById(id);
			
			if(persondao.findById(id) != null) {
				return true;
			}
			return false;
		}
		
		
}
