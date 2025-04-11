package kr.co.khedu.country.service;

import kr.co.khedu.country.model.dao.CountryDAO;
import kr.co.khedu.country.model.dto.CountryDTO;
import kr.co.khedu.template.Template;

import java.util.List;

public final class CountryServiceImpl implements CountryService {
    @Override
    public List<? extends CountryDTO> selectCountryList() {
        var session = Template.getSqlSession();
        var countries = new CountryDAO().selectCountryList(session);
        session.close();
        return countries;
    }
}
