package com.example.limba;

import com.example.limba.R;

import android.os.Bundle;
import android.app.Activity;
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
		 * neue Wörter
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
		 * Wort hinzufügen
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
		// Intent intent = new Intent(this, VokabellisteActivity.class);
		// this.startActivity(intent);
	}

	protected void startBewertenActivity() {
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
