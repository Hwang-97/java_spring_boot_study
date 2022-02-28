package com.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.test.thymeleaf.domain.AddressDTO;

@Mapper
public interface IAddressDAO {

	@Select("select count(*) from tblAddress")
	public int num();

	@Select("select name from tblAddress where seq = #{seq}")
	public String name(int seq);

	@Select("select * from tblAddress where seq = #{seq}")
	public AddressDTO get(int seq);

	@Select("select * from tblAddress order by seq asc")
	public List<AddressDTO> list();
	
}
