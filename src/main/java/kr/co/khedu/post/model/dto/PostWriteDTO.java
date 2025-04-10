package kr.co.khedu.post.model.dto;

import lombok.Data;

@Data
public final class PostWriteDTO {
    private final String title;
    private final String content;
    private final int countryId;
    private final int memberId;
}
