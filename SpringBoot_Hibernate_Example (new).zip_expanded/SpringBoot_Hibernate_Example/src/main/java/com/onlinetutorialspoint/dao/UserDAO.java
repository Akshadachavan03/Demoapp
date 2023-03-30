package com.onlinetutorialspoint.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.User;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, Long >{

	
	boolean findById(boolean b);
	
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
