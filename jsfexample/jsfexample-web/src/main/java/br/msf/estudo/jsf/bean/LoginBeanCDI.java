package br.msf.estudo.jsf.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.msf.estudo.jsf.entity.User;

@Named(value = "loginBeanCDI")
@SessionScoped
public class LoginBeanCDI implements Serializable {

	private static final long serialVersionUID = -1942668082934939519L;
	
	@Inject
	private LoginBean lb;
	
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

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}
	
	public boolean validUser() {
		return true;
	}
	
	public String login() {
		return (validUser()) ? "success" : "fail";
	}
	
}
