package com.example.modernartui;

import android.view.*;
import android.app.*;
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private DialogFragment mDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView mRect1 = (TextView) findViewById(R.id.Rect1);
		final TextView mRect2 = (TextView) findViewById(R.id.Rect2);
		final TextView mRect3 = (TextView) findViewById(R.id.Rect3);
		final TextView mRect4 = (TextView) findViewById(R.id.Rect4);
		final TextView mRect5 = (TextView) findViewById(R.id.Rect5);
		final TextView mRect6 = (TextView) findViewById(R.id.Rect6);
		final TextView mRect7 = (TextView) findViewById(R.id.Rect7);
		final TextView mRect8 = (TextView) findViewById(R.id.Rect8);
		final TextView mRect9 = (TextView) findViewById(R.id.Rect9);
		final TextView mRect10 = (TextView) findViewById(R.id.Rect10);
		final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
		
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			
			int progress= 0;
			int r1=51,g1=181,b1=229;
			int r2=170,g2=102,b2=204;
			int r3=153,g3=204,b3=0;
			int r4=255,g4=187,b4=51;
			int r5=255,g5=68,b5=68;
			@Override
			 public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
							 
				mRect1.setBackgroundColor(Color.rgb(r1+progresValue,g1+(progresValue%50),b1+(progresValue%25)));
				mRect2.setBackgroundColor(Color.rgb(r2+(progresValue%75), g2+progresValue, b2+(progresValue%50)));
				mRect3.setBackgroundColor(Color.rgb(r3+progresValue, g3+(progresValue%50), b3+progresValue));
				mRect4.setBackgroundColor(Color.rgb(r4, g4+(progresValue%50), b4+progresValue));
				mRect5.setBackgroundColor(Color.rgb(r5, g5+progresValue, b5+progresValue));
				mRect6.setBackgroundColor(Color.rgb(r1+progresValue,g1+(progresValue%50),b1+(progresValue%25)));
				mRect7.setBackgroundColor(Color.rgb(r2+(progresValue%75), g2+progresValue, b2+(progresValue%50)));
				mRect8.setBackgroundColor(Color.rgb(r3+progresValue, g3+(progresValue%50), b3+progresValue));
				mRect9.setBackgroundColor(Color.rgb(r4, g4+(progresValue%50), b4+progresValue));
				mRect10.setBackgroundColor(Color.rgb(r5, g5+progresValue, b5+progresValue));             
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar){
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar){
				;
			}
		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		
		case R.id.action_settings:
			// Create a new AlertDialogFragment
						mDialog = AlertDialogFragment.newInstance();

						// Show AlertDialogFragment
						mDialog.show(getFragmentManager(), "Alert");
				
			// return value true indicates that the menu click has been handled
			return true;
		
		default:
			return super.onOptionsItemSelected(item);
		}
	}


//Class that creates the AlertDialog
	public static class AlertDialogFragment extends DialogFragment {

		public static AlertDialogFragment newInstance() {
			return new AlertDialogFragment();
		}
		static private final String URL = "http://www.moma.org/";
		static private final String CHOOSER_TEXT = "Load " + "MOMA" + " with:";
		
		// Build AlertDialog using AlertDialog.Builder
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			return new AlertDialog.Builder(getActivity())
			        
					.setMessage("Visit Moma!")
					
					.setNegativeButton("Not Now",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									
								}
							})
							
					
					.setPositiveButton("Go",
							new DialogInterface.OnClickListener() {
								public void onClick(
										final DialogInterface dialog, int id) {
									startImplicitActivation();
								}
							}).create();
		}
		public void startImplicitActivation(){
			Intent baseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
			Intent chooserIntent = Intent.createChooser(baseIntent, CHOOSER_TEXT);
			startActivity(chooserIntent);
		}
	}
}
