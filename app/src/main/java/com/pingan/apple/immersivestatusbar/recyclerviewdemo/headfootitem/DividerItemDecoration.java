package com.pingan.apple.immersivestatusbar.recyclerviewdemo.headfootitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * @author apple
 * @Description :
 * @date 17/1/16  下午3:17
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration{

    private static final int[] ATTRS = new int[] {
      android.R.attr.listDivider
    };
    private Drawable mDivider;
    private int mOritentaion;
    public static int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private static final String TAG = DividerItemDecoration.class.getSimpleName();
    private final Paint mPaint;

    public DividerItemDecoration(Context context, int orientation) {
        TypedArray array = context.obtainStyledAttributes(ATTRS);
        mDivider = array.getDrawable(0);
        array.recycle();
        mPaint = new Paint();
        mPaint.setColor(Color.CYAN);
        setOrientation(orientation);
    }

    public void setDivider(Drawable drawable) {
        mDivider = drawable;
    }

    public void setOrientation(int orientation) {

        if(orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOritentaion = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOritentaion == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {

        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin + Math.round(ViewCompat.getTranslationX(child));
            int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom); // set the position of the drawable in the canvas
            mDivider.draw(c); // canvas draw the drawable
        }

    }

    private void drawVertical(Canvas c, RecyclerView parent) {

        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin + Math.round(ViewCompat.getTranslationY(child));
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            c.drawRect(left, top, right, bottom, mPaint);
//            mDivider.draw(c);
        }


    }

    /**
     *  set the size of the item decoration and relative position
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //super 默认是set(0,0,0,0)
        Log.e(TAG, "getItemOffsets: "+ view );
        if(mOritentaion == VERTICAL_LIST) {
            int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
            int count = parent.getAdapter().getItemCount();
            if(position < count-1) {
                outRect.set(0, 0 , 0, mDivider.getIntrinsicHeight());
            }
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }

    public void setDividerDrawable(Drawable drawable){
        this.mDivider = drawable;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int itemCount = state.getItemCount();
        int childCount = parent.getChildCount();
        Log.e(TAG, "onDrawOver: =itemCount=="+itemCount+"==childcount=="+childCount );

    }
}
