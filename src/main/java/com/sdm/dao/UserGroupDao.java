package com.sdm.dao;

import com.sdm.model.UserGroupModel;
import com.sdm.model.UserStatusLookupModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserGroupDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${sdmservice.usergroup.fetch:query}")
    private String userGroupFetchQuery;


    private static final Logger log = LoggerFactory.getLogger(UserGroupDao.class);

    public List<UserGroupModel> fectchAllUserGroupData() {
        log.info("UserStatusLookupDao : fectchAllUserGroupData");
        List<UserGroupModel> userGroupModels = jdbcTemplate.query(
                userGroupFetchQuery,new Object[]{},
                new RowMapper<UserGroupModel>() {
                    public UserGroupModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                        UserGroupModel c = new UserGroupModel();
                        c.setId(rs.getInt("ID"));
                        c.setUserGroupName(rs.getString("NAME"));
                        c.setUserGroupDescription(rs.getString("DESC"));
                        return c;
                    }
                });
        return userGroupModels;
    }
}
