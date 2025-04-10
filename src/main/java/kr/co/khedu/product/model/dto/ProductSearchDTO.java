package kr.co.khedu.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductSearchDTO {
	private String keyword;
	private String sort;
}
