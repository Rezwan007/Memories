package net.deviac.memories.Database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABSE_NAME = "memories";
    private static final int DATABASE_VERSION = 1;

    public static final String MEMORIES_TABLE="memories";
    public static final String MEMORIES_COLUMN_ID="id";
    public static final String MEMORIES_COLUMN_TITLE="title";
    public static final String MEMORIES_COLUMN_DESCRIPTION="description";
    public static final String MEMORIES_COLUMN_IMAGE="image";
    public static final String MEMORIES_COLUMN_DATE="date";

    private static final String CREATE_TABLE_MEMORIES="create table " + MEMORIES_TABLE + "("
            + MEMORIES_COLUMN_ID + " integer primary key autoincrement,"
            + MEMORIES_COLUMN_TITLE + " text,"
            + MEMORIES_COLUMN_DESCRIPTION +" text,"
            + MEMORIES_COLUMN_IMAGE + " text,"
            + MEMORIES_COLUMN_DATE + " text);";

    public DatabaseHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MEMORIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+MEMORIES_TABLE+" if exists");
        onCreate(db);
    }
}
