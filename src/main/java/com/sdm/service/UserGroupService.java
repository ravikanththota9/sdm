package com.sdm.service;

import com.sdm.dao.UserGroupDao;
import com.sdm.dao.UserStatusLookupDao;
import com.sdm.model.UserGroupModel;
import com.sdm.model.UserStatusLookupModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService {

    private static final Logger log = LoggerFactory.getLogger(UserGroupService.class);

    @Autowired
    UserGroupDao userGroupDao;

    public List<UserGroupModel> fetchAllUserGroupData() {
        log.info("UserStatusLookUpService : Fetching user group data");
        List<UserGroupModel> userGroupModels = userGroupDao.fectchAllUserGroupData();
        log.info("UserStatusLookUpService : userGroupModels " + userGroupModels);
        return  userGroupModels;
    }
}
