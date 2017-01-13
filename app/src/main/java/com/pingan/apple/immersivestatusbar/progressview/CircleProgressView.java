package com.pingan.apple.immersivestatusbar.progressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.pingan.apple.immersivestatusbar.R;
import com.pingan.apple.immersivestatusbar.utils.CommonUtil;

/**
 * @author apple
 * @Description :
 * @date 17/1/12  下午3:53
 */

public class CircleProgressView extends ProgressBar {

    private int mStableCircleColor;
    private int mMoveArcColor;
    private float mStableCircleWidth;
    private float mMoveArcWidth;
    private float mInnerCircleRadius;
    private Path mPath;
    private Paint mPaint;
    private int mStrokeSize;
    private State mStatus = State.Stop;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.circleProgressView);
        mStableCircleColor = array.getColor(R.styleable.circleProgressView_stableCircleColor, Color.GRAY);
        mMoveArcColor = array.getColor(R.styleable.circleProgressView_moveArcColor, Color.RED);

        mStableCircleWidth = array.getDimension(R.styleable.circleProgressView_stableCircleWidth, CommonUtil.dip2px(2,getContext()));
        mMoveArcWidth = array.getDimension(R.styleable.circleProgressView_moveArcWidth, CommonUtil.dip2px(2,getContext()));

        mInnerCircleRadius = array.getDimension(R.styleable.circleProgressView_innerCircleRadius, CommonUtil.dip2px(30,getContext()));
        array.recycle();

        // init the paint
//        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG & Paint.DITHER_FLAG);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        // set the path of triangle
        float triangleLength = mInnerCircleRadius;
        mPath = new Path();
        // left top point
        mPath.moveTo((float)(mInnerCircleRadius - triangleLength*Math.sqrt(3)/4)*(1.1f), mInnerCircleRadius - triangleLength/2);
        // left bottom point
        mPath.lineTo((float)(mInnerCircleRadius - triangleLength*Math.sqrt(3)/4)*(1.1f), mInnerCircleRadius + triangleLength/2);
        // right point
        mPath.lineTo((float)(mInnerCircleRadius + triangleLength*Math.sqrt(3)/4)*(1.1f),mInnerCircleRadius);
        mPath.lineTo((float)(mInnerCircleRadius - triangleLength*Math.sqrt(3)/4)*(1.1f), mInnerCircleRadius - triangleLength/2);
    }

    /**
     *  设置view 大小的 方法 1  方法2参见 onMeasure 中内容 两者可替换
     */
    private void setViewDimension(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int strokeSize = (int)Math.max(mStableCircleWidth, mMoveArcWidth);
        if(widthMode != MeasureSpec.EXACTLY) {
            widthSize = (int)mInnerCircleRadius*2 + strokeSize + getPaddingLeft() + getPaddingRight();
        }
        if(heightMode != MeasureSpec.EXACTLY) {
            heightSize = (int)mInnerCircleRadius*2 + strokeSize + getPaddingTop() + getPaddingBottom();
        }

        setMeasuredDimension(widthSize, heightSize);
    }


    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        mStrokeSize = (int)Math.max(mStableCircleWidth, mMoveArcWidth);
        if(widthMode != MeasureSpec.EXACTLY) {
           int exceptWidth = (int)mInnerCircleRadius*2 + mStrokeSize + getPaddingLeft() + getPaddingRight();
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(exceptWidth,MeasureSpec.EXACTLY);
        }
        if(heightMode != MeasureSpec.EXACTLY) {
           int exceptHeight = (int)mInnerCircleRadius*2 + mStrokeSize + getPaddingTop() + getPaddingBottom();
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(exceptHeight, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        //draw circle
        canvas.translate(getPaddingLeft(), getPaddingTop());
        mPaint.setColor(mStableCircleColor);
        mPaint.setStrokeWidth(mStableCircleWidth);
        canvas.drawCircle(mInnerCircleRadius, mInnerCircleRadius, mInnerCircleRadius, mPaint);

        // draw arc
        mPaint.setColor(mMoveArcColor);
        mPaint.setStrokeWidth(mMoveArcWidth);
         // rectF params --> the border of the arc
        float sweepAngle = getProgress()*1.0f/getMax()*360;
        canvas.drawArc(new RectF(0,0, mInnerCircleRadius*2, mInnerCircleRadius*2), 0, sweepAngle, false, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        if(mStatus == State.Running) {
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(CommonUtil.dip2px(5,getContext()));
            canvas.drawLine(mInnerCircleRadius*2/3, mInnerCircleRadius*2/3, mInnerCircleRadius*2/3, 2*mInnerCircleRadius*2/3, mPaint);
            canvas.drawLine(2*mInnerCircleRadius*2/3, mInnerCircleRadius*2/3, 2*mInnerCircleRadius*2/3,2*mInnerCircleRadius*2/3, mPaint);

        } else if (mStatus == State.Stop) {
            // draw triangle
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(mPath, mPaint);
        }
        canvas.restore();
    }

    public State getState() {
        return mStatus;
    }

    public void setState(State state) {
        mStatus = state;
        invalidate();
    }

    public enum State {
        Running,Stop
    }
}
