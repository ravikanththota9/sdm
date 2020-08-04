package com.sdm.dao;

import com.sdm.dto.ClientAccountResponseDTO;
import com.sdm.mapper.ClientAccountResponseMapper;
import com.sdm.mapper.PartnerMapper;
import com.sdm.model.PartnerModel;
import com.sdm.model.User;
import com.sdm.mapper.CustomerMapper;
import com.sdm.model.CustomerModel;
import com.sdm.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CustomerDAO {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	User user;

	@Value("${sdm.customer.insert:query}")
	private String insertCustomerQuery;

	@Value("${sdm.customer.delete:query}")
	private String deleteCustomerByIdQuery;

	@Value("${sdm.customer.fetch:query}")
	private String fetchAllCustomerQuery;

	@Value("${sdm.customer.fetchbyid:query}")
	private String fetchCustomerByIdQuery;

	@Value("${sdm.partner.fetchbytype:query}")
	private String fetchPartnerByTypeQuery;

	@Value("${sdm.customer.update:query}")
	private String updateCustomerQuery;

	@Value("${sdm.clientaccounts.fetch:query}")
	private String fetchClientAccountsQuery;

	public void insertCustomerData(List<CustomerModel> customerModelList) {
		logger.info("insert customer data DAO");
		SqlParameterSource[] customerList = SqlParameterSourceUtils.createBatch(customerModelList.toArray());
		namedParameterJdbcTemplate.batchUpdate(
				insertCustomerQuery,
				customerList);
		/*customerModelList.forEach(customerModel -> {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(customerModel);
			namedParameterJdbcTemplate.update(insertCustomerQuery, fileParameters, keyHolder);
			CustomerHierarchyMappingModel customerHierarchyMappingModel = customerModel.getCustomerHierarchyMappingModel();
			customerHierarchyMappingModel.setCustomerId(keyHolder.getKey().intValue());
			fileParameters = new BeanPropertySqlParameterSource(customerHierarchyMappingModel);
			namedParameterJdbcTemplate.update(insertCustomerHierarchyMappingQuery, fileParameters);
		});*/
	}

	public void deleteCustomerData(Integer id) {
		logger.info("delete customer data DAO");
		jdbcTemplate.update(deleteCustomerByIdQuery, id);
	}

	public List<CustomerModel> fetchAllCustomerData() {
		logger.info("fetch customers data DAO");
		List<CustomerModel> customerModels = jdbcTemplate.query(fetchAllCustomerQuery, new CustomerMapper());
		return customerModels;
	}

	public List<CustomerModel> fetchCustomerDataById(Integer id) {
		logger.info("fetch customers data by id DAO");
		List<CustomerModel> customerModels = jdbcTemplate.query(fetchCustomerByIdQuery, new Object[] { id },
				new CustomerMapper());
		return customerModels;
	}

	public List<PartnerModel> fetchPartnerDataByType(String type) {
		logger.info("fetch partner data by type DAO");
		List<PartnerModel> partnerModels = jdbcTemplate.query(fetchPartnerByTypeQuery, new Object[] { type },
				new PartnerMapper());
		return partnerModels;
	}

	public void updateCustomerData(List<CustomerModel> customerModelList) {
		logger.info("update customer data by id DAO");
		SqlParameterSource[] customerList = SqlParameterSourceUtils.createBatch(customerModelList.toArray());
		namedParameterJdbcTemplate.batchUpdate(updateCustomerQuery, customerList);
	}

	public List<ClientAccountResponseDTO> fetchClientAccounts() throws Exception {
		logger.info("fetch client accounts DAO");
		String date = DateUtil.convertDateToString(new Date(), "yyyy-MM-dd");
		List<ClientAccountResponseDTO> clientAccountResponseDTOS = jdbcTemplate.query(fetchClientAccountsQuery,
				new Object[] {date, date}, new ClientAccountResponseMapper());
		return clientAccountResponseDTOS;
	}

}