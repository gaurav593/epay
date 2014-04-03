package com.cgi.soa.masterclass.epay.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.cgi.soa.masterclass.epay.model.UserEntity;
import com.cgi.soa.masterclass.epay.service.BankWS;
import com.cgi.soa.masterclass.epay.service.UserDAOInterface;

@Named
@RequestScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1966957573249891139L;

	private List<UserEntity> users;
	private UserEntity user;

	@Inject
	private UserDAOInterface userAccess;

	@Inject
	private BankWS service;

	public UserBean() {
		users = new ArrayList<UserEntity>();
		user = new UserEntity();
	}

	@PostConstruct
	private void init() {
		updateUsers();
	}

	public void validateCredentials(ComponentSystemEvent event) {

		FacesContext fc = FacesContext.getCurrentInstance();

		UIComponent components = event.getComponent();

		// get Account Number
		UIInput uiInputAccNumber = (UIInput) components
				.findComponent("accountNumber");
		int accNumber = (Integer) uiInputAccNumber.getLocalValue();

		// get Account First Name
		UIInput uiInputAccFirstName = (UIInput) components
				.findComponent("accountFirstName");
		String accFirstName = uiInputAccFirstName.getLocalValue() == null ? ""
				: uiInputAccFirstName.getLocalValue().toString();

		// get Account Last Name
		UIInput uiInputAccLastName = (UIInput) components
				.findComponent("accountLastName");
		String accLastName = uiInputAccLastName.getLocalValue() == null ? ""
				: uiInputAccLastName.getLocalValue().toString();

		if (service.getWebService().isAccountOwner(accNumber, accFirstName, accLastName)) {

			FacesMessage msg = new FacesMessage(
					"Account already in use from same person!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage("accountNumber", msg);
			fc.renderResponse();
		}
	}

	public String createUser() {
		userAccess.createUser(user);
		updateUsers();
		return "/users/index";
	}

	private void updateUsers() {
		users = userAccess.getAllUsers();
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
