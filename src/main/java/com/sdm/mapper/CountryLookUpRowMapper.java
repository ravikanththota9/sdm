package com.sdm.mapper;

import com.sdm.model.CountryLookupModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryLookUpRowMapper implements RowMapper<CountryLookupModel> {

    @Override
    public CountryLookupModel mapRow(ResultSet resultSet, int i) throws SQLException {
        CountryLookupModel c = new CountryLookupModel();
        c.setCountryId(resultSet.getInt("id"));
        c.setCountryCode(resultSet.getString("COUNTRY_CD"));
        c.setCountryName(resultSet.getString("COUNTRY_NM"));
        c.setCreatedDate(resultSet.getDate("CREATION_TS"));
        c.setCreatedUserId(resultSet.getInt("CREATION_USER_ID"));
        c.setLastUpdatedDate(resultSet.getDate("LAST_UPDATE_TS"));
        c.setLastUpdatedUserId(resultSet.getInt("LAST_UPDATE_USER_ID"));
        c.setIsDeleted(resultSet.getInt("IS_DELETED"));
        return c;
    }
}
