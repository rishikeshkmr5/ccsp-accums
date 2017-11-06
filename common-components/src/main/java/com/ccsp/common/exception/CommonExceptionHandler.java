/**
 * 
 */
package com.ccsp.common.exception;


import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ccsp.common.exception.dto.IMessageDTO;
import com.ccsp.common.exception.dto.ValidationErrorMessageDTO;
import com.ccsp.common.exception.message.MessageType;
import com.ccsp.common.utils.ErrorCodes;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**This method handles exception of type 'NotFoundException'
     * @param ex
     * @return A dto containing 'errorCode', 'message' and 'type'
     */
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ValidationErrorMessageDTO> handleNotFoundException(NotFoundException ex) {
    	ValidationErrorMessageDTO error = (ValidationErrorMessageDTO) buildErrors(ErrorCodes.NOT_FOUND, ex.getMessage());
    	logger.error(""+ error);
        return new ResponseEntity<ValidationErrorMessageDTO>(error, HttpStatus.NOT_FOUND);
    }
    
    /**This method handles exception of type 'ValidationException'
     * @param ex
     * @return A dto containing 'errorCode', 'message' and 'type'
     */
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidationErrorMessageDTO> handleValidationException(ValidationException ex) {
    	ValidationErrorMessageDTO error = (ValidationErrorMessageDTO)buildErrors(ErrorCodes.VALIDATION_ERROR_CODE, ex.getMessage());
    	logger.error(""+ error);
        return new ResponseEntity<ValidationErrorMessageDTO>(error, HttpStatus.BAD_REQUEST);
    }
    
    
    /**This method handles exception of type 'Exception'
     * @param ex 
     * @return A dto containing 'errorCode', 'message' and 'type'
     */
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ValidationErrorMessageDTO> handleException(Exception ex) {
    	
    	ValidationErrorMessageDTO error = (ValidationErrorMessageDTO) buildErrors(ErrorCodes.NOT_FOUND, ex.getMessage());
    	logger.error(""+ error);
    	return new ResponseEntity<ValidationErrorMessageDTO>(error, HttpStatus.NOT_FOUND);
    } 
    
	//Commenting out this code as per the suggestion in review call. We don't want to use Map. We can write this code without using Map which will help to improve the performance.
   
    /*protected ErrorMessage buildErrors(ErrorCodes errorCode, String msg) {
		return buildErrors(errorCode, msg, "error");
	}

	protected ErrorMessage buildErrorMap(ErrorCodes errorCode, String msg, String fieldName) {
		Map<String, IMessageDTO> errors = new HashMap<String, IMessageDTO>();
		IMessageDTO message = new ValidationErrorMessageDTO(errorCode, MessageType.ERROR, msg);
		errors.put(fieldName, message);
		ErrorMessage errorMessage = new ErrorMessage(errors);
		return errorMessage;
	}*/
	
    
	/** 
	 * @param errorCode
	 * @param msg
	 * @return A dto containing 'errorCode', 'message' and 'type'
	 */
	IMessageDTO buildErrors(ErrorCodes errorCode, String msg) {
		IMessageDTO message = new ValidationErrorMessageDTO(errorCode, MessageType.EXCEPTION, msg);
		return message;
	}
}
