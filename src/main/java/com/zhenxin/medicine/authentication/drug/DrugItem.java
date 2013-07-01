package com.zhenxin.medicine.authentication.drug;

public class DrugItem {
	
	private String drugName;
	private int drugKey;
	private String warningLevel;
	private String info;
	private int enteredByKey;
	
	public DrugItem()	{
		super();
	}
	
		
	@Override
	public String toString() {
		return "Drug name is " + drugName + " and extra info is as follows: " + info;
	}



	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getDrugKey() {
		return drugKey;
	}
	public void setDrugKey(int drugKey) {
		this.drugKey = drugKey;
	}
	public String getWarningLevel() {
		return warningLevel;
	}
	public void setWarningLevel(String warningLevel) {
		this.warningLevel = warningLevel;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getEnteredByKey() {
		return enteredByKey;
	}
	public void setEnteredByKey(int enteredByKey) {
		this.enteredByKey = enteredByKey;
	}
	
	
	
}
