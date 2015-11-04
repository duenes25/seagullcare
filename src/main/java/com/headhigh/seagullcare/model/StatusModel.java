package com.headhigh.seagullcare.model;

public class StatusModel {

	private boolean error;
	private String errorMessage;
	
	
	
	public StatusModel() {
		super();
		this.error = true;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	
	
}
