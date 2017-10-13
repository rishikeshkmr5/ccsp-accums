package com.ccsp.common.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.ValidatorFactory;
import com.ccsp.common.dto.ICommonDTO;

/**
 * @author nnarayanaperumaln
 *
 */
public class Validator{
	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();	
	
	public void validate(List<? extends ICommonDTO> accumsEntry) throws ValidationException{
		List<String> errorMessages = new ArrayList<>();
		javax.validation.Validator validator = factory.getValidator();
		for(ICommonDTO element : accumsEntry) {
			Set<ConstraintViolation<ICommonDTO>> violations = validator.validate(element);
			for (ConstraintViolation<ICommonDTO> violation : violations) {
				errorMessages.add(violation.getMessage());
			}	
		}
		if(errorMessages.size()>0)
			throw new ValidationException(errorMessages.toString());
	}
		
}
