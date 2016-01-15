/*
 * ShowEvidence, Inc. Copyright (C) 2014
 */
package com.cm.rest.dto;

public class ErrorResultDto {

    private String message;
    private String trace;

    public ErrorResultDto(String message, String trace) {
        super();
        this.message = message;
        this.trace = trace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

}
