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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
        rankTableValues.put(DatabaseConsts.Ranking.POINTS, 0);
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

        Map<UserData, Integer> result = new LinkedHashMap<>();
        Cursor cursor = getWritableDatabase().rawQuery(DatabaseConsts.Ranking.RawQueries.GET_RANKING_LIST_QUERY, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.NAME));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.EMAIL));
            Integer rank = cursor.getInt(cursor.getColumnIndex(DatabaseConsts.Ranking.POINTS));
            System.out.println(new UserData(id, name, email).toString() + rank);
            result.put(new UserData(id, name, email), rank);

        }
        return result;
    }

    public void createUserIfNotExist(UserData data) {
        if(getUserDataFromEmail(data.getEmail()) == null) {
            createUser(data);
        }
    }

    public List<UserData> getFriendList(UserData user) {
        List<UserData> result = new ArrayList<>();
        Cursor cursor = getWritableDatabase().rawQuery(DatabaseConsts.FriendList.RawQueries.GET_FRIEND_LIST, new String[]{user.getUserId()});
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(DatabaseConsts.FriendList.FRIEND_ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.NAME));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.EMAIL));
            result.add(new UserData(id, name, email));
        }
        return result;
    }

    public void addFriend(UserData currentUser, UserData friend) {
        ContentValues values = new ContentValues();
        values.put(DatabaseConsts.FriendList.ID, currentUser.getUserId());
        values.put(DatabaseConsts.FriendList.FRIEND_ID, friend.getUserId());
        getWritableDatabase().insert(DatabaseConsts.FriendList.TABLE_NAME, null, values);
    }

    public UserData getUserDataFromId(String id) {
        Cursor cursor = getWritableDatabase().query(DatabaseConsts.Users.TABLE_NAME, null, DatabaseConsts.Users.ID + " = ?", new String[]{id}, null, null,null, String.valueOf(1));
        if(cursor.getCount() == 0)
            return null;
        return getUserDataFromCursor(cursor);
    }

    private UserData getUserDataFromCursor(Cursor cursor) {
        cursor.moveToFirst();
        String id = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.ID));
        String userEmail = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.EMAIL));
        String name = cursor.getString(cursor.getColumnIndex(DatabaseConsts.Users.NAME));
        return new UserData(id, name, userEmail);
    }

    public UserData getUserDataFromEmail(String email) {
        Cursor cursor = getWritableDatabase().query(DatabaseConsts.Users.TABLE_NAME, null, DatabaseConsts.Users.EMAIL + " = ?", new String[]{email}, null, null,null, String.valueOf(1));
        if(cursor.getCount() == 0)
            return null;
        return getUserDataFromCursor(cursor);
    }

    public void deleteFriend(UserData user, UserData friend) {
        getWritableDatabase().delete(DatabaseConsts.FriendList.TABLE_NAME, DatabaseConsts.FriendList.ID + "=? AND " + DatabaseConsts.FriendList.FRIEND_ID + "=?", new String[]{user.getUserId(), friend.getUserId()});
    }

    public boolean areFriends(UserData currentUser, UserData friend) {
        Cursor cursor = getWritableDatabase().query(DatabaseConsts.FriendList.TABLE_NAME, null, DatabaseConsts.FriendList.ID + "= ? AND " + DatabaseConsts.FriendList.FRIEND_ID + " = ?", new String[] {currentUser.getUserId(), friend.getUserId()}, null, null, null, String.valueOf(1));
        return cursor.getCount() != 0;
    }
}