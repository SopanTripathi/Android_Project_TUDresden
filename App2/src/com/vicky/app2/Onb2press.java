package com.vicky.app2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Onb2press extends Activity implements LocationListener {
	TextView latitudeField;
	TextView longitudeField;
	LocationManager locationManager;
	private GoogleMap googleMap;
	int lat, lng;
	LatLng Userlocation = new LatLng(lat, lng);
	Button B1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onb2press);
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
		locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 5000, 5, this);

	}

	public void onLocationChanged(Location location) {
		if (location != null) {
			latitudeField = (TextView) findViewById(R.id.TextView01);
			longitudeField = (TextView) findViewById(R.id.TextView02);

			double lat = location.getLatitude();
			double lng = location.getLongitude();

			latitudeField.setText("Latitude: " + lat);
			longitudeField.setText("Longitude: " + lng);
			setUpMapIfNeeded(lat, lng);

		}
	}

	private void setUpMapIfNeeded(double lat, double lng) {

		googleMap = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.map)).getMap();
		googleMap.clear();
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.getUiSettings().setZoomGesturesEnabled(true);
		googleMap.getUiSettings().setCompassEnabled(true);
		Toast.makeText(getApplicationContext(),
				"Please wait for GPS Coordinates", Toast.LENGTH_SHORT).show();

		
		
		if (Userlocation != new LatLng(0, 0)) {
			// Setting for the Markers
			Marker IFK = googleMap.addMarker(new MarkerOptions()
					.position(new LatLng(lat, lng)));
			IFK.setTitle("You are here");
			IFK.showInfoWindow();
		}

	}

	public void onProviderDisabled(String provider) {
		Toast.makeText(Onb2press.this,
                "Provider disabled: " + provider, Toast.LENGTH_SHORT)
                .show();
	}

	public void onProviderEnabled(String provider) {
		Toast.makeText(Onb2press.this,
                "Provider enabled: " + provider, Toast.LENGTH_SHORT)
                .show();
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
	}
}