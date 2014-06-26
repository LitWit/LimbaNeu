package com.example.limba;

//einfach verkettete Liste aus Vokabeln
public class Vokabelliste {
	private Vokabel begin;
	private int size;

	// Konstruktor
	public Vokabelliste() {
		begin = null;
		size = 0;
	}

	public void add(Vokabel vokabel) {
		vokabel.setNext(begin);
		begin = vokabel;
		size += 1;
	}

	public Vokabel getBegin() {
		return begin;
	}

	public int size() {
		return size;
	}
}