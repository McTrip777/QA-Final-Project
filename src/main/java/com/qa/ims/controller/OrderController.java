package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDao;
	private Utils utils;
	
	public OrderController(OrderDAO orderDao, Utils utils) {
		super();
		this.orderDao = orderDao;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDao.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the customer id");
		Long customer_id = utils.getLong();
		List<Item> itemList = new ArrayList<>();
		Order order = orderDao.create(new Order(customer_id, itemList));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the customer id you would like to change");
		Long customer_id = utils.getLong();
		List<Item> itemList = new ArrayList<>();
		Order order = orderDao.create(new Order(customer_id, itemList));
		LOGGER.info("Order updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDao.delete(id);	
	}

}
