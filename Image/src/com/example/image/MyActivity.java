package com.example.image;

import modle.photo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_2);
		
		Intent i=getIntent();
		photo pi=i.getParcelableExtra("photo");
		int imgres=pi.getImage();
		String line=pi.getName();
		
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		img.setImageResource(imgres);
		
		TextView txt=(TextView)findViewById(R.id.textView);
		txt.setText(line);	
		}
	}

