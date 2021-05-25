package com.mph.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Customer;
import com.mph.entity.WareHouse;

/**
 * 
 * @author KEERTHI
 * @version 1.0
 *
 */
@Repository
public class WareHouseDaoImpl implements WareHouseDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * This method is used to insert inventory in database.
	 * 
	 * @param warehouse this is the first parameter to createWareHouse method
	 * 
	 */

	@Override
	public void createWareHouse(WareHouse warehouse) {
		getSession().save(warehouse);
		System.out.println("WareHouse Stored in DB Successfully !!!1");

	}

	/**
	 * This method is used to insert inventory record in database.
	 * 
	 * @return list of inventories
	 */
	@Override
	public List<WareHouse> getWareHouseList() {
		Query query = getSession().createQuery("select wh from WareHouse wh");
		List<WareHouse> catList = query.list();
		return catList;
	}

	/**
	 * This method is used to get inventory list from the database.
	 * 
	 * @return warehouse
	 */
	@Override
	public WareHouse getWareHouse(WareHouse warehouse) {
		Criteria c = getSession().createCriteria(WareHouse.class);
		c.add(Restrictions.eq("inventoryId", warehouse.getInventoryId()));
		WareHouse cat = (WareHouse) c.uniqueResult();
		return cat;
	}

	/**
	 * This method is used to update the inventory list in database.
	 * 
	 * @return inventory list
	 */
	@Override
	public List<WareHouse> updateWareHouse(WareHouse warehouse) {
		System.out.println("update");
		getSession().update(warehouse);
		return getWareHouseList();
	}

	/**
	 * This method is used to delete inventory record in database.
	 *
	 * @return list of inventories
	 */
	@Override
	public List<WareHouse> deleteWareHouse(int inventoryId) {
		Query query = getSession().createQuery("delete WareHouse wh where inventoryId =:inventoryId");
		query.setParameter("inventoryId", inventoryId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getWareHouseList();
	}

	@Override
	public WareHouse WareHouse(int inventoryId) {
		return (WareHouse) getSession().get(WareHouse.class, inventoryId);
	}

	/**
	 * This method is used to get the inventory record based on id from the
	 * database.
	 * 
	 * @return inventory
	 */
	@Override
	public WareHouse getWareHouseById(int inventoryId) {
		Criteria criteria = getSession().createCriteria(WareHouse.class);
		criteria.add(Restrictions.eq("inventoryId", inventoryId));
		WareHouse warehouse = (WareHouse) criteria.uniqueResult();
		return warehouse;
	}

}