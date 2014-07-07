package com.example.limba;

import android.app.Activity;
import android.media.MediaRecorder;
import android.media.MediaPlayer;

import java.io.IOException;

public class AudioRecordTest extends Activity {

	public static MediaRecorder startRecording(MediaRecorder mediaRecorder,
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

	public static void stopRecording(MediaRecorder mediaRecorder) {
		try {
			mediaRecorder.stop();
			mediaRecorder.release();
		} catch (IllegalStateException e) {
			// TOdo
		}
		mediaRecorder = null;
	}

	public static MediaPlayer startPlaying(MediaPlayer mediaPlayer, String path) {
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

	public static void stopPlaying(MediaPlayer mediaPlayer) {
		mediaPlayer.release();
		mediaPlayer = null;
	}

}