package com.zhenxin.medicine.authentication.product;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zhenxin.medicine.authentication.RefDataDao;

public class ProductItemDaoImpl implements RefDataDao<ProductItem> {

	// bad practice to wire in JdbcTemplate...better to send in dataSource, but not multithreading so it's okay.
	private JdbcTemplate jdbcTemplate;
	private String getProductSql;
	private String addProductSql;
	private String removeProductSql;
	private String updateProductSql;
	
	public ProductItem getRefDataById(int id) {
		String query = getProductSql.replace("?", String.valueOf(id));
		List<ProductItem> pItem = jdbcTemplate.query(query, new ProductDataMapper());
		return pItem.get(0);
	}

	/**
	 * This function will add an item to the list. The item will be encrypted with SerialGenerator elsewhere
	 */
	public void addItem(ProductItem item) {
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		cal.add(Calendar.MONTH, 1);
		Date valid_until = new Date(cal.getTimeInMillis());
		// product name, drug key, serial code, checked, valid until, entered on, entered by
		jdbcTemplate.update(addProductSql, new Object[]{item.getProductName(), item.getDrugKey(), item.getSerialCode(), date, valid_until, date, item.getEnteredBy()});
		
		
	}

	public void removeItem(ProductItem item) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This will be used to update the valid_until and any other miscellaneous info
	 */
	public void updateItemById(int id) {
		// TODO Auto-generated method stub
		
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getGetProductSql() {
		return getProductSql;
	}

	public void setGetProductSql(String getProductSql) {
		this.getProductSql = getProductSql;
	}

	public String getAddProductSql() {
		return addProductSql;
	}

	public void setAddProductSql(String addProductSql) {
		this.addProductSql = addProductSql;
	}

	public String getRemoveProductSql() {
		return removeProductSql;
	}

	public void setRemoveProductSql(String removeProductSql) {
		this.removeProductSql = removeProductSql;
	}

	public String getUpdateProductSql() {
		return updateProductSql;
	}

	public void setUpdateProductSql(String updateProductSql) {
		this.updateProductSql = updateProductSql;
	}
	
	

}
