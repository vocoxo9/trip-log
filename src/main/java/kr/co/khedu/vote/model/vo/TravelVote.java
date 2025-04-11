package kr.co.khedu.vote.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelVote {

	private int voteNo;
	private String travelDestination;
	private int userId;
	private Date votingDate;
	
	// => vote-mapper.xml 파일에 SELECT문에서 별칭을 해당 필드명으로 지정해서 DQL문 작성함
	// (별칭을 작성하지 않는다면 resultMap이나 config.xml에서 camelCase로 바꿔주는 설정을 해야됨) = mapUnderscoreToCamelCase설정
	
}
