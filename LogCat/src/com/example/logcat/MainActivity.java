package com.example.logcat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		
		Button b = (Button) findViewById(R.id.Bse);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				EditText txtv = (EditText) findViewById(R.id.message);
				Log.i("message", txtv.getText().toString());
			}});
	}
	}

