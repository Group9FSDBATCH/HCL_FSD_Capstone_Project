package com.group9fsd.SpringBootRestEasy.dto;

import lombok.Data;

import java.util.Set;

import com.group9fsd.SpringBootRestEasy.entity.Address;
import com.group9fsd.SpringBootRestEasy.entity.Customer;
import com.group9fsd.SpringBootRestEasy.entity.Order;
import com.group9fsd.SpringBootRestEasy.entity.OrderItem;

@Data
public class Purchase {

	private Customer customer;

	private Address shippingAddress;

	private Address billingAddress;

	private Order order;

	private Set<OrderItem> orderItems;
}
