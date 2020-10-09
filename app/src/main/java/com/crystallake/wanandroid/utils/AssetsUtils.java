package com.crystallake.wanandroid.utils;

import android.content.Context;
import android.content.res.AssetManager;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AssetsUtils {
    public static String getJson(Context context, String fileName) {
        if (context==null){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        InputStreamReader isr = null;
        BufferedReader bf = null;
        try {
            isr = new InputStreamReader(assetManager.open(fileName));
            bf = new BufferedReader(isr);
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}