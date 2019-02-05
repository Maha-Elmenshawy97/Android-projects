package com.example.popup;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pop extends Activity {
	
	public  EditText name;
	public EditText password;
	public Button log;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pop);
		name=(EditText) findViewById(R.id.ename);
	    password=(EditText) findViewById(R.id.epass);
		 log = (Button) findViewById(R.id.bt);
		 log.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!name.getText().toString().isEmpty() &&!password.getText().toString().isEmpty())
				 {
					 Toast.makeText(pop.this, "Login successfull", Toast.LENGTH_SHORT).show();
					 startActivity(new Intent(pop.this,SecondActivity.class));
				 }
				 else
				 {
					 Toast.makeText(pop.this, "Login failed", Toast.LENGTH_SHORT).show();
					 //dismiss();
				 }
			}
		});
	}

}
