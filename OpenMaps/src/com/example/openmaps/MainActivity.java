package com.example.openmaps;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void click(View v)
	{
		Intent i=new Intent();
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse("http://google.com/maps"));
		startActivity(i);
		
	}
}
