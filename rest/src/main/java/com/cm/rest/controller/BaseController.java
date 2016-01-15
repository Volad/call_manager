/*
 * ShowEvidence, Inc. Copyright (C) 2014
 */
package com.cm.rest.controller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cm.rest.dto.ErrorResultDto;

public abstract class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler({ Exception.class })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResultDto handeGeneralException(Exception e) {
        LOGGER.error(e.getMessage(), e);

        return new ErrorResultDto(e.getMessage(), ExceptionUtils.getStackTrace(e));
    }

}
