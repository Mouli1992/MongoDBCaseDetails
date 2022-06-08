package com.mongo.db.CaseDetails.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chandramouli
 */

@Getter
@Setter
public class CaseCustomException extends Exception{

    private String status;
    private String requestId;
    private String errorCode;
    private String errorMessage;
    private String apiName;

    public CaseCustomException (String status, String requestId, String errorCode,String errorMessage , String apiName){
        super(getMessage(requestId,errorCode,errorMessage));
        this.status = status;
        this.requestId = requestId;
        this.errorCode = errorCode;
        this.errorMessage =errorMessage;
        this.apiName = apiName;
    }
    public CaseCustomException (String status, String requestId, String errorCode,String errorMessage , String apiName, Throwable cause){
        super(getMessage(requestId,errorCode,errorMessage),cause);
        this.status = status;
        this.requestId = requestId;
        this.errorCode = errorCode;
        this.errorMessage =errorMessage;
        this.apiName = apiName;
    }

    private static String getMessage(String requestId, String errorCode, String errorMessage) {
        return "RequestId : "+requestId+" ||||| "+"ErrorCode : "+errorCode+" |||||||"+"ErrorMessage "+errorMessage;
    }


}
