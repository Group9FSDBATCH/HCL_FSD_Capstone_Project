package com.group9fsd.SpringBootRestEasy.service;

import com.group9fsd.SpringBootRestEasy.dto.Purchase;
import com.group9fsd.SpringBootRestEasy.dto.PurchaseResponse;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);

}
