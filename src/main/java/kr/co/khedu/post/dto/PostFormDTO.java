package kr.co.khedu.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class PostFormDTO {
    private final String title;
    private final String content;
}
