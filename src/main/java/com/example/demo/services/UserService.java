package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Not found object"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(Long id) {
		if(findById(id) == null) {
			throw new ObjectNotFoundException("There isn't found id");
		}
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	public User update(User obj, Long id) {
		Optional<User> newObj = repository.findById(id);
		obj = updateData(newObj.get(), obj);
		return repository.save(obj);
	}

	private User updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		return newObj;
	}
}
