package com.onlinetutorialspoint.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.Person;

@Repository
@Transactional
public interface PersonDAO extends JpaRepository<Person, Long >{

	public static final EntityManagerFactory entityManagerFactory = null;
	
	boolean findById(boolean b);
	
	default EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
}


/*@Repository
@Transactional
public class PersonDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String savePerson(Person person) {
		Long isSuccess = (Long)getSession().save(person);
		if(isSuccess >= 1){
			return "Success";
		}else{
			return "Error while Saving Person";
		}
		
	}

	public boolean delete(Person person) {
		getSession().delete(person);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return getSession().createQuery("from Person").list();
	}
}*/
