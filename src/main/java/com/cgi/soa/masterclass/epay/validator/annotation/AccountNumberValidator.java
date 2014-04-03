package com.cgi.soa.masterclass.epay.validator.annotation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import com.cgi.soa.masterclass.epay.service.BankWS;

@FacesValidator("accountValidator")
public class AccountNumberValidator implements Validator {
	
	@Inject
	private BankWS service;

	
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		int accNumber = (Integer)arg2;
		boolean result = service.getWebService().isAccountExist(accNumber);
		if(result){
			FacesMessage msg = 
					new FacesMessage("Account validation failed.", 
							"Account number is in use!");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
		}
	}

}
