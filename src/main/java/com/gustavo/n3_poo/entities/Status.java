package com.gustavo.n3_poo.entities;

import java.io.Serializable;

import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "status")
public class Status implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String status;
	private String status_desc;
	
	public Status(String status, String status_desc) {
		super();
		this.status = status;
		this.status_desc = status_desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_desc() {
		return status_desc;
	}

	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}

}
