package com.shweta.news.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shweta.news.model.FavoriteModel;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefs {
    public static final String PREF_NAME = "prefs";
    public static final String KEY_SAVED = "saved";
    public static final String KEY_FAVORITE = "favorite";
    private static SharedPreferences.Editor editor;
    private static SharedPreferences sharedPreferences;
    private static SharedPrefs sharedPrefs;

    public static synchronized SharedPrefs getInstance() {
        if (sharedPrefs == null) {
            sharedPrefs = new SharedPrefs();
        }
        return sharedPrefs;
    }

    public static String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public static Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public static void setString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public static void setBoolean(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }
    public void saveFavList(List<FavoriteModel> myList, String key) {
        String listJson = new Gson().toJson(myList);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, listJson);
        editor.apply();

    }
    public List<FavoriteModel> getFavList(String key) {
        String listJson = sharedPreferences.getString(key, null);

        if (listJson != null) {
            Type type = new TypeToken<List<FavoriteModel>>() {}.getType();
            return new Gson().fromJson(listJson, type);
        } else {
            return new ArrayList<>();
        }
    }


    public static void setModel(Object modal) {
        String jsonObject = new Gson().toJson(modal);
        editor.putString("userModel", jsonObject);
        editor.commit();
    }

    public static void clearAll() {
        editor.clear();
        editor.commit();
    }



    public void initSharedPrefs() {
        sharedPreferences = AppConfig.getInstance().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}
