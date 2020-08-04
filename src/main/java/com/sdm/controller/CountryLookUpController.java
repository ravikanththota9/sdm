package com.sdm.controller;

import com.sdm.model.BaseDto;
import com.sdm.dto.CountryLookupDTO;
import com.sdm.model.BaseDto;
import com.sdm.model.CountryLookupModel;
import com.sdm.service.CountryLookUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CountryLookUpController {

    private static final Logger logger = LoggerFactory.getLogger(CountryLookUpController.class);

    @Autowired
    CountryLookUpService countryLookUpService;

    @RequestMapping(value="/insertcountrydata", produces = { "application/json" }, method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<BaseDto<String>> insertCountryData(@RequestBody List<CountryLookupDTO> countryLookupDTOList){
        logger.info("insert country data");
        countryLookUpService.insertCountryData(countryLookupDTOList);
        return new BaseDto<>("Country information saved successfully", SUCCESS.toString(), OK).respond();
    }

    @RequestMapping(value="/updatecountrydata", produces = { "application/json" }, method = RequestMethod.PUT)
    @CrossOrigin
    public ResponseEntity<BaseDto<String>> updateCountryData(@RequestBody List<CountryLookupDTO> countryLookupDTOList) {
        logger.info("update country data");
        countryLookUpService.updateCountryData(countryLookupDTOList);
        return new BaseDto<>("Country information updated successfully", SUCCESS.toString(), OK).respond();
    }

    @RequestMapping(value="/fetchallcountrydata", produces = { "application/json" }, method = RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<BaseDto<List<CountryLookupModel>>> fetchAllCountryData() {
        logger.info("Fetch all country data");
        List<CountryLookupModel> countryLookupModels = countryLookUpService.fetchAllCountryData();
        return new BaseDto<>(countryLookupModels, SUCCESS.toString(), OK).respond();
    }

    @RequestMapping(value="/fetchcountrydatabyid", produces = { "application/json" }, method = RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<BaseDto<List<CountryLookupModel>>> fetchCountryDataById(@RequestParam Integer id) {
        logger.info("Fetching country data by id");
        List<CountryLookupModel> countryLookupModels = countryLookUpService.fetchCountryDataById(id);
        return new BaseDto<>(countryLookupModels, SUCCESS.toString(), OK).respond();
    }

    @RequestMapping(value="/deletecountrydata", produces = { "application/json" }, method = RequestMethod.DELETE)
    @CrossOrigin
    public ResponseEntity<BaseDto<String>> deleteCountryData(@RequestParam Integer id) {
        logger.info("delete country data");
        countryLookUpService.deleteCountryData(id);
        return new BaseDto<>("Country information deleted successfully", SUCCESS.toString(), OK).respond();
    }

}
