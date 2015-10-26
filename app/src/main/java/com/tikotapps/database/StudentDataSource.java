package com.tikotapps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neel on 24/06/15.
 */
public class StudentDataSource {

    private DbHelper mDbHelper;
    private String[] allColumns = {DbHelper.COLUMN_NAME, DbHelper.COLUMN_AGE, DbHelper.COLUMN_LANGUAGE};

    public StudentDataSource(Context context) {
        mDbHelper = DbHelper.getInstance(context);
    }

    public void createStudent(Student student) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_NAME, student.name);
        values.put(DbHelper.COLUMN_AGE, student.age);
        values.put(DbHelper.COLUMN_LANGUAGE, student.language);

        mDbHelper.getWritableDatabase().insert(DbHelper.TABLE_NAME, null, values);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        Cursor cursor = mDbHelper.getReadableDatabase().query(DbHelper.TABLE_NAME, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Student student = cursorToStudent(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        return students;
    }

    private Student cursorToStudent(Cursor cursor) {
        Student student = new Student();
        student.name = cursor.getString(0);
        student.age = cursor.getInt(1);
        student.language = cursor.getString(2);

        return student;
    }
}
