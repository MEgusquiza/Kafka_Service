package com.bank.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditPayment  implements Serializable{
	
		@Id
		private String id;
		private Double amount;
	//	private Purchase purchase;
		private String description = "";	
	//	@JsonFormat(pattern="dd-MM-yyyy" )
	//	 private LocalDate paymentDate;
//		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	//	private LocalDateTime paymentDate = LocalDateTime.now();

}
