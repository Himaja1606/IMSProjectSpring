package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mph.entity.Customer;
import com.mph.entity.SupplierDetails;

@Service
public interface SupplierDetailsService {
	public void createSupplierDetails(SupplierDetails supplierdetails);

	public List<SupplierDetails> getSupplierDetailsList();

	public SupplierDetails getSupplierDetails(SupplierDetails supplierdetails);

	public List<SupplierDetails> updateSupplierDetails(SupplierDetails supplierdetails);

	public List<SupplierDetails> deleteSupplierDetails(int supplierId);

	public SupplierDetails SupplierDetails(int supplierId);

	public SupplierDetails getSupplierDetailsById(int supplierid);

}