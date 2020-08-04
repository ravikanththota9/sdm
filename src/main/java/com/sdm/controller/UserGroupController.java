package com.sdm.controller;

import com.sdm.model.BaseDto;
import com.sdm.model.UserGroupModel;
import com.sdm.model.UserStatusLookupModel;
import com.sdm.service.UserGroupService;
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
public class UserGroupController {

    private static final Logger log = LoggerFactory.getLogger(UserGroupController.class);

    @Autowired
    UserGroupService userGroupService;

    @RequestMapping(value="/fetchallusergroupsdata", produces = { "application/json" }, method = RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<BaseDto<List<UserGroupModel>>> fetchAllUserStatusLookupData() {
        log.info("Fetch all user status lookup data");
        List<UserGroupModel> userGroupModels = userGroupService.fetchAllUserGroupData();
        return new BaseDto<>(userGroupModels, SUCCESS.toString(), OK).respond();
    }

}
