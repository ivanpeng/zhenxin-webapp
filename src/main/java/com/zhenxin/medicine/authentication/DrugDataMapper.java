package com.zhenxin.medicine.authentication;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class DrugDataMapper implements RowMapper<DrugItem>{


	public DrugItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		//TODO: do mapping here.
		DrugItem drugItem = new DrugItem();
		drugItem.setDrugKey(rs.getInt("Drug_ID"));
		drugItem.setDrugName(rs.getString("Drug_Name"));
		drugItem.setEnteredByKey(rs.getInt("Entered_By"));
		drugItem.setInfo(rs.getString("Info"));
		
		return drugItem;
	}

}
