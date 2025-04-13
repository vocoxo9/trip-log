package kr.co.khedu.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductFavoriteDTO {
	private int productId;
	private int memberId;
}
