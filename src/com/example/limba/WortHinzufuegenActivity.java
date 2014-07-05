package com.example.limba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class WortHinzufuegenActivity extends Activity {

	private static Button bildButton;
	private static Button profilbildButton;
	private static Button wortHinzufuegenButton;

	private static ImageButton microPersischButton;
	private static ImageButton lautsprecherPersischButton;
	private static ImageButton microDeutschButton;
	private static ImageButton lautsprecherDeutschButton;

	private static TextView persischesTextfeld;
	private static TextView deutschesTextfeld;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wort_hinzufuegen);

		bildButton = (Button) findViewById(R.id.bildbutton);
		profilbildButton = (Button) findViewById(R.id.profilbildButton);
		wortHinzufuegenButton = (Button) findViewById(R.id.wortHinzufuegenButton);

		microPersischButton = (ImageButton) findViewById(R.id.microPersischButton);
		lautsprecherPersischButton = (ImageButton) findViewById(R.id.lautsprecherPersischButton);
		microDeutschButton = (ImageButton) findViewById(R.id.microDeutschButton);
		lautsprecherDeutschButton = (ImageButton) findViewById(R.id.lautsprecherDeutschButton);

		persischesTextfeld = (TextView) findViewById(R.id.persischesTextfeld);
		deutschesTextfeld = (TextView) findViewById(R.id.deutschesTextfeld);

		/**
		 * Wort hinzufügen
		 */
		wortHinzufuegenButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO leere Wörter unterbinden (später, so schöner zu testen)
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
