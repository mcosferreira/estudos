package br.msf.estudo.jsf.bean;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="classifBean")
@RequestScoped
public class ClassifBean {
	private int age;
	
	public ClassifBean() {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
