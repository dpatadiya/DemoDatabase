package com.example.demodatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

        public static final String DATABASE= "college";
        public static final String TABLE= "student";
        public static final String COL_1= "id";
        public static final String COL_2= "name";
        public static final String COL_3= "surname";
        public static final String COL_4= "mark";

     public DatabaseHelper(@Nullable Context context)
     {
         super(context,DATABASE,null,1);
     }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String sql="create table if not exists "+TABLE+"(" +
            COL_1 + " integer primary key autoincrement, "+
            COL_2 + " text, "+
            COL_3 + " text, "+
            COL_4 + " integer)";

        Log.i("sql",sql);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table "+TABLE);
        onCreate(sqLiteDatabase);
    }
    public boolean insertdata(String name,String surname,String mark){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_2, name);
        values.put(COL_3, surname);
        values.put(COL_4, mark);

        //insert into table_name (name,surname,mark) values ('abc','rjk',12)
        long result= db.insert(TABLE,null,values);
        return (result==-1) ? false : true;
     }
}
