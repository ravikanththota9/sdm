package com.sdm.service;

import com.sdm.controller.UserStatusLookUpController;
import com.sdm.dao.UserStatusLookupDao;
import com.sdm.model.UserStatusLookupModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusLookUpService {

    private static final Logger log = LoggerFactory.getLogger(UserStatusLookUpService.class);

    @Autowired
    UserStatusLookupDao userStatusLookupDao;

    public List<UserStatusLookupModel> fectchAllUserStatusLookupData() {
        log.info("UserStatusLookUpService : Fetching user status lookup data");
        List<UserStatusLookupModel> userStatusLookupModels = userStatusLookupDao.fectchAllUserStatusLookupData();
        log.info("UserStatusLookUpService : userStatusLookupModels " + userStatusLookupModels);
        return  userStatusLookupModels;
    }
}
