package com.zhenxin.medicine.authentication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhenxin.medicine.authentication.drug.DrugItem;
import com.zhenxin.medicine.authentication.drug.DrugItemDaoImpl;
import com.zhenxin.medicine.authentication.product.ProductItem;
import com.zhenxin.medicine.authentication.product.ProductItemDaoImpl;
import com.zhenxin.medicine.authentication.product.SerialGenerator;

public class AuthenticationConnector {

	/**
	 * Things to do: add in logging with log4j here.
	 * @param args
	 */
	public static void main(String[] args) {
		// Algorithm is as follows: grab database info, grab drug info, make product info, add product to DB, generate QR
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Database-Module.xml");
		DrugItemDaoImpl dao = (DrugItemDaoImpl) context.getBean("drugDao");
		DrugItem drugItem = dao.getRefDataById(1);
		// generate product now
		ProductItem productItem = generateProduct(drugItem);
		//TODO: add here, but need key generation set first
		ProductItemDaoImpl daop = (ProductItemDaoImpl) context.getBean("productDao");
		daop.addItem(productItem);
		// Generate QR code here.
		ByteArrayOutputStream qrOut = QRCode.from(productItem.getSerialCode()).to(ImageType.PNG).stream();
		try	{
			FileOutputStream fout = new FileOutputStream(new File("src/main/resources/QR_Test.PNG"));
			fout.write(qrOut.toByteArray());
			fout.flush();
			fout.close();
		} catch( IOException iex)	{
			//TODO: close fout properly
			System.out.println("Writing of QR code has failed.");
		}
	}

	/**
	 * This function takes a drug and returns a ProductItem. The DAO will insert this.
	 * @param drugItem
	 * @return
	 */
	public static ProductItem generateProduct (DrugItem drugItem)	{
		ProductItem pItem = new ProductItem();
		pItem.setDrugKey(drugItem.getDrugKey());
		pItem.setEnteredBy(drugItem.getEnteredByKey());
		pItem.setProductName(drugItem.getDrugName());
		//TODO: need key incrementing properties; probably keygen table?
		//pItem.setProductKey(productKey);
		
		try {
			// need to do something with product name
			String enc = SerialGenerator.encrypt(pItem.getProductName());
			pItem.setSerialCode(enc);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pItem;
	}
	
}

