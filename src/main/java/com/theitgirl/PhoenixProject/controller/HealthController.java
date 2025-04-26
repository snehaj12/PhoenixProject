package com.theitgirl.PhoenixProject.controller;

import com.theitgirl.PhoenixProject.dto.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/status")
    public ResponseEntity<ResponseObject> getHealthStatus(){
        ResponseObject obj = getSuccessObj( "Application is accessible", 200);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    public  ResponseObject getSuccessObj(Object obj, int code){
        return new ResponseObject(false,obj,code);
    }

}
