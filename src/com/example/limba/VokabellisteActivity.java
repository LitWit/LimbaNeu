package com.example.limba;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.limba.R;

public class VokabellisteActivity extends Activity {

	private static ListView vokabelliste;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neue_woerter);

		vokabelliste = (ListView) findViewById(R.id.neue_woerter_liste);

		List valueList = new ArrayList<TextView>();
		
		for (Vokabel vokabel : InternData.vokabelliste) {
			valueList.add(vokabel.getPersischeVokabel());
		} 

		ListAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),
				android.R.layout.simple_list_item_1, valueList);

		vokabelliste.setAdapter(adapter);

		vokabelliste.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				//startDetailActivity(position);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}