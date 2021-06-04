package com.qa.ims.controllers;

//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;

//import com.qa.ims.controller.OrderController;
//import com.qa.ims.persistence.dao.OrderDAO;
//import com.qa.ims.persistence.domain.Order;
//import com.qa.ims.utils.Utils;

//@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
//	
//	@Mock
//	private OrderDAO orderDao;
//	@Mock
//	private Utils utils;
//	@InjectMocks
//	private OrderController controller;
//	
//	@Test
//	public void readAll() {
//		List<Order> orders = new ArrayList<>();
//		orders.add(new Order(1L, 2L));
//
//		Mockito.when(orderDao.readAll()).thenReturn(orders);
//
//		assertEquals(orders, controller.readAll());
//
//		Mockito.verify(orderDao, Mockito.times(1)).readAll();
//	}
//
//	@Test
//	public void create() {
//		final Long ID = 1L, CUSTOMER_ID = 1L;
//		
//		final Order created = new Order(CUSTOMER_ID);
//		Mockito.when(utils.getLong()).thenReturn(ID, CUSTOMER_ID);
//		Mockito.when(orderDao.create(created)).thenReturn(created);
//
//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(orderDao, Mockito.times(1)).create(created);
//	}
	
	// These are ORDER_ITEM controls
//	@Test
//	public void addItem() {
//		
//	}
//	
//	@Test
//	public void deleteItem() {
//		
//	}

//	@Test
//	public void update() {
//		Order order = new Order(1L, 1L);
//		
//		Mockito.when(utils.getLong()).thenReturn(ID);
//		
////		Mockito.verify(utils, Mockito.times(1)).getLong();
////		Mockito.verify(utils, Mockito.times(1)).getString();
//	}

//	@Test
//	public void delete() {
//		final long ID = 1L;
//		
//		Mockito.when(utils.getLong()).thenReturn(ID);
//		Mockito.when(orderDao.delete(ID)).thenReturn(1);
//
//		assertEquals(1L, controller.delete());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(orderDao, Mockito.times(1)).delete(ID);
//	}

	
}
