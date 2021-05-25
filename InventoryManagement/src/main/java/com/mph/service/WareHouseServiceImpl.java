package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.WareHouseDao;
import com.mph.entity.Customer;
import com.mph.entity.WareHouse;

@Service
@Transactional
public class WareHouseServiceImpl implements WareHouseService {
	@Autowired
	WareHouseDao warehouseDao;

	@Override
	public void createWareHouse(WareHouse warehouse) {
		warehouseDao.createWareHouse(warehouse);

	}

	@Override
	public List<WareHouse> getWareHouseList() {

		return warehouseDao.getWareHouseList();
	}

	@Override
	public WareHouse getWareHouse(WareHouse warehouse) {

		return warehouseDao.getWareHouse(warehouse);
	}

	@Override
	public List<WareHouse> updateWareHouse(WareHouse ware) {

		return warehouseDao.updateWareHouse(ware);
	}

	@Override
	public List<WareHouse> deleteWareHouse(int inventoryId) {

		return warehouseDao.deleteWareHouse(inventoryId);
	}

	@Override
	public WareHouse getWareHouseById(int inventoryid) {
		return warehouseDao.getWareHouseById(inventoryid);
	}

	@Override
	public WareHouse WareHouse(int inventoryId) {
		return warehouseDao.WareHouse(inventoryId);
	}

}
