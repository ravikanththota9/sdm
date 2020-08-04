package com.sdm.controller;

import com.sdm.model.BaseDto;
import com.sdm.model.CountryLookupModel;
import com.sdm.model.UserStatusLookupModel;
import com.sdm.service.UserService;
import com.sdm.service.UserStatusLookUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sdm.constants.IConstants.StandardResponse.SUCCESS;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class UserStatusLookUpController {

    private static final Logger log = LoggerFactory.getLogger(UserStatusLookUpController.class);

    @Autowired
    UserStatusLookUpService userStatusLookUpService;

    @RequestMapping(value="/fetchalluserstatusdata", produces = { "application/json" }, method = RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<BaseDto<List<UserStatusLookupModel>>> fetchAllUserStatusLookupData() {
        log.info("Fetch all user status lookup data");
        List<UserStatusLookupModel> userStatusLookupModels = userStatusLookUpService.fectchAllUserStatusLookupData();
        return new BaseDto<>(userStatusLookupModels, SUCCESS.toString(), OK).respond();
    }

}
