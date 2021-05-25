package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.SupplierDetailsDao;
import com.mph.entity.SupplierDetails;

@Service
@Transactional
public class SupplierDetailsServiceImpl implements SupplierDetailsService {
	@Autowired
	SupplierDetailsDao supplierdetailsDao;

	@Override
	public void createSupplierDetails(SupplierDetails suptomer) {
		supplierdetailsDao.createSupplierDetails(suptomer);

	}

	@Override
	public List<SupplierDetails> getSupplierDetailsList() {

		return supplierdetailsDao.getSupplierDetailsList();
	}

	@Override
	public SupplierDetails getSupplierDetails(SupplierDetails suptomer) {

		return supplierdetailsDao.getSupplierDetails(suptomer);
	}

	@Override
	public List<SupplierDetails> updateSupplierDetails(SupplierDetails sup) {

		return supplierdetailsDao.updateSupplierDetails(sup);
	}

	@Override
	public List<SupplierDetails> deleteSupplierDetails(int supplierId) {

		return supplierdetailsDao.deleteSupplierDetails(supplierId);
	}

	@Override
	public SupplierDetails getSupplierDetailsById(int supplierId) {
		return supplierdetailsDao.getSupplierDetailsById(supplierId);
	}

	@Override
	public SupplierDetails SupplierDetails(int supplierId) {
		return supplierdetailsDao.SupplierDetails(supplierId);
	}

}
