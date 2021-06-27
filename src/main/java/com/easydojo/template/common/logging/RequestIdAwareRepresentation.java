package com.easydojo.template.common.logging;


import com.easydojo.template.common.ddd.Representation;
import org.slf4j.MDC;

import static com.easydojo.template.common.logging.RequestIdMdcFilter.REQUEST_ID;


public abstract class RequestIdAwareRepresentation implements Representation {
    private final String requestId;

    public RequestIdAwareRepresentation() {
        this.requestId = MDC.get(REQUEST_ID);
    }

    public String getRequestId() {
        return requestId;
    }
}
