package com.example.limba;

import java.util.Date;

public class Vokabel {
	private String deutscheVokabel;
	private String deutscheAussprache; // Pfad zur Datei
	private String persischeVokabel;
	private String persischeAussprache; // Pfad zur Datei
	private Vokabel next;
	private String picture; // Pfad zur Datei
	private Date date; // Erstellungsdatum 

	// Konstruktor
	public Vokabel() {
		deutscheVokabel = "";
		deutscheAussprache = "";
		persischeVokabel = "";
		persischeAussprache = "";
		next = null;
		picture = "";
		date = new Date();
	}

	// getter
	public String getDeutscheVokabel() {
		return deutscheVokabel;
	}

	public String getDeutscheAussprache() {
		return deutscheAussprache;
	}

	public String getPersischeVokabel() {
		return persischeVokabel;
	}

	public String getPersischeAussprache() {
		return persischeAussprache;
	}

	public Vokabel getNext() {
		return next;
	}

	public String getPicture() {
		return picture;
	}

	public Date getDate() {
		return date;
	}

	// setter
	public void setDeutscheVokabel(String deutscheVokabel) {
		this.deutscheVokabel = deutscheVokabel;
	}

	public void setDeutscheAussprache(String deutscheAussprache) {
		this.deutscheAussprache = deutscheAussprache;
	}

	public void setPersischeVokabel(String persischeVokabel) {
		this.persischeVokabel = persischeVokabel;
	}

	public void setPersischeAussprache(String persischeAussprache) {
		this.persischeAussprache = persischeAussprache;
	}

	public void setNext(Vokabel next) {
		this.next = next;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}