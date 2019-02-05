package com.example.data;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SecondActivity extends Activity {
	EditText nameTxt;
	EditText phoneTxt;
    private SQLiteDatabase db;
    MyHelper helper;
     People p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		 MyHelper helper = new MyHelper(this);
         db = helper.getWritableDatabase();
        nameTxt = (EditText) findViewById(R.id.editText1);
        phoneTxt = (EditText) findViewById(R.id.editText2);
        
        Intent i = getIntent();
         p=i.getParcelableExtra("p");
            nameTxt.setText(p.getName());
            phoneTxt.setText(p.getPhone());
        
	}
	public void delete(View v){
        int row = db.delete(MyHelper.TABLE_NAME, MyHelper.COL_ID + "=?", new String[]{String.valueOf(p.getId())});
        if(row>0){
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    public void update(View v){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyHelper.COL_NAME , nameTxt.getText().toString());
        contentValues.put(MyHelper.COL_PHONE, phoneTxt.getText().toString());
        int row = db.update(MyHelper.TABLE_NAME,contentValues,"_id="+MyHelper.COL_ID,null);
        if(row>0){
            Toast.makeText(this,"Updated", Toast.LENGTH_SHORT).show();
            finish();
        }  
    }      
}
