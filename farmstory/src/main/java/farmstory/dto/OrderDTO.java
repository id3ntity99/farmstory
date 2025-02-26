package farmstory.dto;

import farmstory.DataTransferObject;

public class OrderDTO implements DataTransferObject {
	
	private int id;
	private String userId;
	private int productId;
	private int amount;
	private String placedDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPlacedDate() {
		return placedDate;
	}
	public void setPlacedDate(String placedDate) {
		this.placedDate = placedDate;
	}
	
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", userId=" + userId + ", productId=" + productId + ", amount=" + amount
				+ ", placedDate=" + placedDate + "]";
	}
	

}
