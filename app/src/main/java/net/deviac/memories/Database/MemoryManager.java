package net.deviac.memories.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import net.deviac.memories.Model.MemoryModel;

import java.util.ArrayList;


public class MemoryManager {
    Context context;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    MemoryModel memoryModel;

    public MemoryManager(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public long addMemory(MemoryModel memoryModel) {
    	sqLiteDatabase = databaseHelper.getWritableDatabase();

    	ContentValues contentValues=new ContentValues();

    	contentValues.put(DatabaseHelper.MEMORIES_COLUMN_TITLE, memoryModel.getMemoryTitle());
        contentValues.put(DatabaseHelper.MEMORIES_COLUMN_DESCRIPTION, memoryModel.getMemoryDescription());
        contentValues.put(DatabaseHelper.MEMORIES_COLUMN_IMAGE, memoryModel.getMemoryImage());
        contentValues.put(DatabaseHelper.MEMORIES_COLUMN_DATE, memoryModel.getMemoryDate());

        long insertRow = sqLiteDatabase.insert(DatabaseHelper.MEMORIES_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return insertRow;
    }

    // Get Memory By Id
//    public MemoryModel getMemory() {
//        String query = "SELECT * FROM " + DatabaseHelper.MEMORIES_TABLE;
//
//        sqLiteDatabase = databaseHelper.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
//
//        if(cursor.moveToFirst()) {
//            String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MEMORIES_COLUMN_TITLE));
//            String description = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MEMORIES_COLUMN_DESCRIPTION));
//            String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MEMORIES_COLUMN_DATE));
//            String image = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MEMORIES_COLUMN_IMAGE));
//            memoryModel = new MemoryModel(title, description, image, date);
//        }
//
//        return memoryModel;
//    }

    // Get All Memories
    public ArrayList<MemoryModel> getAllMemories() {
        ArrayList<MemoryModel> memories = new ArrayList<>();

        String query = "SELECT * FROM " + DatabaseHelper.MEMORIES_TABLE;
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MEMORIES_COLUMN_TITLE));
                String description = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MEMORIES_COLUMN_DESCRIPTION));
                String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MEMORIES_COLUMN_DATE));
                String image = cursor.getString(cursor.getColumnIndex(DatabaseHelper.MEMORIES_COLUMN_IMAGE));
                memories.add(new MemoryModel(id, title, description, image, date));
            } while(cursor.moveToNext());
        }
        return memories;
    }

    public boolean updateMemory(MemoryModel memoryModel) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(DatabaseHelper.MEMORIES_COLUMN_TITLE, memoryModel.getMemoryTitle());
        contentValues.put(DatabaseHelper.MEMORIES_COLUMN_DESCRIPTION, memoryModel.getMemoryDescription());
        contentValues.put(DatabaseHelper.MEMORIES_COLUMN_IMAGE, memoryModel.getMemoryImage());
        contentValues.put(DatabaseHelper.MEMORIES_COLUMN_DATE, memoryModel.getMemoryDate());

        int rowUpdate = sqLiteDatabase.update(DatabaseHelper.MEMORIES_TABLE, contentValues, databaseHelper.MEMORIES_COLUMN_ID + "=" + memoryModel.getMemoryId(), null);

        return rowUpdate > 0;
    }

    public boolean deleteMemory(int memoryId){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        return sqLiteDatabase.delete(databaseHelper.MEMORIES_TABLE, databaseHelper.MEMORIES_COLUMN_ID + "=" + memoryId, null) > 0;
    }

}

