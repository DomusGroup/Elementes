package com.domus.tankhah.elementes.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import com.domus.tankhah.elementes.R;

/**
 * Created by osati.m on 12/13/2017.
 */

public class DCCheckBox extends android.support.v7.widget.AppCompatCheckBox {
    private static final String TAG = "DCButton";
    public DCCheckBox(Context context) {
        super(context);
        makeCustomFont(context , null);
    }

    public DCCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        makeCustomFont(context , attrs);
    }

    public DCCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        makeCustomFont(context , attrs);
    }

    public void makeCustomFont(Context context , AttributeSet attrs) {
        if(attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs , R.styleable.DCView);
            try {
                String path =typedArray.getString(R.styleable.DCView_font);
                Typeface typeface = CashFont.getInstance().getTypeFace(getContext() , path) ;
                Log.i(TAG, "makeCustom: " + typeface);
                setTypeface(typeface);
            }finally {
                invalidate();
                requestLayout();
                typedArray.recycle();
            }
        }
    }
}
