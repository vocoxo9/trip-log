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
	private String originFileName;
	private String changeFileName;
	private Date createdAt;
	private int memberId;
	private int countryId;
	
	// 상품 등록
	public Product(String name, int price, int stock, String description, String originFileName, String changeFileName, int memberId, int countryId) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.originFileName = originFileName;
		this.changeFileName = changeFileName;
		this.memberId = memberId;
		this.countryId = countryId;
	}

	public Product(int productId, String name, int price, int stock, String description, String originFileName, String changeFileName) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.originFileName = originFileName;
		this.changeFileName = changeFileName;
	}
}
