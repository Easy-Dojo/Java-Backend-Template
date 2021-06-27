package com.easydojo.template.common.exception;

import java.util.Map;

import static com.easydojo.template.common.exception.ErrorCode.REQUEST_VALIDATION_FAILED;


public class RequestValidationException extends AppException {
    public RequestValidationException(Map<String, Object> data) {
        super(REQUEST_VALIDATION_FAILED, data);
    }
}
