package com.cgi.soa.masterclass.epay.service;

import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import com.cgi.soa.masterclass.epay.meinbank.ws.BankWeb;
import com.cgi.soa.masterclass.epay.meinbank.ws.BankWebService;

@Stateless
public class BankWS {
	
	@WebServiceRef
	BankWebService service;
	
	public BankWeb getWebService(){
		return service.getBankWebPort();
	}
}
