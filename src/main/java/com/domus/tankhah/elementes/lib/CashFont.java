package com.domus.tankhah.elementes.lib;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osati.m on 12/13/2017.
 */

public class CashFont {

    private static final String TAG = "CashFont";
    private static List<FontEntity> fontEntities = new ArrayList<>();

    private static final CashFont ourInstance = new CashFont();

    public static CashFont getInstance() {
        return ourInstance;
    }

    private CashFont() {
    }

    public Typeface getTypeFace(Context context ,String path) {
        Log.i(TAG, "getTypeFace: " + path);
        FontEntity fontEntity = findFont(path);
        if (fontEntity == null) {
            try {
                fontEntity = new FontEntity();
                fontEntity.setPath(path);
                fontEntity.setTypeface(Typeface.createFromAsset(context.getApplicationContext().getAssets(), path));
                fontEntities.add(fontEntity);
            } catch (Exception e) {
                String defualtPath = "fonts/default_irsans.ttf" ;
                fontEntity = findFont(defualtPath) ;
                if (fontEntity == null){
                    fontEntity = new FontEntity();
                    fontEntity.setPath(defualtPath);
                    Log.i(TAG, "getTypeFace: " + fontEntity.getPath());
                    fontEntity.setTypeface(Typeface.createFromAsset(context.getAssets(), defualtPath));
                    fontEntities.add(fontEntity);
                }
            }
        }
        return fontEntity.getTypeface();

    }

    private FontEntity findFont(String path) {
        for (FontEntity fontEntity : fontEntities) {
            if (fontEntity.getPath() == path)
                return fontEntity;
        }
        return null;
    }
}
