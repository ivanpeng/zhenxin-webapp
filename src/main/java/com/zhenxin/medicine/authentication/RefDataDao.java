package com.zhenxin.medicine.authentication;

public interface RefDataDao<T> {

	public T getRefDataById(int id);
	
	public void addItem(T item);
	
	public void removeItem(T item);
	
	public void updateItemById(int id);
	
}
