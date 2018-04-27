package com.cn;

import java.io.File;

import android.R.color;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.NoCopySpan.Concrete;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Ibinder extends Activity {

	playControl py = null;
	ProgressBar pb = null;
	int gct = 0;
	int gt = 0;
	Thread th;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temp);

		final Intent in = getIntent();
		// Bundle bu=in.getExtras();
		// String str=bu.getString("path");
		//	
		// bu.putString("path", str);
		// in.putExtras(bu);
		in.setClass(this, IbinderService.class);
		ServiceConnection sc = new ServiceConnection() {

			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				// Toast.makeText(Ibinder.this, "onServiceConnected",
				// Toast.LENGTH_LONG).show();

				py = playControl.Stub.asInterface(service);
			}
		};
		bindService(in, sc, BIND_AUTO_CREATE);

		pb = (ProgressBar) findViewById(R.id.ProgressBar01);
		Button bu1 = (Button) findViewById(R.id.Button01);
		Button bu2 = (Button) findViewById(R.id.Button02);
		Button bu3 = (Button) findViewById(R.id.Button03);

		bu1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					py.play();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				th = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						while (true) {
							try {

								pb.setProgress(gct);
								pb.setMax(gt);
								gct = py.getCurrentTime();
								gt = py.getTime();

							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (gct <= gt) {
								pb.incrementProgressBy(500);
							}
						}
					}
				});

				th.start();

			}

		});
		bu2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					py.pause();
					th.stop();
					// pb.setProgress(gct);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		bu3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {

					py.stop();
					th.stop();
				//	stopService(in);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Intent intent=new Intent(this,IbinderService.class);
		stopService(intent);
	}

}