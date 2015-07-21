package com.myIbatis.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.myIbatis.test.entity.User;

@Repository
public interface IMyMapper {

	List<User> getUsers();

	User getUserByName(String name);

	List<Map<String, Object>> getAllJqhs();

}
