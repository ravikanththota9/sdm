package com.sdm.exception;

import com.sdm.model.BaseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLIntegrityConstraintViolationException;
import static com.sdm.model.IConstants.StandardResponse.ERROR;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class SdmServiceException {

    private static final Logger logger = LoggerFactory.getLogger(SdmServiceException.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BaseDto<String>> generateException(final Exception exception, final HttpServletRequest request, final HttpServletResponse response) {
        logger.error(exception.getMessage());
        return new BaseDto<>(exception.getMessage(), ERROR.toString(), INTERNAL_SERVER_ERROR).respond();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BaseDto<String>> validationException(final Exception exception, final HttpServletRequest request, final HttpServletResponse response) {
        logger.error(exception.getMessage());
        return new BaseDto<>(exception.getMessage(), ERROR.toString(), INTERNAL_SERVER_ERROR).respond();
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BaseDto<String>> validateUniquenessException(final Exception exception, final HttpServletRequest request, final HttpServletResponse response) {
        logger.error(exception.getMessage());
        return new BaseDto<>(exception.getMessage(), ERROR.toString(), INTERNAL_SERVER_ERROR).respond();
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BaseDto<String>> authenticationException(final AuthenticationException exception, final HttpServletRequest request, final HttpServletResponse response) {
        logger.error(exception.getMessage());
        return new BaseDto<>(exception.getMessage(), ERROR.toString(), INTERNAL_SERVER_ERROR).respond();
    }

    @ExceptionHandler(UserManagementException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BaseDto<String>> authenticationException(final UserManagementException exception, final HttpServletRequest request, final HttpServletResponse response) {
        logger.error(exception.getMessage());
        return new BaseDto<>(exception.getMessage(), ERROR.toString(), INTERNAL_SERVER_ERROR).respond();
    }


}
