package kr.co.khedu.product.model.dto;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author sjsj1
 * mapper의 컬럼 순서와 DTO의 필드 변수들의 순서가 동일할 경우 기본생성자는 필요없다
 * 하지만 순서가 다를 경우 기본생성자가 꼭 필요하다!!
 */

@Data
@AllArgsConstructor
public class ProductListDTO {
	private int productId;
	private String name;
	private int price;
	private String changeFileName;
	private Date createdAt;
	private String countryName;
	private double score;
}