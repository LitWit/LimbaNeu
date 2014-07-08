package com.example.limba;

import java.util.LinkedList;

import android.os.Environment;

public class InternData {
	public static LinkedList<Vokabel> liste = new LinkedList<Vokabel>();
	public static LinkedList<Vokabel> vokabelliste = new LinkedList<Vokabel>();
	public static Vokabel vokabel = new Vokabel();
	//counter für die Audiopaths 
	public static int counter = 0;
	public static String path = Environment.getExternalStorageDirectory().getAbsolutePath();
}
