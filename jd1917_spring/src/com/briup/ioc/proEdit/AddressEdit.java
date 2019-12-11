package com.briup.ioc.proEdit;

import java.beans.PropertyEditorSupport;

import com.briup.bean.Address;

//����ת����(���ַ���ת��Ϊ����)
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
