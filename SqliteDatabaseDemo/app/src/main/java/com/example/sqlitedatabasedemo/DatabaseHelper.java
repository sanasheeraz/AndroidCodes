package com.example.sqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name="Institute.db";
    public static final String Table_Name="Student";
    public static final String Column1="St_Id";
    public static final String Column2="St_Name";
    public static final String Column3="St_Course";
    public static final String Column4="St_Fees";
    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_Name, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ Table_Name+"("+Column1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Column2+" Text,"+Column3+" Text,"+Column4+" INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }

    public boolean insertData(String name,String course,int fees,byte[] imageBytes)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Column2,name);
        contentValues.put(Column3,course);
        contentValues.put(Column4,fees);
        long result=db.insert(Table_Name,null,contentValues); //-ve value on error
        if(result==-1)
        {
            return false;
        }else
        {
            return true;
        }
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from "+Table_Name,null);
        return result;
    }
    public boolean updateData(int id,String name, String course , int fees,byte[] imageBytes){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Column1,id);
        contentValues.put(Column2,name);
        contentValues.put(Column3,course);
        contentValues.put(Column4,fees);
        long result=db.update(Table_Name,contentValues,"St_Id=?",new String[]{ String.valueOf(id) });
        if(result==-1)
        {
            return false;
        }else
        {
            return true;
        }
    }
    public boolean delete(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long result=db.delete(Table_Name,"St_Id=?",new String[]{String.valueOf(id)});
        if(result==-1)
        {
            return false;
        }else
        {
            return true;
        }
    }
}
