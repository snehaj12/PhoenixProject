package com.theitgirl.PhoenixProject.dto;

import lombok.Data;

@Data
public class ResponseObject {

    int responseCode;
    boolean error;
    Object data;

    public ResponseObject() {
        super();
    }

    public ResponseObject(boolean error, Object data, int respCode) {
        this.error = error;
        this.data = data;
        this.responseCode = respCode;
    }
}
