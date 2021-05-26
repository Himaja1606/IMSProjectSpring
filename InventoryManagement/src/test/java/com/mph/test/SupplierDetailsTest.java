package com.mph.test;
import com.mph.dao.SupplierDetailsDao;
import com.mph.dao.SupplierDetailsDaoImpl;
import com.mph.entity.SupplierDetails;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.*;                
import org.junit.Test;

import org.junit.BeforeClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SupplierDetailsTest {
	
	static SupplierDetailsDao supplierdetailsDao;
	
	
	@BeforeClass
	public static void setup() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		supplierdetailsDao = (SupplierDetailsDao)context.getBean("supplierdetailsDao");
		
	}
	
	@Test
	public void createSupplierDetails()
	{
		supplierdetailsDao.createSupplierDetails(new SupplierDetails(1,"ram", 9));
		assertEquals(supplierdetailsDao.getSupplierDetailsById(1).getSupplierName(),"keerthyyy");
	}
	@Test
	public void deleteSupplierDetails()
	{
		supplierdetailsDao.deleteSupplierDetails(3);
		assertNull(supplierdetailsDao.getSupplierDetailsById(3));
	}
	

}