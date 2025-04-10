package kr.co.khedu.product.model.dto;

import kr.co.khedu.member.model.vo.Member;
import lombok.Data;

@Data
public class MemberDTO extends Member{
	private String countryName;
}
