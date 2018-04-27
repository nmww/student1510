package com.sun.hello;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Test extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
     //   getContentResolver().insert(Uri.parse(FinalValue.contentA+FinalValue.contentB), values);
     //   getContentResolver().delete(url, where, selectionArgs);
        
        Button bn1 = (Button)findViewById(R.id.Button01);
        Button bn2 = (Button)findViewById(R.id.Button02);
        Button bn3 = (Button)findViewById(R.id.Button03);
        Button bn4 = (Button)findViewById(R.id.Button04);
        
        bn1.setOnClickListener(this);
        bn2.setOnClickListener(this);
        bn3.setOnClickListener(this);
        bn4.setOnClickListener(this);
      
        bn1.setText("插入数据");
        bn2.setText("删除数据");
        bn3.setText("更新数据");
        bn4.setText("查询数据");
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
			case R.id.Button01:
				
				ContentValues values1 = new ContentValues();
				
				values1.put(FinalValue.table_Title,"SUN" );
				values1.put(FinalValue.table_Tele,"13718922677" );
				values1.put(FinalValue.table_Body,"this is ambow t" );
				
					
				getContentResolver().insert(Uri.parse(FinalValue.contentA+FinalValue.contentB), values1);
				break;
				
			case R.id.Button02:
				
				getContentResolver().delete(Uri.parse(FinalValue.contentA+FinalValue.contentB), "Id=3", null);
				break;
				
			case R.id.Button03:
				ContentValues values2 = new ContentValues();
				
				values2.put(FinalValue.table_Title,"hello" );
				getContentResolver().update(Uri.parse(FinalValue.contentA+FinalValue.contentB), values2, "Id=5", null);
				break;
				
			case R.id.Button04:
				Intent it = new Intent();
				it.setClass(this, ListItem.class);
				startActivity(it);
				
				break;
		}
		
	}
}