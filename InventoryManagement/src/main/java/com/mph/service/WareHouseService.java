package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mph.entity.Customer;
import com.mph.entity.WareHouse;

@Service
public interface WareHouseService {
	public void createWareHouse(WareHouse warehouse);

	public List<WareHouse> getWareHouseList();

	public WareHouse getWareHouse(WareHouse warehouse);

	public List<WareHouse> updateWareHouse(WareHouse warehouse);

	public List<WareHouse> deleteWareHouse(int inventoryId);

	public WareHouse WareHouse(int inventoryId);

	public WareHouse getWareHouseById(int inventoryId);
}