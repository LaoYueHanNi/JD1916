package com.briup.mappers;

import java.util.List;

import com.briup.bean.Tutor;

public interface One2ManyMapper {
	public List<Tutor> listTutorsWithCourse();
	public Tutor findTutorById(int id);
}
