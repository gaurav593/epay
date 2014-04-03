package com.cgi.soa.masterclass.epay.service;

import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import com.cgi.soa.masterclass.epay.MeinBank.ws.BankWeb;
import com.cgi.soa.masterclass.epay.MeinBank.ws.BankWebService;

@Stateless
public class BankWS {
	
	@WebServiceRef
	BankWebService service;
	
	public BankWeb getWebService(){
		return service.getBankWebPort();
	}
}
