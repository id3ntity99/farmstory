package farmstory.dto;

import farmstory.DataTransferObject;

public class ProductDTO implements DataTransferObject {
  private int id;
  private CompanyDTO company;
  private String name;
  private String category;
  private int price;
  private int point;
  private int discountRate;
  private int deliveryFee;
  private int stock;
  private int imageId;
  private ProductImageDTO image;
  private String registerDate;
  private int amount;
  private String placedDate;
  public int getId() {
    return id;
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

public void setId(int id) {
    this.id = id;
  }

  public CompanyDTO getCompany() {
    return company;
  }

  public void setCompany(CompanyDTO company) {
    this.company = company;
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

  public ProductImageDTO getImage() {
    return image;
  }

  public void setImage(ProductImageDTO image) {
    this.image = image;
  }

  public String getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(String registerDate) {
    this.registerDate = registerDate;
  }

  @Override
  public String toString() {
    return "ProductDTO [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price
        + ", point=" + point + ", discountRate=" + discountRate + ", deliveryFee=" + deliveryFee
        + ", stock=" + stock + ", imageId=" + imageId + ", registerDate=" + registerDate + "]";
  }



}
