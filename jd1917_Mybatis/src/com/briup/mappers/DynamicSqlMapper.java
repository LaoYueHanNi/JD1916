package com.briup.mappers;

import java.util.List;
import java.util.Map;

import com.briup.bean.Course;


public interface DynamicSqlMapper {
	//≤‚ ‘if
	List<Course> searchCourses(Map<String, Object> map);
	List<Course> searchCoursesWhere(Map<String, Object> map);
	List<Course> test_trim(Map<String, Object> map);
	List<Course> testWhen(Map<String, Object> map);
	List<Course> searchCoursesByTutors(Map<String,Object> map); 
	void updateCourse(Course course);
	
}
