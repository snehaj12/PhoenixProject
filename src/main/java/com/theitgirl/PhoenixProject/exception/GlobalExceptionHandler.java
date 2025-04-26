package com.theitgirl.PhoenixProject.exception;

import com.theitgirl.PhoenixProject.dto.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.zip.DataFormatException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataFormatException.class)
    public ResponseEntity<ResponseObject> handleException(DataFormatException exc){
        ResponseObject obj= getErrorObj("Invalid Data Format : "+exc.getMessage(),401);
        return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ResponseObject> handleException(SQLException exc){
        ResponseObject obj= getErrorObj("SQLException occurred : " +exc.getMessage(),500);
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseObject> handleException(Exception exc){
        ResponseObject obj= getErrorObj("Internal Server Exception occurred: " +exc.getMessage(),500);
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public  ResponseObject getErrorObj(Object obj, int code){
        return new ResponseObject(true,obj,code);
    }
}
