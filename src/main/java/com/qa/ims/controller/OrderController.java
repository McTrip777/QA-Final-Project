package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
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
		Order order = orderDao.create(new Order(customer_id));
		LOGGER.info("Order created");
		return order;
	}
	
	public void addItem(Long order_id) {
		LOGGER.info("Enter item id");
		Long item_id = utils.getLong();
		orderDao.addItem(item_id, order_id);
	}
	
	public void deleteItem(Long order_id) {
		LOGGER.info("Enter item id");
		Long item_id = utils.getLong();
		orderDao.deleteItem(item_id, order_id);
	}

	@Override
	public Order update() {
		LOGGER.info("Please select the order id you would like to update");
		Long order_id = utils.getLong();
		Order order = orderDao.read(order_id);
		LOGGER.info("Would you like to add/delete an item? Add/Delete/No");
		String isAdding = utils.getString();
		
		if(isAdding.toLowerCase().trim().equals("add")) {
			addItem(order.getId());
		}else if(isAdding.toLowerCase().trim().equals("delete")) {
			deleteItem(order.getId());
		}
		LOGGER.info("Order updated");
		return order;
	}
	
//	public Order readById(Long id) {
//		
//		return order;
//	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDao.delete(id);	
	}

}
