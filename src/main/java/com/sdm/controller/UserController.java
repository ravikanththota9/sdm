package com.sdm.controller;

import com.sdm.model.BaseDto;
import com.sdm.model.UserRequestModel;
import com.sdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sdm.constants.IConstants.StandardResponse.SUCCESS;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/manageUser", produces = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<BaseDto<String>>  createUser(@RequestBody List<UserRequestModel> userRequests, @RequestParam(value="action", required=true) String action) {
        userService.manageUser(userRequests,action);
        return new BaseDto<>("User created and Email has sent to the user for activation", SUCCESS.toString(), OK).respond();
    }

}
