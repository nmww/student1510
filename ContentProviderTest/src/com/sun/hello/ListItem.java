package com.sun.hello;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ListItem extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		
		Cursor c = getContentResolver().query(Uri.parse(FinalValue.contentA+FinalValue.contentB), null, null, null, null);
		startManagingCursor(c);
	
		c.moveToFirst();
		while(c.moveToNext())
		{
			Toast.makeText(this, c.getString(1), Toast.LENGTH_LONG).show();
		}
		
		
		
		ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.row, c, 
					new String[]{FinalValue.table_Title,
								 FinalValue.table_Body}, 
					new int[]{R.id.text1,R.id.text2});

  		
		setListAdapter(adapter);


/*
ListAdapter adapter = new SimpleCursorAdapter(this, 
        // Use a template that displays a text view
        android.R.layout.simple_list_item_1, 
        // Give the cursor to the list adatper
        c, 
        // Map the NAME column in the people database to...
        new String[] {FinalValue.table_Tele} ,
        // The "text1" view defined in the XML template
        new int[] {android.R.id.text1}); 
		
  setListAdapter(adapter);
*/
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		
	}
	
}
