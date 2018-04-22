package net.greatsoft.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import net.greatsoft.main.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhanglin on 16/8/12.
 */

public class FuTextView extends TextView {

    int rotate;

    public FuTextView(Context context) {
        super(context);
    }

    public FuTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Districts);

        rotate = a.getInt(R.styleable.Districts_rotate, 0);
        a.recycle();

        String text = this.getText().toString();
        if (text.indexOf("\n") > -1) {
            text = text.replace("\n", "<br>");
        }
        if (text.indexOf("*") > -1) {
            this.setText(Html.fromHtml("" + text.replace("*", "")
                    + "<font color=\"red\" size=\"40px\"><b>＊</b></font>"));
        } else if (text.indexOf("＊") > -1)
            this.setText(Html.fromHtml("" + text.replace("＊", "")
                    + "<font color=\"red\" size=\"40px\"><b>＊</b></font>"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
//        canvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop());
        canvas.rotate(rotate, this.getWidth() / 2f, this.getHeight() / 2f);
        super.onDraw(canvas);
        canvas.restore();
    }

    public void setDegrees(int degrees) {
        rotate = degrees;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if(text == null)
            return;
        if (text.toString().indexOf("*") > -1) {
            text = Html.fromHtml("" + text.toString().replace("*", "")
                    + "<font color=\"red\" size=\"40px\"><b>＊</b></font>");
        } else if (text.toString().indexOf("＊") > -1)
            text = Html.fromHtml("" + text.toString().replace("＊", "")
                    + "<font color=\"red\" size=\"40px\"><b>＊</b></font>");

        super.setText(text, type);
    }


    public void setText(Date date) {
        if (date == null)
            return;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date_str = simpleDateFormat.format(date);
        setTag(date);
        setText(date_str);
    }

//    public void setAge(Date date) {
//        if (date == null)
//            return;
//        Calendar ca = Calendar.getInstance();
//        int now_year = ca.get(Calendar.YEAR);
//        ca.setTime(date);
//        int year = ca.get(Calendar.YEAR);
//        setText(now_year - year + " 岁");
//    }

    public void setAge( Date birthday) {
        if (birthday == null) {
            return;
        }
        Calendar now = Calendar.getInstance();
        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(birthday);
        int monthGap = now.get(Calendar.MONTH) - birthCal.get(Calendar.MONTH);
        int yearGap = (now.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR)) * 12;
        int gapMonth = monthGap + yearGap;
        setText(gapMonth / 12+"岁");
    }

    public void setText(Integer i) {
        if (i != null)
            setText(i + "");
    }

    public void setText(Integer i, Integer j) {
        if (i != null)
            setText(i + "");
        if (j != null)
            setText(j + "");
    }

    public void setText(Double i, Double j) {
        if (i != null)
            setText(i + "");
        if (j != null)
            setText(j + "");
    }

    public void setText(Double i) {
        if (i != null)
            setText(i + "");
    }

    public void setText(Integer i, String j) {
        if (i != null)
            setText(i + "");
        if (j != null)
            setText(j);
    }

    public void setText(String i, String j) {
        if (i != null)
            setText(i);
        if (j != null)
            setText(j);
    }

    public Date getDate() {
        if (getTag() == null)
            return null;
        else {
            return (Date) getTag();
        }
    }

    public int getInt() {
        String str_int = getText().toString().trim();
        if (isNumeric(str_int))
            return Integer.parseInt(str_int);
        else
            return 0;
    }

    public Double getDouble() {

        String str_int = getText().toString().trim();
        if (isNumeric(str_int))
            return Double.parseDouble(str_int);
        else
            return null;
    }

    public boolean isNumeric(String str) {
        return str.matches("-?[0-9]+.*[0-9]*");
    }
}
