package farmstory.dto;

import farmstory.DataTransferObject;

public class ProductDTO implements DataTransferObject {

	private int id;
	private int company_id;
	private String name;
	private String category;
	private int price;
	private int point;
	private int discountRate;
	private int deliveryFee;
	private int stock;
	private int imageId;
	private String registerDate;

	private String thumbnailLocation; // 썸네일 이미지 경로
	private String infoLocation; // 상품 정보 이미지 경로
	private String detailLocation;

	public String getThumbnailLocation() {
		return thumbnailLocation;
	}

	public void setThumbnailLocation(String thumbnailLocation) {
		this.thumbnailLocation = thumbnailLocation;
	}

	public String getInfoLocation() {
		return infoLocation;
	}

	public void setInfoLocation(String infoLocation) {
		this.infoLocation = infoLocation;
	}

	public String getDetailLocation() {
		return detailLocation;
	}

	public void setDetailLocation(String detailLocation) {
		this.detailLocation = detailLocation;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public int getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", point="
				+ point + ", discountRate=" + discountRate + ", deliveryFee=" + deliveryFee + ", stock=" + stock
				+ ", imageId=" + imageId + ", registerDate=" + registerDate + "]";
	}

}
