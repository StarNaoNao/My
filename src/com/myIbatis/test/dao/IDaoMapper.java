package com.myIbatis.test.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IDaoMapper {

	String getStudentByID(String zjid);
}
