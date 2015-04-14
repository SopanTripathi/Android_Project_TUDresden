//package com.vicky.app2;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.DatabaseUtils;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class Onb3pressDBHelper extends SQLiteOpenHelper {
//	//Declaring Variables of SQLITE Database
//	public static final String DATABASE_NAME = "MyDBName.db";
//	public static final String IFK_TABLE_NAME = "facultyinfo";
//	public static final String IFK_COLUMN_ID = "id";
//	public static final String IFK_COLUMN_FACULTY = "faculty";
//	public static final String IFK_COLUMN_FACULTY_N= "facultyname";
//	public static final String IFK_COLUMN_ADDRESS = "street";
//	public static final String IFK_COLUMN_PHONE = "phone";
//	public static final String IFK_COLUMN_LATITUDE = "latitude";
//	public static final String IFK_COLUMN_LONGITUDE = "longitude";
//
//	private HashMap hp;
//
//	public Onb3pressDBHelper(Context context) {super(context, DATABASE_NAME, null, 1);}
//
//	@Override
//	public void onCreate(SQLiteDatabase db) {
//		// TODO Auto-generated method stub
//		db.execSQL("create table facultyinfo "+ "(id integer, faculty text,facultyname text primary key,street text,phone integer,latitude real,longitude real)");
//	}
//
//	@Override
//	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		// TODO Auto-generated method stub
//		db.execSQL("DROP TABLE IF EXISTS facultyinfo");
//		onCreate(db);
//	}
//
//	public boolean insertContact(String faculty, String facultyname, String street,String phone, String latitude, String longitude) {
//		SQLiteDatabase db = this.getWritableDatabase();
//		ContentValues contentValues = new ContentValues();
//
//		contentValues.put("faculty", faculty);
//		contentValues.put("facultyname", facultyname);
//		contentValues.put("street", street);
//		contentValues.put("phone", phone);
//		contentValues.put("latitude", latitude);
//		contentValues.put("longitude", longitude);
//
//		db.insert("facultyinfo", null, contentValues);
//		return true;
//	}
//	//Querying with SQLITe Database
//	public Cursor getData(int id) {
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor res = db.rawQuery("select * from facultyinfo where id=" + id + "",null);
//		return res;
//	}
//
//	public int numberOfRows() {
//		SQLiteDatabase db = this.getReadableDatabase();
//		int numRows = (int) DatabaseUtils.queryNumEntries(db,IFK_TABLE_NAME);
//		return numRows;
//	}
//
//	public boolean updateContact(Integer id,String faculty, String facultyname, String street,String phone, String latitude, String longitude) {
//		SQLiteDatabase db = this.getWritableDatabase();
//		ContentValues contentValues = new ContentValues();
//		contentValues.put("faculty", faculty);
//		contentValues.put("facultyname", facultyname);
//		contentValues.put("street", street);
//		contentValues.put("phone", phone);
//		contentValues.put("latitude", latitude);
//		contentValues.put("longitude", longitude);
//		
//		db.update("facultyinfo", contentValues, "id = ? ",new String[] { Integer.toString(id) });
//		return true;
//	}
//
//	public Integer deleteContact(Integer id) {
//		SQLiteDatabase db = this.getWritableDatabase();
//		return db.delete("facultyinfo", "id = ? ",new String[] { Integer.toString(id) });
//	}
//
//	public ArrayList getAllFacultyInfo() {
//		ArrayList array_list = new ArrayList();
//		// hp = new HashMap();
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor res = db.rawQuery("select * from facultyinfo", null);
//		res.moveToFirst();
//		while (res.isAfterLast() == false) {
//			array_list.add(res.getString(res.getColumnIndex(IFK_COLUMN_FACULTY_N)));
//			res.moveToNext();
//		}
//		return array_list;
//	}
//}