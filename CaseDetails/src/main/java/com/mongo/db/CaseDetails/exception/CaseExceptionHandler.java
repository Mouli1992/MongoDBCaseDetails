package com.mongo.db.CaseDetails.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chandramouli
 */
@RestController
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CaseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String,String> errors = new HashMap();
        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            if(objectError instanceof FieldError){
                errors.put(((FieldError) objectError).getField(), objectError.getDefaultMessage()+ " ||| "+((FieldError) objectError).getRejectedValue());
            }else if( objectError instanceof ObjectError){
                errors.put(objectError.getObjectName(), objectError.getDefaultMessage());
            }
        });

        return new ResponseEntity<>(new APIError(HttpStatus.BAD_REQUEST,ex,errors.toString()),HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>( new APIError(HttpStatus.BAD_REQUEST, ex, ex.getErrorCode() +" |||"+ex.getPropertyName() +" ||| "+ex.getRequiredType()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({CaseCustomException.class})
    ResponseEntity<Object> handleCaseError(CaseCustomException exception){
        return new ResponseEntity<Object>(new APIError( HttpStatus.INTERNAL_SERVER_ERROR,exception, exception.getErrorMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
