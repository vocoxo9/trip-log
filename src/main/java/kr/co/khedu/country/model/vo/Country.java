package kr.co.khedu.country.model.vo;

import lombok.Data;

@Data
public final class Country {
    private final int countryId;
    private final String name;
    private final int continentId;
}
