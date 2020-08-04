package com.sdm.mapper;

import com.sdm.constants.SDMApplicationConstants;
import com.sdm.model.PartnerModel;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerMapper implements RowMapper<PartnerModel> {

	@Override
	public PartnerModel mapRow(ResultSet rs, int i) throws SQLException {
		PartnerModel p = new PartnerModel();
		p.setCustomerId(rs.getInt("ID"));
		if(SDMApplicationConstants.FRANCHISE_PARTNER_CUSTOMER_TYPE.equalsIgnoreCase(rs.getString("TYPE")))
			p.setPartnerName(rs.getString("FIRST") + " - "+rs.getString("LAST"));
		else
			p.setPartnerName(rs.getString("LAST"));
		return p;
	}

}
