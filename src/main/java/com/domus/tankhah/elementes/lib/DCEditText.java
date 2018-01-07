package com.domus.tankhah.elementes.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;

import com.domus.tankhah.elementes.R;

/**
 * Created by osati.m on 12/13/2017.
 */

public class DCEditText extends android.support.v7.widget.AppCompatEditText {
    private static final String TAG = "DCEditText";

    private static final int FORMAT_NORMAL = 0;
    private static final int FORMAT_PERSION = 1;
    private static final int FORMAT_PERSION_AMOUNT = 2;

    private String beforString = "";

    private int format = 0;

    public DCEditText(Context context) {
        super(context);
        makeCustom(context, null);
    }

    public DCEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        makeCustom(context, attrs);
    }

    public DCEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        makeCustom(context, attrs);
    }

    public void makeCustom(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DCView);
            try {
                setFont(context, typedArray.getString(R.styleable.DCView_font));
                persianized(typedArray.getInteger(R.styleable.DCView_format, 0));
            } finally {
                invalidate();
                requestLayout();
                typedArray.recycle();
            }
        }
    }

    private void persianized(int format) {
        this.format = format;
        switch (this.format) {
            case FORMAT_PERSION:
                formatingPersian(FORMAT_PERSION);
                break;
            case FORMAT_PERSION_AMOUNT:
                formatingPersian(FORMAT_PERSION_AMOUNT);
                break;
        }
    }

    private void formatingPersian(final int format) {
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                beforString = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (format == FORMAT_PERSION)
                    onTextChangedFormatPersian(s.toString());
                else if (format == FORMAT_PERSION_AMOUNT)
                    onTextChangedFormatPersianAmount(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void onTextChangedFormatPersianAmount(String s) {
        String tempNumber = Utils.getNumber(s);
        Log.i(TAG, "onTextChangedFormatPersianAmount tempNumber: " + tempNumber);
        tempNumber = Utils.trimzero(tempNumber);
        tempNumber = Utils.separate3(tempNumber);
        Log.i(TAG, "onTextChangedFormatPersianAmount tempNumber: " + tempNumber);
        onTextChangedFormatPersian(tempNumber);
    }


    private void onTextChangedFormatPersian(String s) {
        String persionNumber = Utils.persianString(s);
        changeText(persionNumber);
    }

    private void changeText(String text) {
        if (!text.equals(getText().toString())) {
            int curserPosition = this.getSelectionStart();
            if (text.length() != beforString.length())
                if(text.length()>beforString.length())
                curserPosition = this.getSelectionStart() + text.length() - beforString.length() - 1;
                else
                    curserPosition = this.getSelectionStart() + text.length() - beforString.length() + 1;
            if (curserPosition < 0)
                curserPosition = 0;
            if (curserPosition > text.length())
                curserPosition = text.length();
            this.setText(text);
            this.setSelection(curserPosition);
        }
    }


    private void setFont(Context context, String path) {
        Typeface typeface = CashFont.getInstance().getTypeFace(context, path);
        setTypeface(typeface);
    }

    public void setNumber(String s) {
        switch (this.format) {
            case FORMAT_PERSION:
                onTextChangedFormatPersian(s);
                break;
            case FORMAT_PERSION_AMOUNT:
                onTextChangedFormatPersianAmount(s);
                break;
        }
    }

    public String getNumberString() {
        return Utils.englishString(Utils.getNumber(this.getText().toString()));
    }
}
