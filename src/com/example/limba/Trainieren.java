package com.example.limba;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Trainieren extends ActionBarActivity {

	private static ImageButton lautsprecherPersischButton;
	private static ImageButton microVersuchButton;
	private static ImageButton lautsprecherVersuchButton;
	
	private MediaPlayer mediaPlayerPersisch = null;

	private MediaRecorder mediaRecorderVersuchPersisch = null;
	private MediaPlayer mediaPlayerVersuchPersisch = null;

	boolean startPlayingPersisch = true;
	
	boolean startPlayingVersuchPersisch = true;
	boolean startRecordingVersuchPersisch = true;
	
	String audioPathPersisch = "";
	String audioPathVersuchPersisch = "";
	
	private static Vokabel vokabel = new Vokabel();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trainieren);

		lautsprecherPersischButton = (ImageButton) findViewById(R.id.lautsprecherPersischButton);
		microVersuchButton = (ImageButton) findViewById(R.id.microVersuchButton);
		lautsprecherVersuchButton = (ImageButton) findViewById(R.id.lautsprecherVersuschButton);

		lautsprecherPersischButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startPlayingPersisch) {
					mediaPlayerPersisch = AudioRecordTest.startPlaying(
							mediaPlayerPersisch, audioPathPersisch);
					lautsprecherPersischButton.setImageResource(R.drawable.ic_lautsprecheran);
				} else {
					AudioRecordTest.stopPlaying(mediaPlayerPersisch);
					lautsprecherPersischButton.setImageResource(R.drawable.ic_lautsprecheraus);
				}
				startPlayingPersisch = !startPlayingPersisch;
			}
		});
		
		microVersuchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startRecordingVersuchPersisch) {
					audioPathVersuchPersisch = InternData.path + "/audioVersuch"
							+ InternData.counter + ".3gp";
					InternData.counter++;
					mediaRecorderVersuchPersisch = AudioRecordTest.startRecording(
							mediaRecorderVersuchPersisch, audioPathVersuchPersisch);
					microVersuchButton.setImageResource(R.drawable.ic_microan);
				} else {
					AudioRecordTest.stopRecording(mediaRecorderVersuchPersisch);
					vokabel.setDeutscheAussprache(audioPathVersuchPersisch);
					microVersuchButton.setImageResource(R.drawable.ic_microaus);
				}
				startRecordingVersuchPersisch = !startRecordingVersuchPersisch;
			}
		});
		
		lautsprecherVersuchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startPlayingVersuchPersisch) {
					mediaPlayerVersuchPersisch = AudioRecordTest.startPlaying(
							mediaPlayerVersuchPersisch, audioPathVersuchPersisch);
					lautsprecherVersuchButton.setImageResource(R.drawable.ic_lautsprecheran);
				} else {
					AudioRecordTest.stopPlaying(mediaPlayerPersisch);
					lautsprecherVersuchButton.setImageResource(R.drawable.ic_lautsprecheraus);
				}
				startPlayingVersuchPersisch = !startPlayingVersuchPersisch;
			}
		});
		
	}

	/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.trainieren, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}	
	 */
}
