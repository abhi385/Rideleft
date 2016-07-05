package com.example.sys.rideleft.Other;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sys.rideleft.R;

/**
 * Created by sys on 6/20/2016.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration{
    private Drawable mDivider;

    public DividerItemDecoration(Resources resources) {
        mDivider = resources.getDrawable(R.drawable.line_divider);
    }





    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft()+parent.getWidth()/18;
        int right = parent.getWidth() - parent.getPaddingRight();






        int childCount = parent.getChildCount();
        for (int i = 1; i < childCount-1; i++)
        {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}