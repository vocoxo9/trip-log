package kr.co.khedu.vote.model.vo;

import lombok.Data;

import java.sql.Date;

@Data
public final class Vote {
    private final int voteNo;
    private final String travelDestination;
    private final int userId;
    private final Date votingDate;
}
