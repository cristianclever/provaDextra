package br.com.fservice.http.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@WebListener("HTTPSession listener")
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener  {

	
	
	public Logger getLogger(){
		Logger logger = LogManager.getLogger(SessionListener.class);
		return logger;
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
}
