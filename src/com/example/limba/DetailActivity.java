package com.example.limba;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
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
	private static ImageButton lautsprecherPersischButton;
	private static ImageButton microDeutschButton;
	private static ImageButton lautsprecherDeutschButton;
	private static TextView persischesTextfeld;
	private static EditText deutschesTextfeld;

	// Audio
	private MediaRecorder mediaRecorderPersisch = null;
	private MediaRecorder mediaRecorderDeutsch = null; 
	private MediaPlayer mediaPlayerPersisch = null;
	private MediaPlayer mediaPlayerDeutsch = null;
	boolean startRecordingPersisch = true;
	boolean startRecordingDeutsch = true;
	boolean startPlayingPersisch = true;
	boolean startPlayingDeutsch = true;

	String audioPathPersisch = "";
	String audioPathDeutsch = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vokabeldetail);

		bildButton = (Button) findViewById(R.id.bildButton);
		vokabellisteHinzufuegenButton = (Button) findViewById(R.id.vokabellisteHinzufuegenButton);
		trainierenButton = (Button) findViewById(R.id.trainierenButton);
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
		InternData.vokabel = vokabel.getNext();
		audioPathPersisch = vokabel.getNext().getPersischeAussprache();
		audioPathDeutsch = vokabel.getNext().getDeutscheAussprache();

		((TextView) (findViewById(R.id.persischesTextfeld))).setText(vokabel
				.getNext().getPersischeVokabel());
		((TextView) (findViewById(R.id.deutschesTextfeld))).setText(vokabel
				.getNext().getDeutscheVokabel());

		lautsprecherPersischButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startPlayingPersisch) {
					mediaPlayerPersisch = AudioRecordTest.startPlaying(
							mediaPlayerPersisch, audioPathPersisch);
					lautsprecherPersischButton.setBackgroundResource(R.drawable.ic_lautsprecheran);
				} else {
					AudioRecordTest.stopPlaying(mediaPlayerPersisch);
					lautsprecherPersischButton.setBackgroundResource(R.drawable.ic_lautsprecheraus);
				}
				startPlayingPersisch = !startPlayingPersisch;
			}
		});
		
		lautsprecherDeutschButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startPlayingDeutsch) {
					mediaPlayerDeutsch = AudioRecordTest.startPlaying(
							mediaPlayerDeutsch, audioPathDeutsch);
					lautsprecherDeutschButton.setBackgroundResource(R.drawable.ic_lautsprecheran);
				} else {
					AudioRecordTest.stopPlaying(mediaPlayerDeutsch);
					lautsprecherDeutschButton.setBackgroundResource(R.drawable.ic_lautsprecheraus);
				}
				startPlayingDeutsch = !startPlayingDeutsch;
			}
		});

		/**
		 * Trainieren
		 */
		trainierenButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startTrainierenActivity();
			}
		});
	}

	protected void startTrainierenActivity() {
		// TODO Auto-generated method stub
		Intent intent2 = new Intent(this, Trainieren.class);
		this.startActivity(intent2);
	}

}
