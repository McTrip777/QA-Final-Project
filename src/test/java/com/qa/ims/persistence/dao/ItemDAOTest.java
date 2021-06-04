package com.qa.ims.persistence.dao;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	@Mock
	private final ItemDAO DAO = new ItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

//	@Test
//	public void testReadAll() {
//		List<Item> expected = new ArrayList<>();
//		expected.add(new Item(1L, "Camera", 99.99));
//		assertEquals(expected, DAO.readAll());
//	}

	@Test
	public void testRead() {
		
	}

	@Test
	public void testCreate() {
		
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDelete() {
		
	}

	@Test
	public void testReadLatest() {
		
	}
	

}
