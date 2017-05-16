package br.msf.estudo.jsf.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="helloWorldBean")
@SessionScoped
public class HelloWorldBean implements Serializable {

	private static final long serialVersionUID = -9215638431730052821L;
	private String nome;

	public HelloWorldBean() {
		super();
	}
	
	public String hello() {
		return this.nome;
	}

	public String currentTime() {
		return (LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy:HH:mm:SS"))); 
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}