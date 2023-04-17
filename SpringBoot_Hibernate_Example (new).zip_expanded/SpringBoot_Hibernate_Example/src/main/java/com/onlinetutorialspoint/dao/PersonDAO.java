package com.onlinetutorialspoint.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.model.Person;



@Repository
@Transactional
public interface PersonDAO extends JpaRepository<Person, Long >{
	
	boolean findById(boolean b);

	
}

