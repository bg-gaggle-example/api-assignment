package com.example.apiassignment;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private static final String message = "Welcome to the machine.";

	private static final String currentTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}

	@GetMapping("/welcome")
	public Welcome welcome() {
		return new Welcome(message, currentTime());
	}
}
