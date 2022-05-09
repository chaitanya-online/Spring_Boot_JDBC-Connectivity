package com.Jdbc.example.Entity;

public class Serole {

	private int E_id;
	private String E_Name;
	private String E_Mail;

	public Serole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Serole(int e_id, String e_Name, String e_Mail) {
		super();
		E_id = e_id;
		E_Name = e_Name;
		E_Mail = e_Mail;
	}

	public int getE_id() {
		return E_id;
	}

	public void setE_id(int e_id) {
		E_id = e_id;
	}

	public String getE_Name() {
		return E_Name;
	}

	public void setE_Name(String e_Name) {
		E_Name = e_Name;
	}

	public String getE_Mail() {
		return E_Mail;
	}

	public void setE_Mail(String e_Mail) {
		E_Mail = e_Mail;
	}

}
