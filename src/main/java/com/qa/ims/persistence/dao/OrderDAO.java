package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long customer_id = resultSet.getLong("customer_id");
		return new Order(id, customer_id);
	}
	
	public String modelFromResult(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("item_id");
		Long customer_id = resultSet.getLong("customer_id");
		String itemName = resultSet.getString("name");
		String itemCost = resultSet.getString("cost");
		return "ItemId: " + id + " CustomerId: " + customer_id + " Name: " + itemName + " Cost: " + itemCost;
	}

	@Override
//	public List<Order> readAll() {
//		try(Connection conn = DBUtils.getInstance().getConnection(); 
//				Statement sm = conn.createStatement();
////				ResultSet rs = sm.executeQuery("SELECT * FROM orders");
//				ResultSet rs2 = sm.executeQuery("SELECT oi.item_id, oi.order_id, i.name, i.cost, o.customer_id "
//						+ "FROM orders AS o, orders_items AS oi, items AS i "
//						+ "WHERE o.id = oi.order_id AND i.id = oi.item_id");){
//			List<Order> orders = new ArrayList<>();
//			while(rs2.next()) {
//				orders.add(modelFromResult(rs2));
//			}
//			return orders;
//		}catch(SQLException e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return new ArrayList<>();
//	}
	public List<Order> readAll() {
		String str = "";
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while(resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
			}catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
		return null;
	}
	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Order create(Order order) {
		try(Connection conn = DBUtils.getInstance().getConnection(); 
				PreparedStatement ps = conn.prepareStatement("INSERT INTO orders(customer_id) Values (?)");){
			ps.setLong(1, order.getCustomer_id());
			ps.executeUpdate();
			return readLatest();
		}catch(SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	public void addItem(Long item_id, Long order_id) {
		try(Connection conn = DBUtils.getInstance().getConnection(); 
				PreparedStatement ps = conn.prepareStatement("INSERT INTO orders_items(order_id, item_id) Values (?, ?)");){
			ps.setLong(1, order_id);
			ps.setLong(2, item_id);
			ps.executeUpdate();
		}catch(SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
	
	}
	
	public int deleteItem(Long item_id, Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"DELETE FROM orders_items "
						+ "WHERE order_id = ? AND item_id = ? "
//						+ "ORDER BY id DESC "
						+ "LIMIT 1");) {
			statement.setLong(1, order_id);
			statement.setLong(2, item_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	

	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE orders SET customer_id = ? WHERE id = ?");) {
			statement.setLong(1, order.getCustomer_id());
			statement.setLong(2, order.getId());
			statement.executeUpdate();
			return read(order.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	// Check that customer id = id 
	// Cascade to delete child elements (Items) 
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
}
