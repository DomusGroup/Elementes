package com.domus.tankhah.elementes.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.domus.tankhah.elementes.R;

/**
 * Created by osati.m on 12/13/2017.
 */

public class DCButton extends android.support.v7.widget.AppCompatButton {
    private static final String TAG = "DCButton";
    public DCButton(Context context) {
        super(context);
        makeCustomFont(context , null);
    }

    public DCButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        makeCustomFont(context , attrs);
    }

    public DCButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        makeCustomFont(context , attrs);
    }

    public void makeCustomFont(Context context , AttributeSet attrs) {
        if(attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs , R.styleable.DCView);
            try {
                String path =typedArray.getString(R.styleable.DCView_font);
                Typeface typeface = CashFont.getInstance().getTypeFace(getContext() , path) ;
                setTypeface(typeface);
            }finally {
                invalidate();
                requestLayout();
                typedArray.recycle();
            }
        }
    }
}
