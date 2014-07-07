package com.example.limba;

import android.os.Environment;

public class InternData {
	public static Vokabelliste liste = new Vokabelliste();
	 // hier Glaucia
	public static Vokabel vokabel = new Vokabel();
	//counter für die Audiopaths 
	public static int counter = 0;
	public static String path = Environment.getExternalStorageDirectory().getAbsolutePath();
}
