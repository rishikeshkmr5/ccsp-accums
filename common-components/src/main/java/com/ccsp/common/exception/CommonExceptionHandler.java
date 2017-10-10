/**
 * 
 */
package com.ccsp.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javassist.NotFoundException;
import com.ccsp.common.exception.message.ErrorMessage;
import com.ccsp.common.exception.message.MessageType;
import com.ccsp.common.utils.ErrorCodes;
import com.ccsp.common.exception.dto.IMessageDTO;
import com.ccsp.common.exception.dto.ValidationErrorMessageDTO;

/**
 * @author nnarayanaperumaln
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {

	private static Logger LOGGER = Logger.getLogger(CommonExceptionHandler.class);
	
	
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException ex) {
        ErrorMessage error = buildErrorMap(ErrorCodes.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }
    
    
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex) {
    	System.out.println("Inside ExceptionHandler in Controller");
    	System.out.println("Exception message is: "+ex.getMessage());
    	//log.info(ex.getMessage());
    	ErrorMessage error = buildErrorMap(ErrorCodes.NOT_FOUND, ex.getMessage());
    	//log.error(error.toString());
    	return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    } 
    
	
    protected ErrorMessage buildErrorMap(ErrorCodes errorCode, String msg) {
		return buildErrorMap(errorCode, msg, "error");
	}

	protected ErrorMessage buildErrorMap(ErrorCodes errorCode, String msg, String fieldName) {
		Map<String, IMessageDTO> errors = new HashMap<String, IMessageDTO>();
		IMessageDTO message = new ValidationErrorMessageDTO(errorCode, MessageType.ERROR, msg);
		errors.put(fieldName, message);
		ErrorMessage errorMessage = new ErrorMessage(errors);
		return errorMessage;
	}
}
