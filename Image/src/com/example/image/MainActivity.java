package com.example.image;

import java.util.ArrayList;

import modle.photo;
import Adapter.photoAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ArrayList<photo> photoList ;
	 private ArrayList<photo> getDataSource()
	  {
		  photoList = new ArrayList<>();
		  photoList.add(new photo("Piano",R.drawable.ic_piano));
		  photoList.add(new photo("Violin",R.drawable.ic_violin));
		  photoList.add(new photo("Horse",R.drawable.ic_horse));
		  photoList.add(new photo("Book",R.drawable.ic_book));
		  photoList.add(new photo("Flower",R.drawable.ic_flower));
		  photoList.add(new photo("Cat",R.drawable.ic_cat));
		  photoList.add(new photo("Coffe",R.drawable.ic_coffe));
		  photoList.add(new photo("Galaxy",R.drawable.ic_galaxy));
		  photoList.add(new photo("Rose",R.drawable.ic_rose));
		  photoList.add(new photo("Macaroon",R.drawable.ic_macaroon));
		  photoList.add(new photo("Spring",R.drawable.ic_spring));
		  photoList.add(new photo("Strawberry",R.drawable.ic_strawberry));
		  photoList.add(new photo("Winter",R.drawable.ic_winter));
		  return photoList;
	 }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		GridView listView =(GridView) findViewById(R.id.listview);
		photoAdapter adapter= new photoAdapter(getDataSource(),this);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				 photo ph = (photo) parent.getItemAtPosition(position);
	                Toast.makeText(MainActivity.this, ph.getName(), Toast.LENGTH_SHORT).show(); 
	                
	                Intent i=new Intent(MainActivity.this,MyActivity.class);
	                i.putExtra("photo",photoList.get(position));
	                startActivity(i);
				
			} });
	}
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		 MenuInflater mi=getMenuInflater();
		 mi.inflate(R.menu.main, menu);
		 return true;
	}
		@Override
	    public boolean onOptionsItemSelected(MenuItem item) {
			super.onOptionsItemSelected(item);
	        switch (item.getItemId()){
	            case R.id.save:
	                Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
	                break;
	            case R.id.edit:
	                Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
	                break;
	        }
	        return true;
	    }
}
