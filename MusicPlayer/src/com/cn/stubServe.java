package com.cn;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.RemoteException;

import android.widget.Toast;

public class stubServe extends playControl.Stub {
	IbinderService cont;
	MediaPlayer mp;
	String str1 = null;

	public stubServe(IbinderService context,String str) {
		cont = context;
	
		str1 =str;
		if (mp==null) {
			mp=new MediaPlayer();
			
		}if(mp.isPlaying()){
			mp.reset();
		}
		
		try {
			mp.setDataSource(str1);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Toast.makeText(cont, str1, Toast.LENGTH_LONG).show();
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void pause() throws RemoteException {
		// TODO Auto-generated method stub
		// Toast.makeText(cont, "onpause", Toast.LENGTH_LONG).show();

		mp.pause();
	}

	@Override
	public void play() throws RemoteException {
		// TODO Auto-generated method stub
		// Toast.makeText(cont, "onplay", Toast.LENGTH_LONG).show();

		mp.start();
	}

	@Override
	public void stop() throws RemoteException {
		// TODO Auto-generated method stub
		// Toast.makeText(cont, "onstop", Toast.LENGTH_LONG).show();

		mp.stop();
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mp.seekTo(0);
		
	}

	@Override
	public int getCurrentTime() throws RemoteException {
		// TODO Auto-generated method stub
		int ct = mp.getCurrentPosition() / 100;
		return ct;
	}

	@Override
	public int getTime() throws RemoteException {
		// TODO Auto-generated method stub
		int t = mp.getDuration() / 100;
		return t;
	}

}

/*
class MPlayer {
	private static MPlayer mplayer = new MPlayer();
	MediaPlayer mp1 = null;

	public static MPlayer instance() {
		return mplayer;
	}

	public MediaPlayer media() {
		return mp1;
	}

	private MPlayer() {
		mp1 = new MediaPlayer();
	};

}

*/