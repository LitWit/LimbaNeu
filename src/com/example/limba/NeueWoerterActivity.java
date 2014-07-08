package com.example.limba;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
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

public class NeueWoerterActivity extends Activity {

	private static ListView neue_woerter_liste;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neue_woerter);

		neue_woerter_liste = (ListView) findViewById(R.id.neue_woerter_liste);

		List valueList = new ArrayList<TextView>();
		Vokabel nextVokabel = new Vokabel();
		nextVokabel.setNext(InternData.liste.getBegin());
		

		while (nextVokabel.getNext() != null) {
			valueList.add(nextVokabel.getNext().getPersischeVokabel());
			nextVokabel.setNext(nextVokabel.getNext().getNext());
		}

		ListAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),
				android.R.layout.simple_list_item_1, valueList);

		neue_woerter_liste.setAdapter(adapter);

		neue_woerter_liste.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				startDetailActivity(position);
			}
		});
	}

	protected void startDetailActivity(int position) {
		Intent intent = new Intent(this, DetailActivity.class);
		intent.putExtra("position", position);
		this.startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}