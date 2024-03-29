package lk.ijse.pos.advisor;

import jakarta.validation.ValidationException;
import lk.ijse.pos.service.exception.CustomerNotFoundException;
import lk.ijse.pos.service.exception.DuplicateRecordsException;
import lk.ijse.pos.service.exception.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.Map;


/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@ControllerAdvice
public class AppWildExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Map<String, Object>> handleServiceException(ServiceException exception) {

        Map<String, Object> commonErrorAttribute = null;

        if (exception instanceof DuplicateRecordsException) {
            commonErrorAttribute = getCommonErrorAttribute(HttpStatus.CONFLICT, exception.getMessage());
            commonErrorAttribute.put("message", exception.getMessage());
        } else if (exception instanceof CustomerNotFoundException) {
            System.out.println("exception = " + exception.getMessage());
            return new ResponseEntity<>(getCommonErrorAttribute(HttpStatus.NOT_FOUND, exception.getMessage()), HttpStatus.NOT_FOUND);
        } else {
            commonErrorAttribute = getCommonErrorAttribute(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
            commonErrorAttribute.put("message", exception.getMessage());
        }
        return new ResponseEntity<>(commonErrorAttribute, (HttpStatusCode) commonErrorAttribute.get("code"));
    }

    public Map<String, Object> getCommonErrorAttribute(HttpStatus http, String message) {
        LinkedHashMap<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("code", http.value());
        errAttributes.put("error", http.getReasonPhrase());
        errAttributes.put("status", http);
        errAttributes.put("message", message);
        return errAttributes;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleException(RuntimeException exception) {
        Map<String, Object> commonErrorAttribute = getCommonErrorAttribute(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        commonErrorAttribute.put("message", exception.getMessage());
        return new ResponseEntity<>(commonErrorAttribute, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInvalidArgument(MethodArgumentNotValidException ex) {
        System.out.println("method argument not valid exception");
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
