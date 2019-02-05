package com.example.dice;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
	Integer[] imageIDs = {
			R.drawable.d1,
			R.drawable.d2,
			R.drawable.d3,
			R.drawable.d4,
			R.drawable.d5,
			R.drawable.d6,
			};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b = (Button) findViewById(R.id.BR);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				TextView textView =(TextView)findViewById(R.id.tv);
		        ImageView i1=(ImageView)findViewById(R.id.image1);
		        ImageView i2=(ImageView)findViewById(R.id.image2);
		        Random r=new Random();
		        int n=r.nextInt(6);
		        int m=r.nextInt(6);
		        i1.setImageResource(imageIDs[n]);
		        i2.setImageResource(imageIDs[m]);
		        textView.setText(" "+(n+m+2));
			}});
	}
}
