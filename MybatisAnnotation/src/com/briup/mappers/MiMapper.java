package com.briup.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.briup.bean.Mi;

public interface MiMapper {
//	public List<Mi> selectAllMi();
		
	@Insert("insert into t_mi values(#{miId},#{name},#{points})")
	int insertMi(Mi mi);
	
	@Select("select * from t_mi")
	List<Mi> selectAllMi();
	
	@Delete("delete from t_mi where mi_id= #{id}")
	int deleteMi(Integer id);
	
	@Update("update t_mi set name=#{name},points=#{points} where mi_id=#{miId} ")
	int updateMi(Mi mi);
}
