package com.example.apiassignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private static final String message = "Welcome to the machine.";

	private static final String currentISOTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
		String formattedISOTime = currentDateTime.format(formatter);
		return formattedISOTime;
	}

	@GetMapping("/welcome")
	public Welcome welcome() {
		return new Welcome(message, currentISOTime());
	}
}
