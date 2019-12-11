package Myself;

public interface List {
	public void add(Object obj);

	public void add(int index, Object obj);

	public void set(int index, Object obj);

	public Object get(int index);
	
	public Object remove(int index);
	
	public int size();
	
	public Iterator iterator();

}
