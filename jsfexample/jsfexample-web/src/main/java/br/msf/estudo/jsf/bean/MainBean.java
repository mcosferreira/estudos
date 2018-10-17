package br.msf.estudo.jsf.bean;

import java.io.Serializable;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
// import javax.faces.bean.ManagedBean;
// import javax.faces.bean.SessionScoped;

@Named("mainBean")
// @ManagedBean
@SessionScoped
public class MainBean implements Serializable {

	private static final long serialVersionUID = 1080155375918901553L;
	private String username;


	public MainBean() {
		super();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGreeting() {
		if ((username == null) || (username.length() == 0)) return "";
		else return "Welcome back, " + username.trim() + "!"; 
			
	}
}
