package com.cn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.R.color;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TxtTest extends Activity {
	private static final String code = "GB2312";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Toast.makeText(this, "OnRead",Toast.LENGTH_LONG).show();
		setContentView(R.layout.temp);

		final TextView tv = (TextView) findViewById(R.id.TextView01);
		final Button bn1 = (Button) findViewById(R.id.Button01);
		final Button bn2 = (Button) findViewById(R.id.Button02);
		Button bn3 = (Button) findViewById(R.id.Button03);
		
		bn1.setOnClickListener(new OnClickListener() {
			int temp = 0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (temp == 0) {
					tv.setTextSize(30.0f);
					bn1.setBackgroundResource(R.drawable.button022);
					temp = 1;
				}
				else if (temp == 1) {
					tv.setTextSize(20.0f);
					bn1.setBackgroundResource(R.drawable.button020);
					temp = 2;
				}
				else if (temp == 2) {
					tv.setTextSize(25.0f);
					bn1.setBackgroundResource(R.drawable.button023);
					temp = 0;
				}

			}
		});
		bn2.setOnClickListener(new OnClickListener() {
			int temp = 0;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (temp == 0) {
					tv.setTextColor(Color.BLACK);
					bn2.setBackgroundResource(R.drawable.button042);
					temp = 1;
				}
				else if (temp == 1) {
					tv.setTextColor(Color.BLUE);
					bn2.setBackgroundResource(R.drawable.button047);
					temp = 2;
				}
				else if (temp == 2) {
					tv.setTextColor(Color.RED);
					bn2.setBackgroundResource(R.drawable.button040);
					temp = 0;
				}
				
			}
		});
		bn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TxtTest.this.finish();
			}
		});

		Intent in = getIntent();
		Bundle bn = in.getExtras();
		String str = bn.getString("ebook");
		File file = new File(str);
		StringBuffer readStr = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), code));
			char c[] = new char[5 * 1024];
			while (br.read() != -1) {
				// String str1=br.readLine();
				int len = br.read(c);
				String str1 = new String(c, 0, len);
				str1.trim();
				// readStr.append(str1+"\n");
				tv.append(str1);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
