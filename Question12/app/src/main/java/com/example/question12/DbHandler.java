package com.example.question12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    private static final int dbVersion =1;
    private static final String table = "student";
    private static final String key_id = "id";
    private static final String key_name = "name";
    private static final String key_course = "course";



    public DbHandler(@Nullable Context context, @Nullable String name,
                     @Nullable SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String query = "create table student (id primary key ,name text,course text)";
        String query = "create table student (name text,course text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop = String.valueOf("drop table if exists");
        db.execSQL(drop,new String[]{"student"});
        onCreate(db);
    }
    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values=  new ContentValues();

        values.put("name",student.getName());
        values.put("course",student.getCourse());

        long k = db.insert("student",null,values);

        Log.d("addTag", Long.toString(k));
        db.close();
    }
//    public void getStudent(int id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(table, new String[] {key_id,
//                        key_name,key_name }, key_id+ "=?",
//                        new String[] { String.valueOf(id) },
//                        null, null, null,
//                        null);
//        if (cursor != null)
//            cursor.moveToFirst();
//    }
    public List<Student> getAllStudent(){
        List<Student> res = new LinkedList<>();
        String selectQuery = "SELECT  * FROM " + table;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
//                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(0));
                student.setCourse(cursor.getString(1));
                // Adding contact to list
                Log.d("Student obj : ",student.toString());

                res.add(student);
            } while (cursor.moveToNext());
        }
        return res;
    }

//    public void addStudent(Editable text, Editable text1) {
//    }
}
