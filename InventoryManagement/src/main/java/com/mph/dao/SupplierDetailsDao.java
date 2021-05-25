package com.mph.dao;

import java.util.List;

import com.mph.entity.Customer;
import com.mph.entity.SupplierDetails;

public interface SupplierDetailsDao {
	public void createSupplierDetails(SupplierDetails supplierdetails);

	public List<SupplierDetails> getSupplierDetailsList();

	public SupplierDetails getSupplierDetails(SupplierDetails supplierdetails);

	public List<SupplierDetails> updateSupplierDetails(SupplierDetails supplierdetails);

	public List<SupplierDetails> deleteSupplierDetails(int supplierId);

	public SupplierDetails SupplierDetails(int supplierId);

	public SupplierDetails getSupplierDetailsById(int supplierId);
}