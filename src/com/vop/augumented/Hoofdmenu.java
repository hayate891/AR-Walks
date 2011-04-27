package com.vop.augumented;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.vop.popup.ActionItem;
import com.vop.popup.QuickAction;
import com.vop.tools.FullscreenActivity;
import com.vop.tools.VopApplication;

public class Hoofdmenu extends FullscreenActivity {
	Vibrator vibrator;
	VopApplication app;
	final ActionItem actie1 = new ActionItem();
	final ActionItem actie2 = new ActionItem();
	final ActionItem actie3 = new ActionItem();
	final ActionItem actie4 = new ActionItem();
	final ActionItem actie5 = new ActionItem();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = (VopApplication) getApplicationContext();
		setContentView(R.layout.hoofdmenu_layout);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		//berichten
		ImageButton berichten=(ImageButton) findViewById(R.id.berichten);
		berichten.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vibrator.vibrate(60);
				QuickAction qa = new QuickAction(v);
				
				actie1.setTitle("lijst berichten");
				//actie1.setIcon(getResources().getDrawable(R.drawable.chart));
				actie1.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Toast.makeText(Hoofdmenu.this, "lijst berichten" , Toast.LENGTH_SHORT).show();
					}
				});
				actie2.setTitle("AR berichten");
				actie2.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Toast.makeText(Hoofdmenu.this, "AR berichten" , Toast.LENGTH_SHORT).show();
					}
				});
				actie3.setTitle("map berichten");
				actie3.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Toast.makeText(Hoofdmenu.this, "map berichten" , Toast.LENGTH_SHORT).show();
					}
				});
				actie4.setTitle("bericht maken");
				actie4.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Toast.makeText(Hoofdmenu.this, "bericht maken" , Toast.LENGTH_SHORT).show();
					}
				});
				qa.addActionItem(actie1);
				qa.addActionItem(actie2);
				qa.addActionItem(actie3);
				qa.addActionItem(actie4);
				qa.setAnimStyle(QuickAction.ANIM_AUTO);
				qa.show();
			}
		});
		//trajecten
		ImageButton trajecten=(ImageButton) findViewById(R.id.trajecten);
		trajecten.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vibrator.vibrate(60);
				QuickAction qa = new QuickAction(v);
				
				actie1.setTitle("lijst trajecten");
				//actie1.setIcon(getResources().getDrawable(R.drawable.chart));
				actie1.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, Trajecten.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie2.setTitle("toevoegen traject");
				actie2.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, TrajectOpslaan.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie3.setTitle("huidig traject");
				actie3.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, TrajectOpslaanZien.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				qa.addActionItem(actie1);
				qa.addActionItem(actie2);
				qa.addActionItem(actie3);
				qa.setAnimStyle(QuickAction.ANIM_AUTO);
				qa.show();
			}
		});
		//locaties
		ImageButton locaties=(ImageButton) findViewById(R.id.locaties);
		locaties.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vibrator.vibrate(60);
				QuickAction qa = new QuickAction(v);
				
				actie1.setTitle("AR locaties");
				//actie1.setIcon(getResources().getDrawable(R.drawable.chart));
				actie1.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, AugmentedRealityLocaties.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie2.setTitle("lijst locaties");
				actie2.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, ListLocaties.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie3.setTitle("map locaties");
				actie3.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, LocatieMap.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie4.setTitle("toevoegen locaties");
				actie4.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, LocatieOpslaan.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie5.setTitle("huidige locatie bijhouden");
				actie5.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, HuidigeLocatieOpslaan.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				qa.addActionItem(actie1);
				qa.addActionItem(actie2);
				qa.addActionItem(actie3);
				qa.addActionItem(actie4);
				qa.addActionItem(actie5);
				qa.setAnimStyle(QuickAction.ANIM_AUTO);
				qa.show();
			}
		});
		//vrienden
		ImageButton vrienden=(ImageButton) findViewById(R.id.vrienden);
		vrienden.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vibrator.vibrate(60);
				QuickAction qa = new QuickAction(v);
				
				actie1.setTitle("lijst vrienden");
				//actie1.setIcon(getResources().getDrawable(R.drawable.chart));
				actie1.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, Vrienden.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie2.setTitle("vriend toevoegen");
				actie2.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, ToevoegenVriend.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				qa.addActionItem(actie1);
				qa.addActionItem(actie2);
				qa.setAnimStyle(QuickAction.ANIM_AUTO);
				qa.show();
			}
		});
		//profiel
		ImageButton profiel=(ImageButton) findViewById(R.id.profiel);
		profiel.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vibrator.vibrate(60);
				QuickAction qa = new QuickAction(v);
				
				actie1.setTitle("profiel");
				//actie1.setIcon(getResources().getDrawable(R.drawable.chart));
				actie1.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, Profiel.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie2.setTitle("profiel bewerken");
				actie2.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, ProfielWijzigen.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				actie3.setTitle("wachtwoord wijzigen");
				actie3.setOnClickListener(new android.view.View.OnClickListener() {
					@Override
					public void onClick(View v) {
						vibrator.vibrate(60);
						Intent myIntent = new Intent(Hoofdmenu.this, PaswoordWijzigen.class);
						Hoofdmenu.this.startActivity(myIntent);
					}
				});
				qa.addActionItem(actie1);
				qa.addActionItem(actie2);
				qa.addActionItem(actie3);
				qa.setAnimStyle(QuickAction.ANIM_AUTO);
				qa.show();
			}
		});		
	}

	@Override
	public void onStart() {
		super.onStart();

		if (app.getState().get("userid") == null) {
			finish();
		}
	}
	
	public void uitloggen_klik(View v) {
		vibrator.vibrate(60);
		app.putState("userid", null);

		SharedPreferences.Editor editor = getSharedPreferences(VopApplication.PREFS, MODE_PRIVATE).edit();
		editor.remove("userid");
		editor.commit();

		moveTaskToBack(true);
		finish();
	}

	// menu openen
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
		case R.id.optie_1:
			Toast toast = Toast.makeText(getApplicationContext(),
					"u selecteerde:" + item.getTitle(), Toast.LENGTH_SHORT);
			toast.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
