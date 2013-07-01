package com.zhenxin.medicine.authentication.drug;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zhenxin.medicine.authentication.RefDataDao;

public class DrugItemDaoImpl implements RefDataDao<DrugItem> {

	private JdbcTemplate jdbcTemplate;
	private String getDrugSql;
	
	public DrugItem getRefDataById(int id) {
		String query = getDrugSql.replace("?", String.valueOf(id));
		List<DrugItem> list = jdbcTemplate.query(query, new DrugDataMapper());
		// Return the first in the list for now, as we are only looking for one result
		return list.get(0);
	}

	public void addItem(DrugItem drugItem) {
		// TODO Auto-generated method stub

	}

	public void removeItem(DrugItem drugItem) {
		// TODO Auto-generated method stub

	}

	public void updateItemById(int id) {
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
