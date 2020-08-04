package com.sdm.dao;

import com.sdm.model.User;
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
public class UserStatusLookupDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${sdmservice.userstatuslookup.fetch:query}")
    private String userStatusLookupFetchQuery;


    private static final Logger log = LoggerFactory.getLogger(UserStatusLookupDao.class);

    public List<UserStatusLookupModel> fectchAllUserStatusLookupData() {
        log.info("UserStatusLookupDao : fectchAllUserStatusLookupData");
        List<UserStatusLookupModel> userStatusLookupModels = jdbcTemplate.query(
                userStatusLookupFetchQuery,new Object[]{},
                new RowMapper<UserStatusLookupModel>() {
                    public UserStatusLookupModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                        UserStatusLookupModel c = new UserStatusLookupModel();
                        c.setId(rs.getInt("ID"));
                        c.setStatusCode(rs.getString("STATUS_CD"));
                        c.setStatusDescription(rs.getString("STATUS_DESC"));
                        return c;
                    }
                });
        return userStatusLookupModels;
    }
}
