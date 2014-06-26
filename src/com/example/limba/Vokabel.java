package com.example.limba;

import java.util.Date;

import android.graphics.Picture;

public class Vokabel {
	private String deutscheVokabel;
	private Object deutscheAussprache; // TODO Object ersetzen
	private String persischeVokabel;
	private Object persischeAussprache; // TODO Object ersetzen
	private Vokabel next;
	private Picture picture;
	private Date date; // Erstellungsdatum

	// Konstruktor
	public Vokabel() {
		deutscheVokabel = "";
		deutscheAussprache = "";
		persischeVokabel = "";
		persischeAussprache = "";
		next = null;
		picture = null;
		date = new Date();
	}

	// getter
	public String getDeutscheVokabel() {
		return deutscheVokabel;
	}

	public Object getDeutscheAussprache() {
		return deutscheAussprache;
	}

	public String getPersischeVokabel() {
		return persischeVokabel;
	}

	public Object getPersischeAussprache() {
		return persischeAussprache;
	}

	public Vokabel getNext() {
		return next;
	}

	public Picture getPicture() {
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

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
}