package com.qa.ims.persistence.domain;

public class Order {
	private Long id;
	private Long customer_id;
//	private List<Item> itemList = new ArrayList<>();
	
	public Order(Long customer_id) {
		this.setCustomer_id(customer_id);
//		this.itemList = new ArrayList<>();
	}
	
	public Order(Long id, Long customer_id) {
		this.setId(id);
		this.setCustomer_id(customer_id);
//		this.itemList = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

//	public List<Item> getItemList() {
//		return itemList;
//	}
//
//	public void setItemList(List<Item> itemList) {
//		this.itemList = itemList;
//	}

	@Override
	public String toString() {
		return "id=" + id + ", customer_id=" + customer_id; 
//				+ ", itemList=" + itemList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (itemList == null) {
//			if (other.itemList != null)
//				return false;
//		} else if (!itemList.equals(other.itemList))
//			return false;
		return true;
	}
	
	
}
