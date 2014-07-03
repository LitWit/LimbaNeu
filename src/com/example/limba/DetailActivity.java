package com.example.limba;

import java.io.FileDescriptor;
import java.io.FileOutputStream;

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
	
	private static ImageButton microButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vokabeldetail_neu);
		
		microButton = (ImageButton) findViewById(R.id.button1);
		
		
		Intent intent = getIntent();

		int position = (int) intent.getIntExtra("position", 0);

		Vokabel vokabel = new Vokabel();
		vokabel.setNext(InternData.liste.getBegin());
		for (int i = 0; i < position; i++) {
			vokabel.setNext(vokabel.getNext().getNext());
		}

		((TextView) (findViewById(R.id.editText1))).setText(vokabel
				.getNext().getPersischeVokabel());
		/*((TextView) (findViewById(R.id.persischesTextfeld))).setText(vokabel
				.getNext().getPersischeVokabel()); */
		
		microButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				MediaRecorder micro = new MediaRecorder();
				micro.setAudioSource(MediaRecorder.AudioSource.MIC);
				micro.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				//FileOutputStream f = 
//				getResources().openRawResource(R.);
				
				
			}
		});
		
		}
}
