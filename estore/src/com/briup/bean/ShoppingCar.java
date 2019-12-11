package com.briup.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * 
 * @ClassName: ShoppingCar	���ﳵ�� �������
 *
 */
public class ShoppingCar {
	// key ��Ʒid value �������Ʒ��������
	private Map<Integer, OrderLine> map = new HashMap<Integer, OrderLine>();
	
	/**
	 * ���ﳵ����Ӳ�Ʒ
	 * ���жϹ��ﳵ����û�иò�Ʒ�Ķ�����Ŀ������У������������ı䣬
	 * ���û����map�����
	 * @param line
	 */
	public void add(OrderLine line){
		if(map.containsKey(line.getBook().getBookId())){
			OrderLine oldline = map.get(line.getBook().getBookId());
			oldline.setNum(oldline.getNum()+1);
		}else{
			line.setNum(1);
			map.put(line.getBook().getBookId(), line);
		}
	}
	/**
	 * ɾ������
	 */
	public void delete(Long bookId){
		map.remove(bookId);
	}
	/**
	 * ��ȡ��Ǯ
	 */
	public double getCost(){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Integer key = iter.next();
			OrderLine value = map.get(key);
			Integer num = value.getNum();
			double price = value.getBook().getPrice();
			double lineCost = num*price;
			cost += lineCost;
		}
		return cost;
	}
	/**
	 * ��ȡ���ﳵ�����ж�����
	 * List<Line>
	 */
	public Map<Integer, OrderLine> getLines(){
		return map;
	}
	/**
	 * ��չ��ﳵ
	 */
	public void clear(){
		map.clear();
	}
	
	/**
	 * �޸�ָ��line�е�����
	 */
	public void update(long key,int num){
		OrderLine line = map.get(key);
		if(line!=null){
			line.setNum(num);
		}
	}
	//��ȡ���ﳵ��һ���ж��ٸ���Ʒ
	public int getNum(){
		int num = 0;
		for(OrderLine line:map.values()) {
			num += line.getNum();
		}
		return num;
	}
	
}
