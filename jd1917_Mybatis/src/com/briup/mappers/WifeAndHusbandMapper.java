package com.briup.mappers;

import com.briup.bean.Husband;
import com.briup.bean.Wife;

public interface WifeAndHusbandMapper {
	public Wife selectWifeAndHusband(int id);
	
	public Wife findWife(int id);
	
	public void insertHusband(Husband husband);
	public void insertWife(Wife wife);
}
