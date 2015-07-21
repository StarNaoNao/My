package com.myIbatis.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myIbatis.test.dao.IMyMapper;
import com.myIbatis.test.entity.User;

@Service
public class MyService {

	@Autowired
	private IMyMapper imymapper;

	public List<User> getUsers() {

		List<User> users = imymapper.getUsers();
		return users;
	}

	public User getUserByName(String name) {
		User user = imymapper.getUserByName(name);
		return user;
	}

	public List<Map<String, Object>> getAllJqhs() {
		List<Map<String, Object>> list = imymapper.getAllJqhs();
		return list;
	}

}
