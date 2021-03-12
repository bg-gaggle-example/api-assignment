package com.example.apiassignment;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalTime;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void callingWelcomeShouldReturnDefaultHardcodedMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/welcome",
				String.class)).contains("Welcome to the machine.");
	}

  @Test
	public void callingWelcomeShouldReturnISOTimestamp() throws Exception {
    String test = this.restTemplate.getForObject("http://localhost:" + port + "/welcome", String.class);
    JSONObject obj = new JSONObject(test);
    String timestamp = obj.getString("timestamp");
		//this is a little hacky. i originally intended to grab the pattern of the timestamp
		//returned in the json. But then I realized that parsing the text with LocalTime wouldn't
		//work unless it was a valid date in the first place.
		assertThat(LocalTime.parse(timestamp));
	}
}
