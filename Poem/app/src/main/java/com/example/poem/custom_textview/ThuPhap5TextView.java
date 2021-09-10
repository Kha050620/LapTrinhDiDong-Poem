package com.example.poem.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class ThuPhap5TextView extends AppCompatTextView {
    public ThuPhap5TextView(@NonNull Context context) {
        super(context);
        setFontsTextView();

    }

    public ThuPhap5TextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontsTextView();

    }

    public ThuPhap5TextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontsTextView();
    }
    private void setFontsTextView()
    {
        Typeface typeface = Utils.getThuphap5(getContext());
        setTypeface(typeface);
    }
}
