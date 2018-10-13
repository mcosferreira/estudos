package br.msf.estudo.jsf.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/*
 * Factory needed to uses the Custom JsfException Handler
 * Declares it in faces-config.xml at <factory><exception-handler-factory>
 */
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
