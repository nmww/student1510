package com.sun.hello;



public class FinalValue {

	
	static String contentA="content://";
	static String contentB="com.ContentProviderH"; 
	static String databasesname="test.db"; 
	static String tablename="hello";
	
	static String table_Id="_id";
	static String table_Title="Title";
	static String table_Tele="TeleNumber";
	static String table_Body="Body";
	static int 	   flagNumber=4;
	 static final String[] projection = new String[]{table_Id, 
		 table_Title,
		 table_Tele,
		 table_Body};
	
}
