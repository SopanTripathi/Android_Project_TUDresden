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

public class Onb1press extends Activity {
	Button B1;
	private GoogleMap googleMap;
	static final LatLng Kartographie = new LatLng(51.029106, 13.723766);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onb1press);
	
	final Context context = this;
	// Setting Action listeners on button
	B1= (Button)findViewById(R.id.b1);
	B1.setOnClickListener(new OnClickListener() {
		
		// Setting up the new view by passing intent through button action
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(context, AllButtonActivity.class);
			startActivity(intent);
		}
	});
	//Getting Googlemap using Map Fragments Method and implementing same in try-catch block to prevent app failure
	try { 
        if (googleMap == null) {
           googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        }
      googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
      googleMap.setMyLocationEnabled(true);
      googleMap.getUiSettings().setZoomGesturesEnabled(true);
      googleMap.getUiSettings().setCompassEnabled(true);
      
      //Toast to Show User App Process related information with .show()method
      Toast.makeText(getApplicationContext(), "Map is loaded using Fragment Manager", Toast.LENGTH_SHORT).show();
    
      //Creating the instance of marker
	Marker IFK = googleMap.addMarker(new MarkerOptions().position(Kartographie).title("Institut" +
			" für Kartographie").snippet("TU Dresden"));
      IFK.showInfoWindow();
      googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((Kartographie), 12 ));
	}
	catch(Exception e) {e.printStackTrace();}
	} 
}     
