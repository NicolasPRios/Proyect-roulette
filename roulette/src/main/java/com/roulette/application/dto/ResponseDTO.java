package com.roulette.application.dto;

/**
 * Data transfer object for an answer mere
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public class ResponseDTO {
	private int Code;
	private String Message;

	public int getCode() {

		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	public String getMessage() {

		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
