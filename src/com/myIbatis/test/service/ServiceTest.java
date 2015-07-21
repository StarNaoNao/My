package com.myIbatis.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myIbatis.test.dao.IDaoMapper;

@Service
public class ServiceTest {

	@Autowired
	IDaoMapper iDaoMapper;
	
	public String getName(String zjid){
		return iDaoMapper.getStudentByID(zjid);
	}
}
