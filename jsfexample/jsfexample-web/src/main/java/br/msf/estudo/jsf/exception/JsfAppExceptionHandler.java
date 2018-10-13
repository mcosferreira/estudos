package br.msf.estudo.jsf.exception;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/*
 * A Custom Exception Handler 
 */
public class JsfAppExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;
	
	public JsfAppExceptionHandler(ExceptionHandler w) {
		this.wrapped = w;
	}
	
	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}
	
	/*
	 * Handle all of the exceptions
	 */
	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();
		
		while (i.hasNext()) {
			
			ExceptionQueuedEvent event = i.next();
			
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			
			Throwable throwable = context.getException();
			
			try {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				
				NavigationHandler navHandler = facesContext.getApplication().getNavigationHandler();
				
				navHandler.handleNavigation(facesContext, null, "pages/errors/error.jsf?faces-redirect=true");
				
				facesContext.renderResponse();
				
			} finally {
				i.remove();
			
			}
			
			getWrapped().handle();
		}
	}

}
