package cl.mobile.bff.domain;

import java.io.Serializable;

public class ErrorApi implements Serializable{
	private static final long serialVersionUID = -5641089898612756612L;
	private String message;
	
	public ErrorApi(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
