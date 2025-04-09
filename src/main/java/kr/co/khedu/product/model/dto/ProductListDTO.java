package kr.co.khedu.product.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductListDTO {
	private int productId;
	private String name;
	private int price;
	private Date createdAt;
	private double score;
}
