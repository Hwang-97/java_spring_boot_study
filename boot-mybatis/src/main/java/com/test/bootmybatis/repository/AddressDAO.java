package com.test.bootmybatis.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {

	private SqlSessionTemplate template;
	
	@Autowired
	public AddressDAO(SqlSessionTemplate template) {
		this.template = template;
	}
	
}
