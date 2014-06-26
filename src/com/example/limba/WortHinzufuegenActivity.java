package com.example.limba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WortHinzufuegenActivity extends Activity {

	private static Button bildButton;
	private static Button button1;
	private static Button wortHinzufuegenButton;
	private static Button button3;
	private static Button button4;
	private static Button button5;
	private static Button button6;
	private static TextView deutschesTextfeld;
	private static TextView persischesTextfeld;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wort_hinzufuegen);

		bildButton = (Button) findViewById(R.id.bildButton);
		button1 = (Button) findViewById(R.id.button1);
		wortHinzufuegenButton = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		persischesTextfeld = (TextView) findViewById(R.id.persischesTextfeld);
		deutschesTextfeld = (TextView) findViewById(R.id.editText2);

		/**
		 * Wort hinzufügen
		 */
		wortHinzufuegenButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Vokabel vokabel = new Vokabel();
				vokabel.setDeutscheVokabel(deutschesTextfeld.getText()
						.toString());
				vokabel.setPersischeVokabel((String) persischesTextfeld
						.getText().toString());
				// TODO Bild und Audio ebenfalls in "vokabel" speichern

				InternData.liste.add(vokabel);

				startMainActivity();
			}
		});
	}

	protected void startMainActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		this.startActivity(intent);
	}
}
