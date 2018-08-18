package br.msf.estudo.jsf.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class JsfAppExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;
	
	public JsfAppExceptionHandlerFactory(ExceptionHandlerFactory p) {
		this.parent = p;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new JsfAppExceptionHandler(parent.getExceptionHandler());
	}

}
