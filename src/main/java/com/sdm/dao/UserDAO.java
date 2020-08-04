package com.sdm.dao;


import com.sdm.model.User;
import com.sdm.model.UserRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    User user;

    @Value("${sdmservice.user.fetch:query}")
    private String userFetchQuery;

    @Value("${sdmservice.user.insert:query}")
    private String userInsertQuery;

    @Value("${sdmservice.usergroupmapping.insert:query}")
    private String userGroupMappingInsertQuery;

    public User findByUserName(String username) {
        logger.info("UserDAO : loading user by username " + username);
        logger.info("UserDAO : query to load username is  " + userFetchQuery);
        User user = jdbcTemplate.queryForObject(
                userFetchQuery,new Object[]{username},
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User c = new User();
                        c.setUserId(rs.getInt("ID"));
                        c.setUserName(rs.getString("LOGIN_ID"));
                        c.setPassword(rs.getString("LOGIN_PASSWORD"));
                        c.setUserEmail(rs.getString("EMAIL"));
                        return c;
                    }
                });
        return user;
    }

    public UserRequestModel createUser(UserRequestModel userRequestModel, String password) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("loginid", userRequestModel.getLoginId())
                .addValue("loginpassword", password)
                .addValue("firstnm", userRequestModel.getFirstName())
                .addValue("lastnm", userRequestModel.getLastName())
                .addValue("middlenm", userRequestModel.getMiddleName())
                .addValue("displaynm", userRequestModel.getDisplayName())
                .addValue("creationts", new java.sql.Date(new Date().getTime()))
                .addValue("creationuserid", user.getUserId())
                .addValue("lastupdatets", new java.sql.Date(new Date().getTime()))
                .addValue("lastupdateuserid", user.getUserId())
                .addValue("addressline1", userRequestModel.getAddressLine1())
                .addValue("addressline2", userRequestModel.getAddressLine2())
                .addValue("addressline3", userRequestModel.getAddressLine3())
                .addValue("contactnbr", userRequestModel.getContactNumber())
                .addValue("customerid", userRequestModel.getCustomerId())
                .addValue("city", userRequestModel.getCity())
                .addValue("statelookupid", userRequestModel.getStateLookupId())
                .addValue("countrylookupid", userRequestModel.getCountryLookupId())
                .addValue("zipcode", userRequestModel.getZipCode())
                .addValue("imagepath", null)
                .addValue("isdeleted", 0)
                .addValue("isnew", 1)
                .addValue("newuserlinkexphr", 8)
                .addValue("otp", null)
                .addValue("userstatuslookupid", userRequestModel.getUserStatusLookupId())
                .addValue("email", userRequestModel.getEmail())
                .addValue("failedloginattempts", 0)
                .addValue("passwordchangecount", 0);
        namedParameterJdbcTemplate.update(userInsertQuery, parameters, holder);
        userRequestModel.setId(holder.getKey().intValue());
        return userRequestModel;
    }

    public Integer createUserGroupMapping(UserRequestModel userRequestModel,Integer userGroupId) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("userid", userRequestModel.getId())
                .addValue("usergroupid", userGroupId)
                .addValue("creationts", new java.sql.Date(new Date().getTime()))
                .addValue("creationuserid", user.getUserId())
                .addValue("lastupdatets", new java.sql.Date(new Date().getTime()))
                .addValue("lastupdateuserid", user.getUserId())
                .addValue("isdeleted", 0);
        int noOfrecords = namedParameterJdbcTemplate.update(userInsertQuery, parameters);
        return noOfrecords;
    }
}
