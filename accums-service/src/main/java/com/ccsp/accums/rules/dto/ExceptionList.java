
package com.ccsp.accums.rules.dto;

import java.util.ArrayList;
import java.util.List;


public class ExceptionList {

    protected List<MyException> exception;
    public List<MyException> getException() {
        if (exception == null) {
            exception = new ArrayList<MyException>();
        }
        return this.exception;
    }

}
