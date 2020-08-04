package com.sdm.dao;


import com.sdm.mapper.StateLookUpRowMapper;
import com.sdm.model.StateLookupModel;
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
public class StateLookUpDao {

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	User user;

	@Value("${sdmservice.state.insert:query}")
	private String insertStateQuery;

	@Value("${sdmservice.state.update:query}")
	private String updateStateQuery;

	@Value("${sdmservice.state.fetch:query}")
	private String fetchAllStatesQuery;

	@Value("${sdmservice.state.fetchbycid:query}")
	private String fetchStateByCidQuery;

	@Value("${sdmservice.state.delete:query}")
	private String deleteStateByIdQuery;

	public void insertStateData(List<StateLookupModel> stateLookupModelList) {

		SqlParameterSource[] stateLookupList = SqlParameterSourceUtils.createBatch(stateLookupModelList.toArray());
		namedParameterJdbcTemplate.batchUpdate(insertStateQuery, stateLookupList);

	}

	public void updateStateData(List<StateLookupModel> stateLookupModelList) {
		SqlParameterSource[] stateLookupList = SqlParameterSourceUtils.createBatch(stateLookupModelList.toArray());
		namedParameterJdbcTemplate.batchUpdate(updateStateQuery, stateLookupList);
	}

	public List<StateLookupModel> fetchAllStateData() {
		List<StateLookupModel> stateLookupModels = jdbcTemplate.query(fetchAllStatesQuery, new StateLookUpRowMapper());
		return stateLookupModels;
	}

	public List<StateLookupModel> fetchStateByCidData(Integer countryLookupId) {
		List<StateLookupModel> stateLookupModels = jdbcTemplate.query(fetchStateByCidQuery,
				new Object[] { countryLookupId }, new StateLookUpRowMapper());
		return stateLookupModels;
	}

	public void deleteStateData(Integer id) {
		jdbcTemplate.update(deleteStateByIdQuery, id);
	}

}
