package com.briup.dao;

import com.briup.bean.Line;

public interface ILineMapper {
	public void savaLine(Line line);
	public void deleteLineByOrderId(long orderId);
}
