package com.sdm.service;

import com.sdm.dao.UserDAO;
import com.sdm.dto.UserRequestDTO;
import com.sdm.exception.UserManagementException;
import com.sdm.model.User;
import com.sdm.model.UserRequestModel;
import com.sdm.utils.Encryption;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDAO userDAO;

    @Transactional
    public String manageUser(List<UserRequestModel> userRequests, String action) {
        log.info("UserService : manager user : request object is " + userRequests +  "action is " + action );
        if("CREATE".equalsIgnoreCase(action)) {
            log.info("in create condition");
            createUser(userRequests);
        } else if("UPDATE".equalsIgnoreCase(action)) {
            log.info("in update condition");

        } else if("DELETE".equalsIgnoreCase(action)) {

        }
        return null;
    }

    /**
     * get the user by username(Login-id)
     * Check if username(login_id) exits or not
     * Generate random password
     * encrypt the random generated password
     * create user.
     */
    private String createUser(List<UserRequestModel> userRequests) throws UserManagementException {
        log.info("createUser method triggered");
        for (UserRequestModel userRequest : userRequests) {
            User user = userDAO.findByUserName(userRequest.getLoginId());
            if(user!=null) {
                boolean userNameExists = user.getUserName().equalsIgnoreCase(userRequest.getLoginId());
                if(userNameExists) {
                    throw new UserManagementException("User Name already exists");
                }
            } else {
                String randomPassword = generateRandomPassword(userRequest.getLoginId());
                String encryptedPassword = null;
                try {
                    encryptedPassword = encryptPassword(randomPassword);
                } catch (Exception e) {
                    log.error("Password encryption failed. Please check",e);
                    throw new UserManagementException("Password encryption failed. Please check");
                }
                userRequest = insertUser(userRequest,encryptedPassword);
                userRequest = insertUserGroupMapping(userRequest);
                sensUserDetailsToUser(userRequest.getLoginId(),randomPassword);

            }
        }
        return "User created successfully";
    }

     private String generateRandomPassword(String userName) {
        return UUID.fromString(userName).toString();
    }

    private String encryptPassword(String password) throws Exception {
        Encryption encryption = Encryption.getInstance();
        return encryption.encrypt(password);
    }

    private UserRequestModel insertUser(UserRequestModel userRequest,String password) {
        userRequest  = userDAO.createUser(userRequest,password);
        log.info("User created successfully");
        return userRequest;
    }

    private UserRequestModel insertUserGroupMapping(UserRequestModel userRequest) {
        if(userRequest.getUserGroupIds() != null && userRequest.getUserGroupIds().size()>0) {
            for (Integer userGroupId : userRequest.getUserGroupIds()) {
                Integer noOfRecords  = userDAO.createUserGroupMapping(userRequest,userGroupId);
                log.info("user group mapping created successfully " + noOfRecords);
            }
        } else {
            throw new UserManagementException("No group assigned to the user. Please assign a group");
        }
        return userRequest;
    }

    private void sensUserDetailsToUser(String userId, String password) {

    }
}
