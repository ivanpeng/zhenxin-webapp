package com.zhenxin.medicine.authentication;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DrugItemDaoImpl implements DrugDao {

	private JdbcTemplate jdbcTemplate;
	private String getDrugSql;
	
	public DrugItem getDrugById(int id) {
		String query = getDrugSql.replace("?", String.valueOf(id));
		List<DrugItem> list = jdbcTemplate.query(query, new DrugDataMapper());
		// Return the first in the list for now, as we are only looking for one result
		return list.get(0);
	}

	public void addDrugItem(DrugItem drugItem) {
		// TODO Auto-generated method stub

	}

	public void removeDrugItem(DrugItem drugItem) {
		// TODO Auto-generated method stub

	}

	public String getGetDrugSql() {
		return getDrugSql;
	}

	public void setGetDrugSql(String getDrugSql) {
		this.getDrugSql = getDrugSql;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
}
