package com.example.demo.layer4.Exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Throwable  { // checking at a time of registration
 public UserAlreadyExistsException(String msg) {
	 super(msg);
 }
}