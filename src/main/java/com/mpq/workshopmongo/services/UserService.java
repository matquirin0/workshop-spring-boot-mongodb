package com.mpq.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpq.workshopmongo.domain.User;
import com.mpq.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
}
