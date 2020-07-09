package com.olmedo.evfinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(schema="public", name="Autorithy")
public class Autorithy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	
	@Column
	private String authority;
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
