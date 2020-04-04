package com.sanhui.synitil.workflow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sanhui.synitil.workflow.dto.AcDto;

@Mapper
public interface AcMapper {

	public List<AcDto> getUser();

	public void updateUser(AcDto dto);

	public List<AcDto> getUserById(AcDto dto);

	public List<AcDto> getUserByName(AcDto dto);

	public void saveUser(AcDto dto);

	public void deleteUser(AcDto dto);

}
