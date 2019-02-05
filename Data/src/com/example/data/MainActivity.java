package com.example.data;

import java.util.ArrayList;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	EditText add_name , add_phone;
    private SQLiteDatabase db;
    private PeopleAdapter adapter;
    ArrayList<People> arrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		db = new MyHelper(this).getWritableDatabase();
		
		add_name=(EditText) findViewById(R.id.editText);
		add_phone=(EditText) findViewById(R.id.editText1);
		Button add=(Button) findViewById(R.id.button);
		
		ListView users= (ListView) findViewById(R.id.user_list);
		adapter= new PeopleAdapter(this);
        users.setAdapter(adapter);
		viewdata();
		users.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				@SuppressWarnings("unused")
				People p = (People) parent.getItemAtPosition(position);
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("p",arrayList.get(position));
                startActivity(i);
            } });

		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				 String name= add_name.getText().toString();
			     String phone=add_phone.getText().toString();
			        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone)){
			            ContentValues values = new ContentValues();
			            values.put(MyHelper.COL_NAME,name);
			            values.put(MyHelper.COL_PHONE,phone);
			            long row = db.insert(MyHelper.TABLE_NAME, null, values);
			            if(row > 0){
			                viewdata();
			                Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
			            }
			        }
			}
		});
			
	}
	 private void viewdata() 
	 {
			arrayList = new ArrayList<>();
	        String cols[]={MyHelper.COL_ID,MyHelper.COL_NAME , MyHelper.COL_PHONE};
	        Cursor cursor = db.query(MyHelper.TABLE_NAME, cols, null, null, null, null, MyHelper.COL_NAME);
	        if(cursor!=null){
	        if(cursor.moveToFirst()){
	            do{
	                int id = cursor.getInt(cursor.getColumnIndex(MyHelper.COL_ID));
	                String name = cursor.getString(cursor.getColumnIndex(MyHelper.COL_NAME));
	                String phone = cursor.getString(cursor.getColumnIndex(MyHelper.COL_PHONE));

	                People pe = new People(id,name,phone);
	                arrayList.add(pe);

	            }while (cursor.moveToNext());
	            adapter.setDataSource(arrayList);
	            adapter.notifyDataSetChanged();
	        }
	        }
			
		}
}
