package com.mph.dao;

import java.util.List;

import com.mph.entity.Customer;
import com.mph.entity.WareHouse;

public interface WareHouseDao {

	public void createWareHouse(WareHouse warehouse);

	public List<WareHouse> getWareHouseList();

	public WareHouse getWareHouse(WareHouse warehouse);

	public List<WareHouse> updateWareHouse(WareHouse warehouse);

	public List<WareHouse> deleteWareHouse(int inventoryId);

	public WareHouse WareHouse(int inventoryId);

	public WareHouse getWareHouseById(int inventoryId);
}