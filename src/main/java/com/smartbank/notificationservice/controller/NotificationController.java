package com.smartbank.notificationservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartbank.notificationservice.dto.NotificationRequest;
import com.smartbank.notificationservice.dto.NotificationResponse;
import com.smartbank.notificationservice.service.EmailService;

import jakarta.validation.Valid;

/**
 * Sends mail to given email address
 * 
 * @author Sachin
 */
@Controller
@RequestMapping("/v1/")
public class NotificationController {

	@Autowired
	private EmailService emailService;

	@PostMapping(value = "/notifications/{accountnumber}/notify", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationResponse> notify(@RequestHeader Map<String, String> headers,
			@PathVariable(name = "accountnumber") String accountNumber, @Valid @RequestBody NotificationRequest request)
			throws Exception {
		final NotificationResponse notificationResponse = emailService.sendEmail(accountNumber, request);
		return ResponseEntity.status(HttpStatus.OK).body(notificationResponse);
	}
}
