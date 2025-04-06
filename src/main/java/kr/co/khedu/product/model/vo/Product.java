package kr.co.khedu.product.model.vo;

import java.util.Date;

import lombok.Data;

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

}
