package com.example.limba;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
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

		audioPathPersisch = InternData.vokabel.getPersischeAussprache();
		audioPathDeutsch = InternData.vokabel.getDeutscheAussprache();

		((TextView) (findViewById(R.id.persischesTextfeld))).setText(InternData.vokabel
				.getPersischeVokabel());
		((TextView) (findViewById(R.id.deutschesTextfeld))).setText(InternData.vokabel
				.getDeutscheVokabel());

		microDeutschButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startRecordingDeutsch) {
					audioPathDeutsch = InternData.path + "/audio"
							+ InternData.counter + ".3gp";
					InternData.counter++;
					mediaRecorderDeutsch = AudioRecordTest.startRecording(
							mediaRecorderDeutsch, audioPathDeutsch);
					microDeutschButton.setImageResource(R.drawable.ic_microan);
				} else {
					AudioRecordTest.stopRecording(mediaRecorderDeutsch);
					InternData.vokabel.setDeutscheAussprache(audioPathDeutsch);
					microDeutschButton.setImageResource(R.drawable.ic_microaus);
				}
				startRecordingDeutsch = !startRecordingDeutsch;
			}
		});

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

		lautsprecherDeutschButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startPlayingDeutsch) {
					mediaPlayerDeutsch = AudioRecordTest.startPlaying(
							mediaPlayerDeutsch, audioPathDeutsch);
					lautsprecherDeutschButton
							.setImageResource(R.drawable.ic_lautsprecheran);
				} else {
					AudioRecordTest.stopPlaying(mediaPlayerDeutsch);
					lautsprecherDeutschButton
							.setImageResource(R.drawable.ic_lautsprecheraus);
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
		
		
		vokabellisteHinzufuegenButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				InternData.vokabelliste.addFirst(InternData.vokabel);
				startVokabellisteActivity();
				
				/*
				String  words = vokabel.getPersischeVokabel();
				String readString = "";
				try { 
//					/ We have to use the openFileOutput()-method
//					 * the ActivityContext provides, to
//					 * protect your file from others and
//					 * This is done for security-reasons.
//					 * We chose MODE_WORLD_READABLE, because
//					 *  we have nothing to hide in our file *          
					FileOutputStream fOut = openFileOutput("saveWords.txt",
							MODE_WORLD_READABLE);
					OutputStreamWriter osw = new OutputStreamWriter(fOut); 

					// Write the string to the file
					osw.write(words);

//					* ensure that everything is
//					 * really written out and close *
					osw.flush();
					osw.close();


				} catch (IOException ioe) {
					
					ioe.printStackTrace();
				}*/
			}
		});
	}

	protected void startVokabellisteActivity() {
		Intent intent2 = new Intent(this, VokabellisteActivity.class);
		this.startActivity(intent2);	
	}

	protected void startTrainierenActivity() {
		Intent intent2 = new Intent(this, Trainieren.class);
		this.startActivity(intent2);
	}

	@Override
	public void onPause() {
		super.onPause();
		if (mediaRecorderDeutsch != null) {
			mediaRecorderDeutsch.release();
			mediaRecorderDeutsch = null;
		}

		if (mediaPlayerPersisch != null) {
			mediaPlayerPersisch.release();
			mediaPlayerPersisch = null;
		}

		if (mediaPlayerDeutsch != null) {
			mediaPlayerDeutsch.release();
			mediaPlayerDeutsch = null;
		}
	}

}
