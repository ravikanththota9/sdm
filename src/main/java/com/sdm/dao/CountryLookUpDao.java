package com.sdm.dao;

import com.sdm.mapper.CountryLookUpRowMapper;
import com.sdm.model.CountryLookupModel;
import com.sdm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryLookUpDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    User user;

    @Value("${sdmservice.country.insert:query}")
    private String insertCountryQuery;

    @Value("${sdmservice.country.update:query}")
    private String updateCountryQuery;

    @Value("${sdmservice.country.fetch:query}")
    private String fetchAllCountriesQuery;

    @Value("${sdmservice.country.fetchbyid}")
    private String fetchCountryByIdQuery;

    @Value("${sdmservice.country.delete:query}")
    private String deleteCountryByIdQuery;

    public void insertCountryData(List<CountryLookupModel> countryLookupModelList) {
        SqlParameterSource[] countryLookupList = SqlParameterSourceUtils.createBatch(countryLookupModelList.toArray());
        namedParameterJdbcTemplate.batchUpdate(
                insertCountryQuery,
                countryLookupList);
    }

    public void updateCountryData(List<CountryLookupModel> countryLookupModelList) {
        SqlParameterSource[] countryLookupList = SqlParameterSourceUtils.createBatch(countryLookupModelList.toArray());
        namedParameterJdbcTemplate.batchUpdate(
                updateCountryQuery,
                countryLookupList);
    }

    public List<CountryLookupModel> fetchAllCountryData() {
        List<CountryLookupModel> countryLookupModels = jdbcTemplate.query(
                fetchAllCountriesQuery,
                new CountryLookUpRowMapper());
        return countryLookupModels;
    }

    public List<CountryLookupModel> fetchCountryDataById(Integer id) {
        List<CountryLookupModel> countryLookupModels = jdbcTemplate.query(
                fetchCountryByIdQuery,
                new Object[] { id },
                new CountryLookUpRowMapper());
        return countryLookupModels;
    }

    public void deleteCountryData(Integer id) {
        jdbcTemplate.update(
                deleteCountryByIdQuery,
                id);
    }
}
