package kr.co.khedu.country.service;

import kr.co.khedu.country.model.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    List<? extends CountryDTO> selectCountryList();
}
