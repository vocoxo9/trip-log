package kr.co.khedu.product.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class Product {
	private int productId;
	private String name;
	private int price;
	private int stock;
	private String description;
	private Date createdAt;
	private int memberId;
	private int countryId;
	
	public Product(String name, int price, int stock, String description) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
	}
	

}
