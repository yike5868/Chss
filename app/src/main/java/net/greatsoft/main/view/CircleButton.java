package net.greatsoft.main.view;

/**
 * Created by zhanglin on 2016/10/31.
 */

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;

import net.greatsoft.main.Constant;
import net.greatsoft.main.R;

public class CircleButton extends Button {

    private static final int PRESSED_COLOR_LIGHTUP = 255 / 25;
    private static final int PRESSED_RING_ALPHA = 100;
    private static final int DEFAULT_PRESSED_RING_WIDTH_DIP = 2;
    private static final int ANIMATION_TIME_ID = android.R.integer.config_shortAnimTime;

    private int centerY;
    private int centerX;
    private int outerRadius;
    private int pressedRingRadius;

    private Paint circlePaint;
    private Paint focusPaint;

    private float animationProgress;

    private int pressedRingWidth;
    private int defaultColor = Color.WHITE;

    private ObjectAnimator pressedAnimator;


    private int cb_type = 0;//0 老 1 高 2 糖   3 smi 4其他
    private int cb_man = 0;//0 空 1 满
    private int cb_color = Color.BLACK;
    private int pressedColor;  //颜色


    public CircleButton(Context context) {
        super(context);
        init(context, null);
    }

    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CircleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    @Override
    public void setPressed(boolean pressed) {
//        super.setPressed(pressed);
//
//        if (circlePaint != null) {
//            circlePaint.setColor(pressed ? pressedColor : defaultColor);
//        }
//
//        if (pressed) {
//            showPressedRing();
//        } else {
//            hidePressedRing();
//        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, pressedRingRadius + animationProgress, focusPaint);
        canvas.drawCircle(centerX, centerY, outerRadius - pressedRingWidth, circlePaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        outerRadius = Math.min(w, h) / 2;
        pressedRingRadius = outerRadius - pressedRingWidth - pressedRingWidth / 2;
    }

    public float getAnimationProgress() {
        return animationProgress;
    }

    public void setAnimationProgress(float animationProgress) {
        this.animationProgress = animationProgress;
        this.invalidate();
    }

    public void setColor(int type, int man) {
        this.defaultColor = Color.WHITE;
//        this.pressedColor = getHighlightColor(color, PRESSED_COLOR_LIGHTUP);

        switch (type) {
            case 0:
                this.pressedColor = Constant.O_COLOR;
                setText("老");
                cb_color = Constant.O_COLOR;
                break;
            case 1:
                this.pressedColor = Constant.H_COLOR;
                cb_color = Constant.H_COLOR;
                setText("高");
                break;
            case 2:
                setText("糖");
                cb_color = Constant.D_COLOR;
                this.pressedColor = Constant.D_COLOR;
                break;
            case 3:
                setText("smi");
                cb_color = Constant.S_COLOR;
                this.pressedColor = Constant.S_COLOR;
                break;
            case 4:
                this.pressedColor = cb_color;
                break;
        }

        if (0 == man) {
            defaultColor = Color.WHITE;
            pressedColor = cb_color;
        } else {
            defaultColor = cb_color;
            pressedColor = Color.WHITE;
        }

        setTextColor(cb_color);

        circlePaint.setColor(defaultColor);
        focusPaint.setColor(pressedColor);
        this.invalidate();
    }



    @Override
    public void setText(CharSequence text, BufferType type) {
        if(text == null)
            return;
        super.setText(text, type);
    }

    private void hidePressedRing() {
        pressedAnimator.setFloatValues(pressedRingWidth, 0f);
        pressedAnimator.start();
    }

    private void showPressedRing() {
        pressedAnimator.setFloatValues(animationProgress, pressedRingWidth);
        pressedAnimator.start();
    }

    private void init(Context context, AttributeSet attrs) {
        this.setFocusable(true);
//        this.setScaleType(ScaleType.CENTER_INSIDE);
        setClickable(true);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);

        focusPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        focusPaint.setStyle(Paint.Style.STROKE);

        pressedRingWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_PRESSED_RING_WIDTH_DIP, getResources()
                .getDisplayMetrics());

        if (attrs != null) {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleButton);
            cb_color = a.getColor(R.styleable.CircleButton_cb_color, Color.BLACK);
            cb_man = a.getInt(R.styleable.CircleButton_cb_man, 0);
            pressedRingWidth = (int) a.getDimension(R.styleable.CircleButton_cb_pressedRingWidth, pressedRingWidth);
            cb_type = a.getInt(R.styleable.CircleButton_cb_type, 0);

            a.recycle();
        }

        setColor(cb_type, cb_man);

        focusPaint.setStrokeWidth(pressedRingWidth);
        final int pressedAnimationTime = getResources().getInteger(ANIMATION_TIME_ID);
        pressedAnimator = ObjectAnimator.ofFloat(this, "animationProgress", 0f, 0f);
        pressedAnimator.setDuration(pressedAnimationTime);
        showPressedRing();
    }

    private int getHighlightColor(int color, int amount) {
        return Color.argb(Math.min(255, Color.alpha(color)), Math.min(255, Color.red(color) + amount),
                Math.min(255, Color.green(color) + amount), Math.min(255, Color.blue(color) + amount));
    }
    public int getCb_type() {
        return cb_type;
    }

    public void setCb_type(int cb_type) {
        this.cb_type = cb_type;
    }

    public int getCb_man() {
        return cb_man;
    }

    public void setCb_man(int cb_man) {
        this.cb_man = cb_man;
    }

    public int getCb_color() {
        return cb_color;
    }

    public void setCb_color(int cb_color) {
        this.cb_color = cb_color;
    }

    public int getPressedColor() {
        return pressedColor;
    }

    public void setPressedColor(int pressedColor) {
        this.pressedColor = pressedColor;
    }
}