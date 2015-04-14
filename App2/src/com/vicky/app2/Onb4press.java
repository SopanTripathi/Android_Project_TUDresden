package com.vicky.app2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Onb4press extends Activity {

	private ListView obj;
	DBHelper mydb;
	Button B1;
	int id_To_Update = 0;
	String getlat, getlong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Context context = this;
		// Setting Action listeners on button
		B1 = (Button) findViewById(R.id.b1);
		B1.setOnClickListener(new OnClickListener() {

			// Setting up the new view by passing intent through button action
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, AllButtonActivity.class);
				startActivity(intent);
			}
		});
		mydb = new DBHelper(this);


		ArrayList array_list = mydb.getAllCotacts();

		ArrayAdapter arrayAdapter = new ArrayAdapter(this,
				android.R.layout.simple_list_item_1, array_list);

		// adding it to the list view.
		obj = (ListView) findViewById(R.id.listView1);
		obj.setAdapter(arrayAdapter);

		obj.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				
				
			//Initializing above Variables
				getlat= "";
				getlong="";
				int id = arg2;

				//call the Userdefined method of getting data from DBHelper class
				Cursor C = mydb.getDataa(id);
				if(C.moveToFirst()){
					do{
						getlat = C.getString(0);
						getlong = C.getString(1);
						
						
					}while(C.moveToNext());
				}
		        mydb.close();

		        
		       Toast.makeText(getApplicationContext(), "Latitude of Dept. is "+getlat+ " and Longitude is "+getlong, Toast.LENGTH_LONG).show();
		       Intent intent = new Intent(getApplicationContext(),com.vicky.app2.Onb4pressmap.class);
		       //Adding key-value pair
		      
		       //Converting double to string
		       intent.putExtra("com.vicky.app2.x", Double.parseDouble(getlat));
		       intent.putExtra("com.vicky.app2.y", Double.parseDouble(getlong));
		       startActivity(intent);
			}
		});
	}

	public boolean onKeyDown(int keycode, KeyEvent event) {
		if (keycode == KeyEvent.KEYCODE_BACK) {
			moveTaskToBack(true);
		}
		return super.onKeyDown(keycode, event);
	}

}