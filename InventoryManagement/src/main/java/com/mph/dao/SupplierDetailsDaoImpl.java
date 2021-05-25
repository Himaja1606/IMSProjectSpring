package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mph.entity.Customer;
import com.mph.entity.SupplierDetails;
import com.mph.entity.SupplierDetails;

/**
 * 
 * @author KARTHIKEYAN
 * @version 1.0
 *
 */
@Transactional
@Repository
public class SupplierDetailsDaoImpl implements SupplierDetailsDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * This method is used to create supplier details in database.
	 * 
	 * @param supplierdetails object is passed as first parameter to createSupplierDetails
	 *                        method
	 * 
	 */
	@Override
	public void createSupplierDetails(SupplierDetails supplierdetails) {
		getSession().save(supplierdetails);
		System.out.println("SupplierDetails Stored in DB Successfully !!!");

	}

	/**
	 * This method is used to get the supplier details from the database.
	 *
	 * @return list of supplier details
	 */
	@Override
	public List<SupplierDetails> getSupplierDetailsList() {
		Query query = getSession().createQuery("select sd from SupplierDetails sd");
		List<SupplierDetails> supList = query.list();
		return supList;

	}

	/**
	 * This method is used to get the supplier details list from the database.
	 *
	 * @return list of supplier details
	 */
	@Override
	public SupplierDetails getSupplierDetails(SupplierDetails supplierdetails) {
		Criteria c = getSession().createCriteria(SupplierDetails.class);
		c.add(Restrictions.eq("supplierId", supplierdetails.getSupplierId()));
		c.add(Restrictions.eq("supplierName", supplierdetails.getSupplierName()));
		SupplierDetails sup = (SupplierDetails) c.uniqueResult();
		return sup;

	}

	/**
	 * This method is used to update supplier details in the database.
	 *
	 * @return list of supplier details
	 */
	@Override
	public List<SupplierDetails> updateSupplierDetails(SupplierDetails supplierdetails) {
		System.out.println("update");
		getSession().update(supplierdetails);
		return getSupplierDetailsList();
	}

	/**
	 * This method is used to delete supplier details in the database.
	 * 
	 * @return list of supplier details
	 */
	@Override
	public List<SupplierDetails> deleteSupplierDetails(int supplierId) {
		Query query = getSession().createQuery("delete SupplierDetails ce where supplierId=:supplierId");
		query.setParameter("supplierId", supplierId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}

		return getSupplierDetailsList();
	}

	@Override
	public SupplierDetails SupplierDetails(int supplierId) {
		return (SupplierDetails) getSession().get(SupplierDetails.class, supplierId);
	}

	/**
	 * This method is used to get the supplier details by id from the database.
	 * 
	 * @return supplier details
	 */

	@Override
	public SupplierDetails getSupplierDetailsById(int supplierId) {
		Criteria criteria = getSession().createCriteria(SupplierDetails.class);
		criteria.add(Restrictions.eq("supplierId", supplierId));
		SupplierDetails supplierdetails = (SupplierDetails) criteria.uniqueResult();
		return supplierdetails;
	}

}