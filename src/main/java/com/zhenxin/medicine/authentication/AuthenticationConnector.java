package com.zhenxin.medicine.authentication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuthenticationConnector {

	private HelloWorld helloWorld;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Database-Module.xml");
		DrugItemDaoImpl dao = (DrugItemDaoImpl) context.getBean("drugDao");
		DrugItem drugItem = dao.getDrugById(1);
		System.out.println(drugItem.toString());

	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	
}
