package com.company.codelearn.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.company.codelearn.UserData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "CodeLearn.db";
    private static final String INITIAL_TABLES = "createTables.sqlite";
    private final Context context;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            InputStream queries = context.getAssets().open(INITIAL_TABLES);
            BufferedReader reader = new BufferedReader(new InputStreamReader(queries));
            String line;
            while ((line = reader.readLine()) != null) {
                sqLiteDatabase.execSQL(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void createUser(UserData user) {
        //Users
        ContentValues usersTableValues = new ContentValues();
        usersTableValues.put(DatabaseConsts.Users.ID, user.getUserId());
        usersTableValues.put(DatabaseConsts.Users.EMAIL, user.getEmail());
        usersTableValues.put(DatabaseConsts.Users.NAME, user.getName());
        getWritableDatabase().insert(DatabaseConsts.Users.TABLE_NAME, null, usersTableValues);

        //Rank
        ContentValues rankTableValues = new ContentValues();
        rankTableValues.put(DatabaseConsts.Ranking.ID, user.getUserId());
        rankTableValues.put(DatabaseConsts.Ranking.POINTS, 100);
        getWritableDatabase().insert(DatabaseConsts.Ranking.TABLE_NAME, null, rankTableValues);
    }

    public void updateUserInfo(UserData userData) {
        ContentValues values = new ContentValues();
        values.put(DatabaseConsts.Users.ID, userData.getUserId());
        values.put(DatabaseConsts.Users.EMAIL, userData.getEmail());
        values.put(DatabaseConsts.Users.NAME, userData.getName());
        getWritableDatabase().replace(DatabaseConsts.Users.TABLE_NAME, null, values);
    }

    public void updateUserPoints(UserData userData, Integer pointDifference) {
        //TODO: implement later
    }

    public Map<UserData, Integer> getRankingList() {

        HashMap<UserData, Integer> result = new HashMap<>();
        Cursor cursor = getWritableDatabase().rawQuery(DatabaseConsts.Ranking.Queries.GET_RANKING_LIST_QUERY, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.NAME));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.EMAIL));
            Integer rank = cursor.getInt(cursor.getColumnIndex(DatabaseConsts.Ranking.POINTS));
            result.put(new UserData(id, name, email), rank);
        }
        return result;
    }
}