package com.cg.app.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.app.dto.ErrorInfo;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	@ResponseBody
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED, reason = "A User_Exception occured!")
	@ExceptionHandler(value = {UserException.class})
	protected ErrorInfo handleUserConflict(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, bodyOfResponse);
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED, reason = "A Property_Exception occured!")
	@ExceptionHandler(value = {PropertyException.class})
	protected ErrorInfo handlePropertyConflict(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, bodyOfResponse);
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Invalid Login Credentials!")
	@ExceptionHandler(value = {UserNotFoundException.class})
	protected ErrorInfo handleLoginConflict(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, bodyOfResponse);
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CONFLICT, reason = "Registration Failed! UserID already exist.")
	@ExceptionHandler(value = {UserAlreadyExistException.class})
	protected ErrorInfo handleRegistrationConflict(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, bodyOfResponse);
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Image dosen't exist for this Property.")
	@ExceptionHandler(value = {NoImageFoundException.class})
	protected ErrorInfo handleImageException(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, bodyOfResponse);
	}
	
}
