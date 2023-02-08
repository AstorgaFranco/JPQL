package com.example.demo.service;

import org.aspectj.lang.annotation.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.User;

import jakarta.transaction.Transactional;
import repository.UserRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {  })
@Transactional


public class TestJPA {
	
	    @Autowired
	    private UserRepository repository;

	    private User userJohn;
	    private User userTom;

	    @Before(value = "")
	    public void init() {
	        userJohn = new User();
	        userJohn.setFirstName("John");
	        userJohn.setLastName("Doe");
	        userJohn.setEmail("john@doe.com");
	        userJohn.setAge(22);
	        repository.save(userJohn);

	        userTom = new User();
	        userTom.setFirstName("Tom");
	        userTom.setLastName("Doe");
	        userTom.setEmail("tom@doe.com");
	        userTom.setAge(26);
	        repository.save(userTom);
	    }
	}


