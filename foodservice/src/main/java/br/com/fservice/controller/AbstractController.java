package br.com.fservice.controller;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract  class  AbstractController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	public abstract Class<?> getControllerClass();
	
	
	public Logger getLogger(){
		Logger logger = LogManager.getLogger(getControllerClass());
		return logger;
	}

	
}
