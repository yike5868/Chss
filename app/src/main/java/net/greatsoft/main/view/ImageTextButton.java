package net.greatsoft.main.view;

/**
 * Created by zhanglin on 2016/11/26.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.greatsoft.main.R;

public class ImageTextButton extends RelativeLayout {

    private ImageView imgView;
    private TextView textView;

    public ImageTextButton(Context context) {
        super(context, null);
    }

    public ImageTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);


        TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.ImageTextButton);
        String text = a.getString(R.styleable.ImageTextButton_text);

        String type = a.getString(R.styleable.ImageTextButton_type);
        if (type == null || "".equals(type))
            LayoutInflater.from(context).inflate(R.layout.image_text_button, this, true);
        else
            LayoutInflater.from(context).inflate(R.layout.image_left_text_button, this, true);
        int i = a.getResourceId(R.styleable.ImageTextButton_image, R.mipmap.ic_launcher);
        this.imgView = (ImageView) findViewById(R.id.imgview);
        this.textView = (TextView) findViewById(R.id.textview);
        setImgResource(i);
        setText(text);

        this.setClickable(true);
        this.setFocusable(true);
    }

    public void setImgResource(int resourceID) {
        this.imgView.setImageResource(resourceID);
    }

    public void setText(String text) {
        this.textView.setText(text);
    }

    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public void setTextSize(float size) {
        this.textView.setTextSize(size);
    }

}