package com.example.apiassignment;

public class Welcome {

	private final String message;
	private final String timestamp;

	public Welcome(String message, String timestamp) {
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getTimestamp() {
		return timestamp;
	}
}
