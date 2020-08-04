package com.sdm.controller;

import com.sdm.dto.ClientAccountResponseDTO;
import com.sdm.model.BaseDto;
import com.sdm.dto.CustomerDTO;
import com.sdm.model.CustomerModel;
import com.sdm.model.PartnerModel;
import com.sdm.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static com.sdm.constants.IConstants.StandardResponse.SUCCESS;
import static org.springframework.http.HttpStatus.OK;

@Validated
@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/insertcustomerdata", produces = { "application/json" }, method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<BaseDto<String>> insertCustomerData(@Valid @RequestBody List<CustomerDTO> customerDTOList) {
		logger.info("insert customer data controller");
		customerService.insertCustomerData(customerDTOList);
		return new BaseDto<>("Customer information saved successfully", SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/deletecustomerdata", produces = { "application/json" }, method = RequestMethod.DELETE)
	@CrossOrigin
	public ResponseEntity<BaseDto<String>> deleteCustomerData(@RequestParam Integer id) {
		logger.info("delete customer data controller");
		customerService.deleteCustomerData(id);
		return new BaseDto<>("Customer information deleted successfully", SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/fetchallcustomerdata", produces = { "application/json" }, method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<BaseDto<List<CustomerModel>>> fetchAllCustomerData() {
		logger.info("fetch customers data controller");
		List<CustomerModel> customerModels = customerService.fetchAllCustomerData();
		return new BaseDto<>(customerModels, SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/fetchcustomerdatabyid", produces = { "application/json" }, method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<BaseDto<List<CustomerModel>>> fetchCustomerDataById(@RequestParam Integer id) {
		logger.info("fetch customer data by id controller");
		List<CustomerModel> customerModels = customerService.fetchCustomerDataById(id);
		return new BaseDto<>(customerModels, SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/fetchpartnerdatabytype", produces = { "application/json" }, method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<BaseDto<List<PartnerModel>>> fetchPartnerDataByType(@RequestParam String type) {
		logger.info("fetch partner data by type controller");
		List<PartnerModel> partnerModels = customerService.fetchPartnerDataByType(type);
		return new BaseDto<>(partnerModels, SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/updatecustomerdata", produces = { "application/json" }, method = RequestMethod.PUT)
	@CrossOrigin
	public ResponseEntity<BaseDto<String>> updateCustomerData(@Valid @RequestBody List<CustomerDTO> customerDTOList) {
		logger.info("update customer data by id controller");
		customerService.updateCustomerData(customerDTOList);
		return new BaseDto<>("Customer information updated successfully", SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/fetchclientaccounts", produces = { "application/json" }, method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<BaseDto<List<ClientAccountResponseDTO>>> fetchClientAccounts() throws Exception {
		logger.info("fetch client accounts controller");
		List<ClientAccountResponseDTO> clientAccountResponseDTOS = customerService.fetchClientAccounts();
		return new BaseDto<>(clientAccountResponseDTOS, SUCCESS.toString(), OK).respond();
	}

}
