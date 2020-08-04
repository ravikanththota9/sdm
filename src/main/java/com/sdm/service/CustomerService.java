package com.sdm.service;

import com.sdm.constants.SDMApplicationConstants;
import com.sdm.dto.ClientAccountResponseDTO;
import com.sdm.model.CustomerHierarchyMappingModel;
import com.sdm.model.PartnerModel;
import com.sdm.model.User;
import com.sdm.dao.CustomerDAO;
import com.sdm.dto.CustomerDTO;
import com.sdm.model.CustomerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerDAO customerDao;

	@Autowired
	User user;

	@Transactional
	public void insertCustomerData(List<CustomerDTO> customerDTOList) {
		logger.info("insert customer data service");
		List<CustomerModel> customerModelList = new ArrayList<CustomerModel>();
		java.sql.Date dbDate = new java.sql.Date(new Date().getTime());
		customerDTOList.forEach(customerDTO -> {
			CustomerModel customerModel = new CustomerModel();
			BeanUtils.copyProperties(customerDTO, customerModel);

			customerModel.setReportingCustomerId(user.getCustomerId());

			if(SDMApplicationConstants.FRANCHISE_PARTNER_CUSTOMER_TYPE.equalsIgnoreCase(customerDTO.getCustomerType())) {
				customerModel.setReportingCustomerId(customerDTO.getSelectedCustomerId());
			} else if(SDMApplicationConstants.CLIENT_CUSTOMER_TYPE.equalsIgnoreCase(customerDTO.getCustomerType())) {
				if(Objects.nonNull(customerDTO.getClientType()) && customerDTO.getClientType().trim().length() > 0)
					customerModel.setReportingCustomerId(customerDTO.getReportingCustomerId());
			}

			customerModel.setCreatedUserId(user.getUserId());
			customerModel.setLastUpdatedUserId(user.getUserId());
			customerModel.setLastUpdatedDate(dbDate);
			customerModel.setIsDeleted(new Integer(0));
			customerModelList.add(customerModel);
		});
		customerDao.insertCustomerData(customerModelList);
	}

	public void deleteCustomerData(Integer id) {
		logger.info("delete customer data service");
		customerDao.deleteCustomerData(id);
	}

	public List<CustomerModel> fetchAllCustomerData() {
		logger.info("fetch customers data service");
		return customerDao.fetchAllCustomerData();
	}

	public List<CustomerModel> fetchCustomerDataById(Integer id) {
		logger.info("fetch customers data by id service");
		return customerDao.fetchCustomerDataById(id);
	}

	public List<PartnerModel> fetchPartnerDataByType(String type) {
		logger.info("fetch partner data by type service");
		return customerDao.fetchPartnerDataByType(type);
	}

	public void updateCustomerData(List<CustomerDTO> customerDTOList) {
		logger.info("update customer data by id service");
		List<CustomerModel> customerModelList = new ArrayList<CustomerModel>();
		customerDTOList.forEach(customerDTO -> {
			CustomerModel customerModel = new CustomerModel();
			BeanUtils.copyProperties(customerDTO, customerModel);
			customerModel.setLastUpdatedUserId(user.getUserId());
			customerModel.setLastUpdatedDate(new java.sql.Date(new Date().getTime()));
			customerModelList.add(customerModel);
		});
		customerDao.updateCustomerData(customerModelList);
	}

	public List<ClientAccountResponseDTO> fetchClientAccounts() throws Exception {
		logger.info("fetch client accounts service");
		return customerDao.fetchClientAccounts();
	}

}
