
package com.ccsp.accums.rules.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ErrorList {

    @XmlElement(nillable = true)
    protected List<MyError> error;

   
    public List<MyError> getError() {
        if (error == null) {
            error = new ArrayList<MyError>();
        }
        return this.error;
    }

}
