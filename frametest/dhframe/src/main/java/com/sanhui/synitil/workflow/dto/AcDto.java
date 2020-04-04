package com.sanhui.synitil.workflow.dto;

import java.io.Serializable;

public class AcDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6357529587241921220L;
	/**
	 * 
	 */

	private String id;
	private String name;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
