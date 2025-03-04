package farmstory.dto;

import farmstory.DataTransferObject;

public class OrderDTO implements DataTransferObject {
	
	private int id;
	private String userId;
	private int productId;
	private int amount;
	private String placedDate;
	
	//추가 필드
	private String productName;
    private int productPrice;
    private int deliveryFee;
    private String userName;
    private int totalPrice;
    
    private UserDTO userDTO;
    private ProductDTO prodDTO;
    
    
    
	
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public UserDTO getUserDTO() {
		return this.userDTO;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
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
