package kr.co.khedu.product.model.vo;

import java.util.Date;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class Product {
	private int productId;
	private String name;
	private int price;
	private int stock;
	private String description;
	private Date createdAt;
	private int memberId;
	private int countryId;

	public Product() {
		super();
	}

	public Product(int productId, String name, int price, int stock, String description, Date createdAt, int memberId,
			int countryId) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.createdAt = createdAt;
		this.memberId = memberId;
		this.countryId = countryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + ", createdAt=" + createdAt + ", memberId=" + memberId
				+ ", countryId=" + countryId + "]";
	}
}
