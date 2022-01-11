package com.alert.uba.controllers;

import com.alert.uba.DataResponse;
import com.alert.uba.UbaService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class UbaController {

    private final UbaService ubaService;

    public UbaController(UbaService ubaService) {
        this.ubaService = ubaService;
    }
    private static final Logger logger = LogManager.getLogger(UbaController.class);


    @GetMapping("/fetch")
    public ResponseEntity<?> fetchData(){
        try{
            DataResponse response = ubaService.fetchData();
            HashMap<Object, Object> jsonObject = new HashMap<>();
            jsonObject.put("noOfMessagesSent", 0);
            jsonObject.put("noOfSuccessfulMessages", 0);
            jsonObject.put("noOfFailedMessages", 0);
            logger.log(Level.INFO, "get data request initiated, Time: {}", LocalDateTime.now());
                logger.log(Level.INFO,"get data response sent: Time: {}",LocalDateTime.now());
                return new ResponseEntity<>(jsonObject, HttpStatus.OK);
            } catch (Exception e) {
                logger.log(Level.INFO,"===Exception in BusinessController-CustomException===");
                logger.log(Level.INFO,e.getMessage());
//                JSONObject errorObj = HttpRestClient.getResponse(e.getCode(),e.getMessage());
                logger.log(Level.INFO,"get data response sent: Time: {}", LocalDateTime.now());
                return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
            }

    }

}
