package net.greatsoft.main.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RadioButton;

import net.greatsoft.main.R;

/**
 * Created by zhanglin on 2016/11/26.
 */

public class FuRadioButton extends RadioButton {
    public FuRadioButton(Context context) {
        super(context);
        setSize();
    }

    public FuRadioButton(Context context, AttributeSet attrs) {

        super(context,attrs);
        setSize();
    }

    public FuRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSize();
    }
    public void setSize(){
//        Resources r = getResources();
//        float size = r.getDimension(R.dimen.check_small);
//        setTextSize(size);
    }
}
