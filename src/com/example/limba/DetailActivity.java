package com.example.limba;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailActivity extends Activity {

	private static Button bildButton;
	private static Button vokabellisteHinzufuegenButton;
	private static Button trainierenButton;

	private static ImageButton microPersischButton;
	private static ImageButton lautsprecherPersischButton;
	private static ImageButton microDeutschButton;
	private static ImageButton lautsprecherDeutschButton;

	private static TextView persischesTextfeld;
	private static EditText deutschesTextfeld;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vokabeldetail);

		bildButton = (Button) findViewById(R.id.bildButton);
		vokabellisteHinzufuegenButton = (Button) findViewById(R.id.vokabellisteHinzufuegenButton);
		trainierenButton = (Button) findViewById(R.id.trainierenButton);

		microPersischButton = (ImageButton) findViewById(R.id.microPersischButton);
		lautsprecherPersischButton = (ImageButton) findViewById(R.id.lautsprecherPersischButton);
		microDeutschButton = (ImageButton) findViewById(R.id.microDeutschButton);
		lautsprecherDeutschButton = (ImageButton) findViewById(R.id.lautsprecherDeutschButton);

		persischesTextfeld = (TextView) findViewById(R.id.persischesTextfeld);

		deutschesTextfeld = (EditText) findViewById(R.id.deutschesTextfeld);

		Intent intent = getIntent();

		int position = (int) intent.getIntExtra("position", 0);

		Vokabel vokabel = new Vokabel();
		vokabel.setNext(InternData.liste.getBegin());
		for (int i = 0; i < position; i++) {
			vokabel.setNext(vokabel.getNext().getNext());
		}

		((TextView) (findViewById(R.id.persischesTextfeld))).setText(vokabel
				.getNext().getPersischeVokabel());
		((TextView) (findViewById(R.id.deutschesTextfeld))).setText(vokabel
				.getNext().getDeutscheVokabel());

		microPersischButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				MediaRecorder micro = new MediaRecorder();
				micro.setAudioSource(MediaRecorder.AudioSource.MIC);
				micro.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				// FileOutputStream f =
				// getResources().openRawResource(R.);

			}
		});

	}
}
