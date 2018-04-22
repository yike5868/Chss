package net.greatsoft.main.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RoundRectShape;
public class BackgroundColor extends Drawable{
    private static final float DEFAULT_RADIUS = 360.f;
    private Paint mPaint = new Paint();
    private Paint mPaint2 = new Paint();
    private RoundRectShape mShape;
    private RoundRectShape mShape2;
    private float[] mOuter;
    private int mColor;
    private int mColor2;
    private int mPressColor;
    private float mTopLeftRadius = DEFAULT_RADIUS;
    private float mTopRightRadius = DEFAULT_RADIUS;
    private float mBottomLeftRadius = DEFAULT_RADIUS;
    private float mBottomRightRadius = DEFAULT_RADIUS;
    public BackgroundColor() {
        mColor = Color.RED;
        mColor2 = Color.BLACK;
        mPressColor = Color.GREEN;
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
        mPaint2.setColor(mColor2);
        mPaint2.setAntiAlias(true);

    }
    public float getTopLeftRadius() {
        return mTopLeftRadius;
    }
    public void setTopLeftRadius(float topLeftRadius) {
        this.mTopLeftRadius = topLeftRadius;
    }
    public float getTopRightRadius() {
        return mTopRightRadius;
    }
    public void setTopRightRadius(float topRightRadius) {
        this.mTopRightRadius = topRightRadius;
    }
    public float getBottomLeftRadius() {
        return mBottomLeftRadius;
    }
    public void setBottomLeftRadius(float bottomLeftRadius) {
        this.mBottomLeftRadius = bottomLeftRadius;
    }
    public float getBottomRightRadius() {
        return mBottomRightRadius;
    }
    public void setBottomRightRadius(float bottomRightRadius) {
        this.mBottomRightRadius = bottomRightRadius;
    }
    public int getPressColor() {
        return mPressColor;
    }
    public void setPressColor(int pressColor) {
        this.mPressColor = pressColor;
    }
    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        refreshShape();
        mShape.resize(bounds.right - bounds.left, bounds.bottom - bounds.top);
        mShape2.resize(bounds.right-bounds.left-3,bounds.bottom-bounds.top-3);
    }
    private void refreshShape(){
        mOuter = new float[]{mTopLeftRadius, mTopLeftRadius
                , mTopRightRadius, mTopRightRadius
                , mBottomLeftRadius, mBottomLeftRadius
                , mBottomRightRadius, mBottomLeftRadius};
        mShape = new RoundRectShape(mOuter, null, null);
        mShape2 = new RoundRectShape(mOuter,null,null);
    }
    public void setColor(int color){
        mColor = color;
        mPaint.setColor(color);


    }
    @Override
    public void draw(Canvas canvas) {
        mShape.draw(canvas, mPaint);
        mShape2.draw(canvas,mPaint2);
    }
    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }
    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }
    @Override
    public int getOpacity() {
        return mPaint.getAlpha();
    }
}
