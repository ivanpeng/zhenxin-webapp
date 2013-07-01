package com.zhenxin.medicine.authentication.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductDataMapper implements RowMapper<ProductItem> {

	public ProductItem mapRow(ResultSet rs, int row) throws SQLException {
		ProductItem item = new ProductItem();
		item.setProductKey(rs.getInt("Product_ID"));
		item.setProductName(rs.getString("Product_Name"));
		item.setDrugKey(rs.getInt("Drug_Key"));
		item.setSerialCode(rs.getString("Product_Serial"));
		item.setEnteredBy(rs.getInt("Entered_By"));
		return item; 
	}

}

