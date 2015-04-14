package com.vicky.app2;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Onb4pressmap extends Activity {
	Button B1;
	private GoogleMap googleMap;
	double lat;
	double lng;
	LatLng Department;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onb4pressmap);


		
	    Intent intent = getIntent();
		lat= intent.getDoubleExtra("com.vicky.app2.x", 0.0);
		lng= intent.getDoubleExtra("com.vicky.app2.y",0.0);
		Toast.makeText(getApplicationContext(), "Latitude of Dept. is "+lng ,Toast.LENGTH_LONG).show();
//		lng = intent.getExtras().getDouble("y");
		//Assigning value of Dept. from here
		Department = new LatLng(lat, lng);

		
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
		
	    
	    //Putting marker with above values
		//LatLng Department = new LatLng(lat, lng);
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.setMyLocationEnabled(true);
		googleMap.getUiSettings().setZoomGesturesEnabled(true);
		// //Creating the instance of marker
//		Toast.makeText(getApplicationContext(), "Latitude of Dept. is "+lat ,Toast.LENGTH_LONG).show(); 
		Marker IFK = googleMap.addMarker(new MarkerOptions().position(Department));
		// // IFK.showInfoWindow();
		// googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((Kartographie),
		// 12 ));

	}
}
