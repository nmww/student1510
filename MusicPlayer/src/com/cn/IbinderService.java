package com.cn;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.MediaStore.Audio.Media;
import android.widget.ProgressBar;
import android.widget.Toast;

public class IbinderService extends Service {
	//MediaPlayer mp = MPlayer.instance().media();
	IBinder ib;
	String str = null;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

		super.onCreate();
		// Toast.makeText(this,"onCreate" ,Toast.LENGTH_LONG).show();

	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub

		// Toast.makeText(this, "onBind", Toast.LENGTH_LONG).show();
		Bundle bu = intent.getExtras();
		str = bu.getString("path");

		ib = new stubServe(this, str);
		Toast.makeText(this, "str:" + str, Toast.LENGTH_LONG).show();
		return ib;
	}

	public String getStr() {
		return str;
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
