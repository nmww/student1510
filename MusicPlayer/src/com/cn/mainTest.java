package com.cn;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class mainTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final File file = new File("/sdcard/music");
		final File[] listfile = file.listFiles();

		final ListView lv = (ListView) findViewById(R.id.ListView01);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		for (int i = 0; i < listfile.length; i++) {
			aa.add(listfile[i].getName());
		}
		lv.setAdapter(aa);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent in = new Intent();
				Bundle bu = new Bundle();
				bu.putString("path", listfile[arg2].getAbsolutePath());
				in.putExtras(bu);
				in.setClass(mainTest.this, Ibinder.class);
				startActivity(in);
			}
		});
	}
}
