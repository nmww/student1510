package com.cn;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class mainText extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final File files = new File("/sdcard/ebook/");
		final File Lfile[] = files.listFiles();

		final ListView lv2 = (ListView) findViewById(R.id.ListView01);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		for (int i = 0; i < Lfile.length; i++) {

			adapter.add(Lfile[i].getName());
			
		}
		
		lv2.setAdapter(adapter);
		lv2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				Intent in2 = new Intent();
				Bundle bu2 = new Bundle();
				bu2.putString("ebook", files.getPath() + File.separator
						+ lv2.getItemAtPosition(arg2));
				in2.putExtras(bu2);
				in2.setClass(mainText.this, TxtTest.class);
				startActivity(in2);
			}

		});

        
    }
	
}