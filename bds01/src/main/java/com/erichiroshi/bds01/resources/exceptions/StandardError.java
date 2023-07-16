package com.erichiroshi.bds01.resources.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {

	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
}