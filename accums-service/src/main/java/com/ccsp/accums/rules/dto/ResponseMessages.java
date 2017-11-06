
package com.ccsp.accums.rules.dto;

import java.util.ArrayList;
import java.util.List;


public class ResponseMessages {

    protected List<String> responseMessage;
    public List<String> getResponseMessage() {
        if (responseMessage == null) {
            responseMessage = new ArrayList<String>();
        }
        return this.responseMessage;
    }

}
