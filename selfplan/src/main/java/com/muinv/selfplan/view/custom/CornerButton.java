package com.muinv.selfplan.view.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import com.muinv.selfplan.R;

/**
 * Created by FRAMGIA\nguyen.van.mui on 28/12/2016.
 */

public class CornerButton extends TextView {
    GradientDrawable mDrawable;
    private int mBgColor = Color.WHITE;
    private int mCornerRadius = 0;

    public CornerButton(Context context) {
        super(context);
        init(null);
    }

    public CornerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CornerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mDrawable = new GradientDrawable();
        TypedArray typedArray = getContext().getTheme()
                .obtainStyledAttributes(attrs, R.styleable.CornerButton, 0, 0);
        try {
            mBgColor = typedArray.getColor(R.styleable.CornerButton_bgColor, mBgColor);
            mCornerRadius = typedArray.getDimensionPixelSize(R.styleable.CornerButton_corner,
                    mCornerRadius);
        } finally {
            typedArray.recycle();
        }
        refresh();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void refresh() {
        mDrawable.setColor(mBgColor);
        mDrawable.setCornerRadius(mCornerRadius);
        setBackground(mDrawable);
        invalidate();
    }
}


