package kr.co.khedu.product.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	private int productReivewId;
	private double score;
	private int memberId;
	private int productId;

	public Review(double score, int memberId, int productId) {
		this.score = score;
		this.memberId = memberId;
		this.productId = productId;
	}
}
