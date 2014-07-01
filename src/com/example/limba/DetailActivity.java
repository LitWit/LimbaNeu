package com.example.limba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vokabeldetail_neu);

		Intent intent = getIntent();

		int position = (int) intent.getIntExtra("position", 0);

		Vokabel vokabel = new Vokabel();
		vokabel.setNext(InternData.liste.getBegin());
		for (int i = 0; i < position; i++) {
			vokabel.setNext(vokabel.getNext().getNext());
		}

		((TextView) (findViewById(R.id.editText1))).setText(vokabel
				.getNext().getPersischeVokabel());
		((TextView) (findViewById(R.id.persischesTextfeld))).setText(vokabel
				.getNext().getPersischeVokabel());
	}
}
