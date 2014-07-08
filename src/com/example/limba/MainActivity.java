package com.example.limba;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
>>>>>>> FETCH_HEAD

import com.example.limba.R;
import com.example.limba.NeueWoerterActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private static Button neue_woerter_button;
	private static Button vokabelliste_button;
	private static Button bewerten_button;
	private static Button wort_hinzufuegen_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainboard);

		neue_woerter_button = (Button) findViewById(R.id.neue_woerter_button);
		vokabelliste_button = (Button) findViewById(R.id.vokabelliste_button);
		bewerten_button = (Button) findViewById(R.id.bewerten_button);
		wort_hinzufuegen_button = (Button) findViewById(R.id.wort_hinzufuegen_button);		
		
		/**
		 * neue W�rter
		 */
		neue_woerter_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startNeueWoerterActivity();
			}

		});

		/**
		 * Vokabelliste
		 */
		vokabelliste_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startVokabellisteActivity();
			}
		});

		/**
		 * Bewerten
		 */
		bewerten_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startBewertenActivity();
			}
		});

		/**
		 * Wort hinzuf�gen
		 */
		wort_hinzufuegen_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {				 
				startWortHinzufuegenActivity();
			}
		});
	}

	protected void startNeueWoerterActivity() {
		Intent intent = new Intent(this, NeueWoerterActivity.class);
		this.startActivity(intent);
	}

	protected void startVokabellisteActivity() {
		// TODO
<<<<<<< HEAD
		Intent intent = new Intent(this, Vokabelliste.class);
		this.startActivity(intent);
=======
		// Intent intent = new Intent(this, VokabellisteActivity.class);
		// this.startActivity(intent);
		
		//Reading the file back...

		/* We have to use the openFileInput()-method
		 * the ActivityContext provides.
		 * Again for security reasons with
		 * openFileInput(...) */

		FileInputStream fIn;
		try {
			fIn = openFileInput("samplefile.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		InputStreamReader isr = new InputStreamReader(fIn);

		/* Prepare a char-Array that will
		 * hold the chars we read back in. */
//		char[] inputBuffer = new char[wordTosave];

		// Fill the Buffer with data from the file
//		isr.read(inputBuffer);

		// Transform the chars to a String
//		readString = new String(inputBuffer);

		// Check if we read back the same chars that we had written out
//		boolean isTheSame = TESTSTRING.equals(readString);

//		Log.i("File Reading stuff", "success = " + isTheSame);
>>>>>>> FETCH_HEAD
	}

	protected void startBewertenActivity() {
		// TODO
			 Intent intent = new Intent(this, AudioRecordTest.class);
		//Intent intent = new Intent(this, Trainieren.class);
		this.startActivity(intent);

		// Intent intent = new Intent(this, BewertenActivity.class);
		// this.startActivity(intent);
	}

	protected void startWortHinzufuegenActivity() {
		Intent intent = new Intent(this, WortHinzufuegenActivity.class);
		this.startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
