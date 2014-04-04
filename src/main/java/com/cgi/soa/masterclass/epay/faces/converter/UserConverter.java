package com.cgi.soa.masterclass.epay.faces.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.cgi.soa.masterclass.epay.model.UserEntity;
import com.cgi.soa.masterclass.epay.service.UserDAOInterface;

@FacesConverter(value = "userConverter")
public class UserConverter implements Converter {

	@Inject
	private UserDAOInterface userAccess;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		UserEntity user = userAccess.getUserByID(Integer.valueOf(value));
        if (user == null) {
            throw new ConverterException(new FacesMessage("Unknown user ID: " + value));
        }
        return user;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return String.valueOf(((UserEntity)value).getUserID());
	}
}