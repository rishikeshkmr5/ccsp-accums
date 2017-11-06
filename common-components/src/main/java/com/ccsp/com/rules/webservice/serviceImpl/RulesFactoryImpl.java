package com.ccsp.com.rules.webservice.serviceImpl;

import com.ccsp.common.rules.webservice.service.IRulesInvokerService;
import com.ccsp.common.utils.RulesConstants;
import com.ccsp.common.rules.webservice.service.IRulesFactory;


public class RulesFactoryImpl extends IRulesFactory{

	
	IRulesInvokerService rulesInvoker ;

	/**
	 * This is the invoker service which returns SOAP/REST object(based on the factory design pattern) to the client 
	 * @return {@link IRulesInvokerService} the reference of interface IRulesInvokerService
	 * @param webserviceType. Type of request
	 * @throws Exception thrown if  WebserviceType is null
	 */
	@Override
	public  IRulesInvokerService getRulesInvoker(String webserviceType) throws Exception {
		
		if(webserviceType == null ) {
			throw new Exception("WebserviceType is required");
		}
		
		if(webserviceType.equalsIgnoreCase(RulesConstants.REST)) {
			rulesInvoker = new RestRulesSerive();
		}
		
		
		return rulesInvoker;
	}
	 

}
