package com.example.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

	 ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.list);
	}
	 public void view(View view) throws IOException 
	 {
	        if(isCardAvaible())
	        {
	            InputStream inputStream = getAssets().open("doaa.txt");
	            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
	            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
	            String word="";
	            ArrayList<String> data=new ArrayList<>();
	            while ((word=bufferedReader.readLine())!=null)
	            {
	               data.add(word);
	            }
	            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
	            listView.setAdapter(adapter);
	        }
	    }
	    private boolean isCardAvaible()
	    {
	        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
	        {
	            return true;
	        }
	        return false;
	    }
	}

