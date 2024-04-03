package com.project.bugtrackingsystem.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	 
	private LocalDateTime ldt;
	private String message;
	private String details;
 
	public ErrorDetails(LocalDateTime ldt, String message, String details) {
		super();
		this.ldt = ldt;
		this.message = message;
		this.details = details;
	}
 
	public LocalDateTime getLdt() {
		return ldt;
	}
 
	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}
 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
 
	public String getDetails() {
		return details;
	}
 
	public void setDetails(String details) {
		this.details = details;
	}
 
	@Override
	public String toString() {
		return "ErrorDetails [ldt=" + ldt + ", message=" + message + ", details=" + details + "]";
	}
 
}