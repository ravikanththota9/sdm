package com.sdm.mapper;

import com.sdm.model.StateLookupModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateLookUpRowMapper implements RowMapper<StateLookupModel> {

	@Override
	public StateLookupModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		StateLookupModel c = new StateLookupModel();
		c.setStateId(rs.getInt("ID"));
		c.setStateCode(rs.getString("STATE_CD"));
		c.setStateName(rs.getString("STATE_NM"));
		c.setCreatedDate(rs.getDate("CREATION_TS"));
		c.setCreatedUserId(rs.getInt("CREATION_USER_ID"));
		c.setLastUpdatedDate(rs.getDate("LAST_UPDATE_TS"));
		c.setLastUpdatedUserId(rs.getInt("LAST_UPDATE_USER_ID"));
		c.setCountryLookupId(rs.getInt("COUNTRY_LOOKUP_ID"));
		c.setIsDeleted(rs.getInt("IS_DELETED"));
		return c;

	}
}