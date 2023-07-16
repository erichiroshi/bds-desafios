package com.erichiroshi.bds01.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ClientDTO implements Serializable {

	private Long id;
	private String name;
	private String cpf;
	private BigDecimal income;
	private LocalDateTime birthDate;
	private Integer children;

}