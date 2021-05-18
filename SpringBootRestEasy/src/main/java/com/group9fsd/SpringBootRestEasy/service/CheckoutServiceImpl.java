package com.group9fsd.SpringBootRestEasy.service;

import com.group9fsd.SpringBootRestEasy.dao.CustomerRepository;
import com.group9fsd.SpringBootRestEasy.dto.Purchase;
import com.group9fsd.SpringBootRestEasy.dto.PurchaseResponse;
import com.group9fsd.SpringBootRestEasy.entity.Customer;
import com.group9fsd.SpringBootRestEasy.entity.Order;
import com.group9fsd.SpringBootRestEasy.entity.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private CustomerRepository customerRepository;

	@Autowired
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {

		// retrieve the order info from dto
		Order order = purchase.getOrder();

		// generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);

		// populate order with Order items
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));

		// populate order with billing Address and shipping Address
		order.setBillingAddress((purchase.getBillingAddress()));
		order.setShippingAddress(purchase.getShippingAddress());

		// populate customer with order
		Customer customer = purchase.getCustomer();
		customer.add(order);

		// save to the address
		customerRepository.save(customer);

		// return a response
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {

		// generate a random UUID number
		return UUID.randomUUID().toString();
	}
}
