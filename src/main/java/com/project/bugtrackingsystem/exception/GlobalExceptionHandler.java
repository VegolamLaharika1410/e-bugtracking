package com.project.bugtrackingsystem.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
 
import java.time.LocalDateTime;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest; // Import this class
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ProjectException.class)
	@ResponseBody
	public String handleAddressException(ProjectException e) {
		return e.getMessage();
	}
	@ExceptionHandler(BugException.class)
    @ResponseBody
    public String handleBugException(BugException e) {
        return e.getMessage();
    }
	@ExceptionHandler(UserNotAvailableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleUserNotAvailableException(UserNotAvailableException e) {
        return e.getMessage();
    }
}
