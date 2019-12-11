package com.briup.mappers;

import java.util.List;
import java.util.Map;

import com.briup.bean.Student;

public interface ResultMapper {
	public List<Student> listStus();
	public List<String> listName();
	public Map<String,Object> findStuById_map(int id);
	public List<Map<String,Object>> findStuById_mapList();
}
