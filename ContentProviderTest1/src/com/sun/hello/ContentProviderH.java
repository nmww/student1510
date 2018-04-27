package com.sun.hello;



import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.net.Uri;

public class ContentProviderH extends ContentProvider{

	mySqldatabase mySql=null;
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase sql= mySql.getWritableDatabase();
		sql.delete(FinalValue.tablename, selection, null);
		
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		SQLiteDatabase sql= mySql.getWritableDatabase();
		sql.insert(FinalValue.tablename, null, values);
		
		return uri;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		mySql=new mySqldatabase(getContext(), 4);
		
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteDatabase sql= mySql.getReadableDatabase();
		
		
		Cursor c =sql.query(FinalValue.tablename, FinalValue.projection, null, null, null, null, null);
		
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase sql= mySql.getWritableDatabase();
		sql.update(FinalValue.tablename, values, selection, null);
		return 0;
	}
	
	class mySqldatabase extends SQLiteOpenHelper
	{

		public mySqldatabase(Context context,int version) {
			super(context, FinalValue.databasesname, null, version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String sql ="CREATE TABLE " + FinalValue.tablename + " ("
			+ FinalValue.table_Id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ FinalValue.table_Title + " varchar(255)," + FinalValue.table_Tele
			+ " TEXT," + FinalValue.table_Body + " TEXT" + ");";
			
			db.execSQL(sql);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			if(newVersion>oldVersion)
			{
				db.execSQL("drop table if exists "+FinalValue.tablename);
				onCreate(db);
			}
			
		}
		
	}
	

}
