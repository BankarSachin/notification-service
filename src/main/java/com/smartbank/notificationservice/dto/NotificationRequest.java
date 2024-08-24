package com.smartbank.notificationservice.dto;

import java.time.LocalDateTime;

import com.smartbank.notificationservice.customvalidator.ValidDestinationAccount;
import com.smartbank.notificationservice.enums.NotificationType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@ValidDestinationAccount(message = "Destination account number is required for transfer notifications.")
public class NotificationRequest {
	
	@NotNull
	private NotificationType notificationType;
	
	private String destinationAccountNumber; 
	
	@NotNull
	private String txnAmmount;
	
	@NotNull
	private LocalDateTime txnDateTime;
	
	@NotNull
	private String currentBalance;
	
	@NotNull
	private String customerID;
	
	@NotNull
	private String utrNumber;
}
