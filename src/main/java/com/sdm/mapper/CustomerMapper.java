package com.sdm.mapper;

import com.sdm.model.CustomerModel;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<CustomerModel> {

	@Override
	public CustomerModel mapRow(ResultSet rs, int i) throws SQLException {
		CustomerModel c = new CustomerModel();
		c.setId(rs.getInt("ID"));
		c.setCustomerNm(rs.getString("CUSTOMER_NM"));
		c.setAddressLine1(rs.getString("ADDRESS_LINE1"));
		c.setAddressLine2(rs.getString("ADDRESS_LINE2"));
		c.setAddressLine3(rs.getString("ADDRESS_LINE3"));
		c.setCountryId(rs.getInt("COUNTRY_ID"));
		c.setStateId(rs.getInt("STATE_ID"));
		c.setCityNm(rs.getString("CITY_NM"));
		c.setZipCd(rs.getString("ZIP_CD"));
		c.setEmailId(rs.getString("EMAIL_ID"));
		c.setWebsite(rs.getString("WEBSITE"));
		c.setLogoImg(rs.getString("LOGO_IMG"));
		c.setLandLineNbr(rs.getString("LANDLINE_NBR"));
		c.setMobileNbr(rs.getString("MOBILE_NBR"));
		c.setContactFirstNm(rs.getString("CONTACT_FIRST_NM"));
		c.setContactMiddleNm(rs.getString("CONTACT_MIDDLE_NM"));
		c.setContactLastNm(rs.getString("CONTACT_LAST_NM"));
		c.setContactEmailId(rs.getString("CONTACT_EMAIL_ID"));
		c.setContactMobileNbr(rs.getString("CONTACT_MOBILE_NBR"));
		c.setContactLandLineNbr(rs.getString("CONTACT_LANDLINE_NBR"));
		c.setContactDesignation(rs.getString("CONTACT_DESIGNATION"));
		c.setIsDeleted(rs.getInt("IS_DELETED"));
		c.setCreatedDate(rs.getDate("CREATION_TS"));
		c.setCreatedUserId(rs.getInt("CREATION_USER_ID"));
		c.setLastUpdatedDate(rs.getDate("LAST_UPDATE_TS"));
		c.setLastUpdatedUserId(rs.getInt("LAST_UPDATE_USER_ID"));
		return c;
	}

}
