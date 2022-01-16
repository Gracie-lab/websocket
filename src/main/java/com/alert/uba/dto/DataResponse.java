package com.alert.uba.dto;

import lombok.Data;

@Data
public class DataResponse {

    private String noOfMessagesSent;
    private String noOfSuccessfulMessages;
    private String noOfFailedMessages;

}
