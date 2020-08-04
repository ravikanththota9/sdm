package com.sdm.mapper;

import com.sdm.dto.ClientAccountResponseDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientAccountResponseMapper implements RowMapper<ClientAccountResponseDTO> {

    @Override
    public ClientAccountResponseDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        ClientAccountResponseDTO c = new ClientAccountResponseDTO();
        c.setUserName(resultSet.getString("USER_EMAIL_ID"));
        c.setPassword(resultSet.getString("PASSWORD"));
        //TODO Initiating to 0 temporary as there are no devices configured.
        c.setDeviceCount(0);
        return c;
    }
}
