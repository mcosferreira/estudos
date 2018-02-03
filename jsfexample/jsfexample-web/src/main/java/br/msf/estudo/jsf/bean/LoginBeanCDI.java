package br.msf.estudo.jsf.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.msf.estudo.jsf.entity.User;

@Named(value = "loginBeanCDI")
@SessionScoped
public class LoginBeanCDI implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1942668082934939519L;
	private User user;
	
	@PostConstruct
	public void init() {
		user = new User();
	}
	
	public LoginBeanCDI() {
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String goToWelcome() {
		return "/pages/welcomeCDI?faces-redirect=true";
	}
	
}
