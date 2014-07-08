package com.example.limba;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Trainieren extends ActionBarActivity {

	private static ImageButton lautsprecherPersischButton;
	private static ImageButton microVersuchButton;
	private static ImageButton lautsprecherVersuchButton;
	private static TextView textBewertung1;
	private static TextView textBewertung2;
	private static Button neuerVersuchButton;

	private MediaPlayer mediaPlayerPersisch = null;
	private MediaRecorder mediaRecorderVersuchPersisch = null;
	private MediaPlayer mediaPlayerVersuchPersisch = null;

	boolean startPlayingPersisch = true;
	boolean startPlayingVersuchPersisch = true;
	boolean startRecordingVersuchPersisch = true;

	String audioPathPersisch = InternData.vokabel.getPersischeAussprache();
	String audioPathVersuchPersisch = "";

	private static Vokabel vokabel = new Vokabel();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.training);

		lautsprecherPersischButton = (ImageButton) findViewById(R.id.lautsprecherPersischButton);
		microVersuchButton = (ImageButton) findViewById(R.id.microVersuchButton);
		lautsprecherVersuchButton = (ImageButton) findViewById(R.id.lautsprecherVersuschButton);
		textBewertung1 = (TextView) findViewById(R.id.textBewertung1);
		textBewertung2 = (TextView) findViewById(R.id.textBewertung2);
		neuerVersuchButton = (Button) findViewById(R.id.neuerVersuchButton);

		lautsprecherPersischButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startPlayingPersisch) {
					mediaPlayerPersisch = AudioRecordTest.startPlaying(
							mediaPlayerPersisch, audioPathPersisch);
					lautsprecherPersischButton
							.setImageResource(R.drawable.ic_lautsprecheran);
				} else {
					AudioRecordTest.stopPlaying(mediaPlayerPersisch);
					lautsprecherPersischButton
							.setImageResource(R.drawable.ic_lautsprecheraus);
				}
				startPlayingPersisch = !startPlayingPersisch;
			}
		});

		microVersuchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startRecordingVersuchPersisch) {
					audioPathVersuchPersisch = InternData.path
							+ "/audioVersuch" + InternData.counter + ".3gp";
					InternData.counter++;
					mediaRecorderVersuchPersisch = AudioRecordTest
							.startRecording(mediaRecorderVersuchPersisch,
									audioPathVersuchPersisch);
					microVersuchButton.setImageResource(R.drawable.ic_microan);
				} else {
					AudioRecordTest.stopRecording(mediaRecorderVersuchPersisch);
					vokabel.setDeutscheAussprache(audioPathVersuchPersisch);
					microVersuchButton.setImageResource(R.drawable.ic_microaus);

					textBewertung1.setVisibility(View.VISIBLE);
					textBewertung2.setVisibility(View.VISIBLE);
					neuerVersuchButton.setVisibility(View.VISIBLE);
				}
				startRecordingVersuchPersisch = !startRecordingVersuchPersisch;
			}
		});

		lautsprecherVersuchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startPlayingVersuchPersisch) {
					mediaPlayerVersuchPersisch = AudioRecordTest.startPlaying(
							mediaPlayerVersuchPersisch,
							audioPathVersuchPersisch);
					lautsprecherVersuchButton
							.setImageResource(R.drawable.ic_lautsprecheran);
				} else {
					AudioRecordTest.stopPlaying(mediaPlayerPersisch);
					lautsprecherVersuchButton
							.setImageResource(R.drawable.ic_lautsprecheraus);
				}
				startPlayingVersuchPersisch = !startPlayingVersuchPersisch;
			}
		});
	}

	@Override
	public void onPause() {
		super.onPause();
		if (mediaPlayerPersisch != null) {
			mediaPlayerPersisch.release();
			mediaPlayerPersisch = null;
		}

		if (mediaRecorderVersuchPersisch != null) {
			mediaRecorderVersuchPersisch.release();
			mediaRecorderVersuchPersisch = null;
		}

		if (mediaPlayerVersuchPersisch != null) {
			mediaPlayerVersuchPersisch.release();
			mediaPlayerVersuchPersisch = null;
		}
	}

}
