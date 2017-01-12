package com.pingan.apple.immersivestatusbar.staticview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.pingan.apple.immersivestatusbar.R;

/**
 * @author apple
 * @Description :
 * @date 17/1/11  上午11:16
 */

public class StaticsView extends View {

    private static final String TAG = StaticsView.class.getClass().getSimpleName();

    private int mBorderColor;
    private int mPathColor;
    private int mTextColor;
    private Paint mBorderPaint;
    private Paint mPathPaint;
    private Paint mPointPaint;
    private Path mPath;

    private String[] xString = {};
    private float[] yValue = {};
    private String mViewTitle;
    private int mYDivideCount = 10;
    private int mYMaxValue = 100;
    private float mXDivide;
    private float mYDivide;
    private TextPaint mTextPaint;
    private float perValue = mYMaxValue/mYDivideCount;


    public StaticsView(Context context) {
        this(context, null);
    }

    public StaticsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StaticsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
        Log.e(TAG, "StaticsView: constract " );
    }

    public void setYDivideCount(int yDivideCount) {
        this.mYDivideCount = yDivideCount;
    }

    public void setYPerValue(float yPerValue) {
        perValue = yPerValue;
    }

    /**
     * 初始化 自定义view 所需要的参数信息（通过xml 中的自定义属性） 或者 paint 的初始化
     */
    private void initView(AttributeSet attrs) {
        // 获取自定义数据对应的共享数组信息
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.staticsView);
        mYMaxValue = array.getInteger(R.styleable.staticsView_yMaxValue, 100);
        mYDivideCount = array.getInteger(R.styleable.staticsView_yDivideCount, 10);
        mViewTitle = array.getString(R.styleable.staticsView_titleView);
        mBorderColor = array.getColor(R.styleable.staticsView_borderColor, Color.BLACK);
        mPathColor = array.getColor(R.styleable.staticsView_pathColor, Color.BLUE);
        mTextColor = array.getColor(R.styleable.staticsView_textColor, Color.CYAN);

        mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setColor(mBorderColor);
        mBorderPaint.setStrokeWidth(2);

        mPathPaint.setColor(mPathColor);
        mPathPaint.setStyle(Paint.Style.STROKE);
        mPathPaint.setStrokeWidth(3);

        mPointPaint.setColor(Color.GREEN);
        mPointPaint.setStyle(Paint.Style.FILL);

        mTextPaint = new TextPaint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(dip2px(getContext(), 12));
        mPath = new Path();

        array.recycle();
    }

    public int dip2px(Context context, int size) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(size*density+0.5f);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(TAG, "onFinishInflate: " );
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if(widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            setMeasuredDimension(widthSize, heightSize);
        } else if(widthMode == MeasureSpec.EXACTLY) {
            setMeasuredDimension(widthSize, widthSize);
        } else if(heightMode == MeasureSpec.EXACTLY) {
            setMeasuredDimension(heightSize, heightSize);
        }
        Log.e(TAG, "onMeasure: " );
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged: " );
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

            mXDivide = getWidth()/(xString.length+1);   // +1 在于左右的空间  展示左侧title栏 和view右侧间隙
            mYDivide = getHeight()/(mYDivideCount+2);   // view title 和 底部title 空间
        Log.e(TAG, "onLayout: "+"=mXDivide="+mXDivide+"=mYDivide="+mYDivide);
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(xString.length<=0 || yValue.length<=0) {
            return;
        }
        //画边线
        canvas.drawLine(mXDivide, mYDivide, mXDivide, getHeight()-mYDivide, mBorderPaint); // left
        canvas.drawLine(mXDivide,getHeight()-mYDivide, getWidth()-mXDivide, getHeight()-mYDivide, mBorderPaint); //up 原点不是坐标原点
        // 画黑点 bottom 文字
        float bottomTextHeight = mTextPaint.getFontMetrics().descent - mTextPaint.getFontMetrics().ascent;
        for (int i = 1; i <= xString.length; i++) {
            canvas.drawCircle(i*mXDivide, getHeight()-mYDivide,6, mPointPaint);
            //draw 字体  text的measure 1.height 2.左下角坐标位置 为drawText 方法的 x，y 参数
            canvas.drawText(xString[i-1], i*mXDivide-mTextPaint.measureText(xString[i-1])/2, getHeight()-mYDivide/2+bottomTextHeight/2, mTextPaint);
        }

        // 画左边的字
        for (int i = 1; i <= (mYDivideCount + 1); i++) {
            canvas.drawText(perValue*(i-1)+"", mXDivide/2-mTextPaint.measureText(perValue*(i-1)+"")/2,((mYDivideCount+2)-i)*mYDivide+bottomTextHeight/2,mTextPaint);

            //画value 对应的 线
            canvas.drawLine(mXDivide,((mYDivideCount+2)-i)*mYDivide,getWidth()-mXDivide,((mYDivideCount+2)-i)*mYDivide, mBorderPaint);
        }


        // 画轨迹 点 连线成轨迹

        for (int i = 0; i < yValue.length; i++) {

//      不是简单画点 可直接画然后连接的同时draw      canvas.drawCircle((i+1)*mXDivide, (mYDivideCount+1)*mYDivide-yValue[i]*mYDivide/perValue,6, mPointPaint);
            if(i == 0) {
                mPath.moveTo(mXDivide,getHeight()-yValue[i]*mYDivide/perValue-mYDivide);
            } else {
                mPath.lineTo((i+1)*mXDivide, getHeight()-yValue[i]*mYDivide/perValue-mYDivide);
            }
            //画点
            canvas.drawCircle((i+1)*mXDivide, getHeight()-yValue[i]*mYDivide/perValue-mYDivide,6, mPointPaint);
        }

        //画文字title
        canvas.drawText(mViewTitle,mXDivide, mYDivide/2+bottomTextHeight/2, mTextPaint);

        // path 设置路线但没有画上来
        canvas.drawPath(mPath, mPathPaint);
    }

    public void setYValues(float[] YValues) {
        yValue = YValues;
        requestLayout();
    }

    public void setXString(String[] XString) {
        xString = XString;
        invalidate();
    }
}
