package com.group9fsd.SpringBootRestEasy.dao;

import java.util.List;

import com.group9fsd.SpringBootRestEasy.entity.Order;

public interface OrdersDAO {
	public List<Order> findAll();
}
