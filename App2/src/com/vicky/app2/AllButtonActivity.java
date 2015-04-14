package com.vicky.app2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AllButtonActivity extends Activity {
	Button B1, B2, B3, B4, B5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allbuttonactivity);
		// Declaring Button
		B1 = (Button) findViewById(R.id.b1);
		B2 = (Button) findViewById(R.id.b2);
		B3 = (Button) findViewById(R.id.b3);
		B4 = (Button) findViewById(R.id.b4);

		final Context context = this;
		// Setting Action listeners
		B1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, Onb1press.class);
				startActivity(intent);
			}
		});
		B2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, Onb2press.class);
				startActivity(intent);
			}
		});
		B3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, Onb3press.class);
				startActivity(intent);
			}
		});
		B4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, Onb4press.class);
				startActivity(intent);
			}
		});

	}

}
