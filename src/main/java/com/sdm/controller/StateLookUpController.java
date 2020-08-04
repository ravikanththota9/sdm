package com.sdm.controller;

import com.sdm.dto.StateLookupDTO;
import com.sdm.model.BaseDto;
import com.sdm.model.StateLookupModel;
import com.sdm.service.StateLookUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

import static com.sdm.constants.IConstants.StandardResponse.SUCCESS;
import static org.springframework.http.HttpStatus.OK;

@Validated
@RestController
public class StateLookUpController {

	@Autowired
	StateLookUpService stateLookUpService;

	@RequestMapping(value = "/insertstatedata", produces = { "application/json" }, method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<BaseDto<String>> insertStateData(
			@RequestBody List<StateLookupDTO> stateLookupDTOList) {
		stateLookUpService.insertStateData(stateLookupDTOList);
		return new BaseDto<>("State information saved successfully", SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/updatestatedata", produces = { "application/json" }, method = RequestMethod.PUT)
	@CrossOrigin
	public ResponseEntity<BaseDto<String>> updateStateData(
			@RequestBody List<StateLookupDTO> stateLookupDTOList) {
		stateLookUpService.updateStateData(stateLookupDTOList);
		return new BaseDto<>("State information updated successfully", SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/fetchallstatedata", produces = { "application/json" }, method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<BaseDto<List<StateLookupModel>>> fetchAllStateData() {
		List<StateLookupModel> stateLookupModels = stateLookUpService.fetchAllStateData();
		return new BaseDto<>(stateLookupModels, SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/fetchstatebyCountryid", produces = { "application/json" }, method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<BaseDto<List<StateLookupModel>>> fetchStateByCountryidData(
			@RequestParam Integer countryLookupId) {
		List<StateLookupModel> stateLookupModels = stateLookUpService.fetchStateByIdData(countryLookupId);
		return new BaseDto<>(stateLookupModels, SUCCESS.toString(), OK).respond();
	}

	@RequestMapping(value = "/deletestatedata", produces = { "application/json" }, method = RequestMethod.DELETE)
	@CrossOrigin
	public ResponseEntity<BaseDto<String>> deleteStateData(@RequestParam Integer id) {
		stateLookUpService.deleteStateData(id);
		return new BaseDto<>("State information deleted successfully", SUCCESS.toString(), OK).respond();
	}

}
