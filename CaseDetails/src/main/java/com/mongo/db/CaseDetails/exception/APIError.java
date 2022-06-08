package com.mongo.db.CaseDetails.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @author chandramouli
 */

@Getter
@Setter
@Component
public class APIError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime localDateTime;
    private String message;
    private String debugMessage;

    public APIError(){
        localDateTime = ZonedDateTime.now().toLocalDateTime();
    }

    public APIError(HttpStatus status){
        this();
        this.status = status;
    }

    public APIError(HttpStatus status, Throwable ex){
        this();
        this.status = status;
        this.message = "Request Error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public APIError(HttpStatus status, Throwable ex, String message){
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }




}
