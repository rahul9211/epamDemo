package com.example.epamPoc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@IdClass(DatabaseDetailPK.class)
public class DatabasesDetail {

	@Id
	private String databaseNameString;
	@Id
	private String host;
	@Id
	private int port;

	private String dbenv;
	
}
