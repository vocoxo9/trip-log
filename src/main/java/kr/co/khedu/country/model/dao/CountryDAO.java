package kr.co.khedu.country.model.dao;

import kr.co.khedu.country.model.dto.CountryDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public final class CountryDAO {
    public List<? extends CountryDTO> selectCountryList(SqlSession session) {
        return session.selectList("countryMapper.selectCountryList");
    }
}
