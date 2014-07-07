package com.example.limba;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.Menu;

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

	MediaPlayer audioPersisch = new MediaPlayer();

	// Audio
	private MediaRecorder mediaRecorderPersisch = null;
	private MediaRecorder mediaRecorderDeutsch = null;
	private MediaPlayer mediaPlayerPersisch = null;
	private MediaPlayer mediaPlayerDeutsch = null;
	boolean startRecordingPersisch = true;
	boolean startRecordingDeutsch = true;
	boolean startPlayingPersisch = true;
	boolean startPlayingDeutsch = true;

	String path = Environment.getExternalStorageDirectory().getAbsolutePath();
	String audioPathPersisch = path + "/LimbaPersisch.3gp";
	String audioPathDeutsch = path + "/LimbaDeutsch.3gp";

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

		// Audioaufnahme vorbereiten
		mediaRecorderPersisch = new MediaRecorder();

		microPersischButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startRecordingPersisch) {
					mediaRecorderPersisch = startRecording(
							mediaRecorderPersisch, audioPathPersisch);
				} else {
					stopRecording(mediaRecorderPersisch);
				}
				startRecordingPersisch = !startRecordingPersisch;
			}
		});

		lautsprecherPersischButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startPlayingPersisch) {
					mediaPlayerPersisch = startPlaying(mediaPlayerPersisch,
							audioPathPersisch);
				} else {
					stopPlaying(mediaPlayerPersisch);
				}
				startPlayingPersisch = !startPlayingPersisch;
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

	private MediaRecorder startRecording(MediaRecorder mediaRecorder,
			String path) {
		mediaRecorder = new MediaRecorder();
		mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		mediaRecorder.setOutputFile(path);
		mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		try {
			mediaRecorder.prepare();
		} catch (IOException e) {
			// TODO
		}
		mediaRecorder.start();
		return mediaRecorder;
	}

	private void stopRecording(MediaRecorder mediaRecorder) {
		try {
			mediaRecorder.stop();
			mediaRecorder.release();
		} catch (IllegalStateException e) {
			// TOdo
		}
		mediaRecorder = null;
	}

	private MediaPlayer startPlaying(MediaPlayer mediaPlayer, String path) {
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (IOException e) {
			// TODO
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return mediaPlayer;
	}

	private void stopPlaying(MediaPlayer mediaPlayer) {
		mediaPlayer.release();
		mediaPlayer = null;
	}

}
