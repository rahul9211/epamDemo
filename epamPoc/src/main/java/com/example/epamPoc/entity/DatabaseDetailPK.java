package com.example.epamPoc.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DatabaseDetailPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String databaseNameString;
	private String host;
	private int port;
	
}
