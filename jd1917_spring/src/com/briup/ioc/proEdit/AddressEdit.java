package com.briup.ioc.proEdit;

import java.beans.PropertyEditorSupport;

import com.briup.bean.Address;

//属性转换器(把字符串转化为对象)
public class AddressEdit extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text!=null) {
			String[] str = text.split(",");
			Address a = new Address();
			a.setCity(str[0]);
			a.setStreet(str[1]);
			setValue(a);
		}
	}
	
	
}
