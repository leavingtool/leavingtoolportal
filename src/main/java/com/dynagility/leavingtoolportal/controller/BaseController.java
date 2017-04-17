package com.dynagility.leavingtoolportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.dynagility.leavingtoolportal.exceptions.BadRequestException;
import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.exceptions.NotAuthenticatedException;
import com.dynagility.leavingtoolportal.exceptions.NotAuthorizedException;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;
import com.dynagility.leavingtoolportal.security.SecurityUtil;

@RestController
public class BaseController {
    @Autowired
    protected SecurityUtil securityUtil;

    public void checkLogin() {
        if (!securityUtil.checkAuthentication()) {
            throw new NotAuthenticatedException();
        }

        if (!securityUtil.checkAuthorization()) {
            throw new NotAuthorizedException();
        }
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<?> internalErrorExceptionHandler(InternalErrorException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestExceptionHandler(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getAllMessages());
    }

    @ExceptionHandler(NotAuthenticatedException.class)
    public ResponseEntity<?> notAuthenticatedExceptionHandler(NotAuthenticatedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<?> notAuthorizedExceptionHandler(NotAuthorizedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}

