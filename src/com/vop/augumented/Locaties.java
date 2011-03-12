package com.vop.augumented;

/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//package com.example.android.apis.graphics;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

public class Locaties extends Activity {
	private Preview mPreview;
	float pitch = 0;
	float roll = 0;
	float heading = 0;
	AugView compassView;
	SensorManager sensorManager;

	@Override
	public boolean onTouchEvent(final MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			// Code on finger down
			float posX = ev.getX();
			float posY = ev.getY();

			// 80x80 pixel square located 20 pixels left, 20 pixels top.
			// float x1 = 20, x2 = 100, y1 = 20, y2 = 100;
			/*
			 * canvas.drawRect(0, 0, getMeasuredWidth(), 2 * getMeasuredHeight()
			 * / 10, kader_kleur);
			 */

			if ((posX >= 0 && posX <= compassView.getMeasuredWidth())
					&& (posY >= 0 && posY <= 2 * compassView
							.getMeasuredHeight() / 10)) {
				// we are in the square
				String tekst = compassView.getDichtste_punt();
				if (tekst != "") {
					Toast toast = Toast.makeText(getApplicationContext(), ""
							+ tekst, Toast.LENGTH_SHORT);
					toast.show();
				}

			} else {

				// we are somewhere else on the canvas
			}
		}
		case MotionEvent.ACTION_UP: {
			// Code on finger up

		}
		case MotionEvent.ACTION_MOVE: {
			// Code on finger move

		}
		}
		return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Hide the window title.
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Create our Preview view and set it as the content of our activity.

		mPreview = new Preview(this);
		compassView = new AugView(getApplicationContext());

		MenuItem item = (MenuItem) findViewById(R.id.m_500);
		compassView.setAfstand(100000);

		// werkt niet
		// if (item.isChecked()) item.setChecked(true);
		// else item.setChecked(false);

		setContentView(mPreview);
		addContentView(compassView, new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		updateOrientation(0, 0, 0);

		LocationManager locationManager;
		String context = Context.LOCATION_SERVICE;
		locationManager = (LocationManager) getSystemService(context);
		String provider = LocationManager.GPS_PROVIDER;
		Location location = locationManager.getLastKnownLocation(provider);
		updateWithNewLocation(location);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				35000, 1, this.locationListener);
	}

	private final LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			updateWithNewLocation(location);
		}

		public void onProviderDisabled(String provider) {

		}

		public void onProviderEnabled(String provider) {
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	};

	private void updateWithNewLocation(Location location) {
		if (location != null) {
			compassView.setLng(location.getLongitude());
			compassView.setLat(location.getLatitude());
			compassView.invalidate();
		}
	}

	private void updateOrientation(float _roll, float _pitch, float _heading) {
		heading = _heading;
		pitch = _pitch;
		roll = _roll;
		if (compassView != null) {
			compassView.setHeading(heading);
			compassView.setPitch(pitch);
			compassView.setRoll(roll);
			compassView.invalidate();
		}
	}

	private final SensorListener sensorListener = new SensorListener() {
		public void onSensorChanged(int sensor, float[] values) {

			float headingAngle = values[0];
			float pitchAngle = values[1];
			float rollAngle = values[2];

			updateOrientation(headingAngle, pitchAngle, rollAngle);
			// TODO Apply the orientation changes to your application.
		}

		public void onAccuracyChanged(int sensor, int accuracy) {
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
		sensorManager.registerListener(sensorListener,
				sensorManager.SENSOR_ORIENTATION,
				sensorManager.SENSOR_DELAY_FASTEST);
	}

	@Override
	protected void onStop() {
		sensorManager.unregisterListener(sensorListener);
		super.onStop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.hoofdmenu_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {

		case R.id.info:
			return true;
		case R.id.km_1:
			if (item.isChecked())
				item.setChecked(true);
			else
				item.setChecked(false);
			compassView.setAfstand(1000);
			return true;
		case R.id.km_5:
			if (item.isChecked())
				item.setChecked(true);
			else
				item.setChecked(false);
			compassView.setAfstand(5000);
			return true;
		case R.id.km_10:
			if (item.isChecked())
				item.setChecked(true);
			else
				item.setChecked(false);
			compassView.setAfstand(10000);
			return true;
		case R.id.km_20:
			if (item.isChecked())
				item.setChecked(true);
			else
				item.setChecked(false);
			compassView.setAfstand(20000);
			return true;
		case R.id.m_500:
			if (item.isChecked())
				item.setChecked(true);
			else
				item.setChecked(false);
			compassView.setAfstand(500);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}