package com.zhenxin.medicine.authentication;

public interface DrugDao {

	public DrugItem getDrugById(int id);
	
	public void addDrugItem(DrugItem drugItem);
	
	public void removeDrugItem(DrugItem drugItem);
	
}
