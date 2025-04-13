package kr.co.khedu.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberFavoriteProductDTO {
	private int productId;
	private String productName;
	private int price;
	private int stock;
}
