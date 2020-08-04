package com.sdm.controller;

import com.sdm.exception.AuthenticationException;
import com.sdm.model.AuthRequest;
import com.sdm.model.AuthResponse;
import com.sdm.model.BaseDto;
import com.sdm.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.sdm.constants.IConstants.StandardResponse.SUCCESS;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    @CrossOrigin
    public ResponseEntity<BaseDto<AuthResponse>> authenticateUser(@RequestBody AuthRequest authRequest) throws AuthenticationException {
        try {
            logger.info("Authentication request is : " + authRequest);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            logger.error("Authentication failed for the user : " +  authRequest.getUserName());
            logger.error("error occurred ", ex);
            throw new AuthenticationException();
        }
        String jwtToken = jwtUtil.generateToken(authRequest.getUserName());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwtToken(jwtToken);
        authResponse.setUserId(2);
        return new BaseDto<>(authResponse, SUCCESS.toString(), OK).respond();
    }
}


