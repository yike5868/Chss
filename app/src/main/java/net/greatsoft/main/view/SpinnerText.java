package net.greatsoft.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import net.greatsoft.main.R;


public class SpinnerText extends RelativeLayout implements OnClickListener {

	private View mSpinnerText;

	private Context mContext;

	private TextView mDefText;

	private Spinner mSpinner;

	public SpinnerText(Context context, AttributeSet attrs) {
		super(context, attrs);

		mContext = context;

		mSpinnerText = LayoutInflater.from(context).inflate(
				R.layout.fu_view_spinner_text, this, true);

		mDefText = (TextView) mSpinnerText
				.findViewById(R.id.jkx_spinner_text_def);

		mSpinner = (Spinner) mSpinnerText.findViewById(R.id.spinner);

		TypedArray lArray = context.obtainStyledAttributes(attrs,
				R.styleable.SpinnerText);

		CharSequence lText = lArray.getText(R.styleable.SpinnerText_hint);
		CharSequence[] lArrayText =  lArray
				.getTextArray(R.styleable.SpinnerText_string_array);

		setTextViewDes(lText);
		setSpinnerData(lArrayText);
	}

	private void setTextViewDes(CharSequence lText) {

		if (lText == null) {
			return;
		}
		mDefText.setText(lText);
		mDefText.setVisibility(View.VISIBLE);
		mSpinner.setVisibility(View.GONE);
		mDefText.setOnClickListener(this);
	}

	public void setSpinnerDes(int des) {

		mDefText.setVisibility(View.GONE);
		mSpinner.setVisibility(View.VISIBLE);
		mSpinner.setSelection(des - 1, true);
	}

	private void setSpinnerData(CharSequence[] stringArray) {

		MyAdapter adapter = new MyAdapter(mContext, stringArray);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(adapter);
	}

	public int getCurrentSpinnerPos() {

		if (mSpinner.getVisibility() == View.GONE) {

			return 0;
		}

		return mSpinner.getSelectedItemPosition()+1;
	}

	@Override
	public void onClick(View v) {

		mDefText.setVisibility(View.GONE);
		mSpinner.setVisibility(View.VISIBLE);

		mSpinner.performClick();
	}

	class MyAdapter extends ArrayAdapter<CharSequence> {

		private Context mContext;

		private CharSequence[] mStringArray;

		public MyAdapter(Context context, CharSequence[] stringArray) {
			super(context, R.layout.msimple_spinner_item, stringArray);
			mContext = context;
			mStringArray = stringArray;
		}

		@Override
		public View getDropDownView(int position, View convertView,
				ViewGroup parent) {
			// 修改Spinner展开后的字体颜色
			if (convertView == null) {
				LayoutInflater inflater = LayoutInflater.from(mContext);
				convertView = inflater.inflate(
						android.R.layout.simple_spinner_dropdown_item, parent,
						false);
			}

			// 此处text1是Spinner默认的用来显示文字的TextView
			TextView tv = (TextView) convertView
					.findViewById(android.R.id.text1);
			tv.setText(mStringArray[position]);
			tv.setTag((position + 1) + "");
			tv.setTextSize(14f);

			return convertView;

		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// 修改Spinner选择后结果的字体颜色
			if (convertView == null) {
				LayoutInflater inflater = LayoutInflater.from(mContext);
				convertView = inflater.inflate(
						R.layout.msimple_spinner_item, parent, false);
			}

			// 此处text1是Spinner默认的用来显示文字的TextView
			TextView tv = (TextView) convertView
					.findViewById(android.R.id.text1);
			tv.setText(mStringArray[position]);
			tv.setTextSize(14f);
			tv.setGravity(Gravity.RIGHT);
			tv.setTextColor(0xff49ABD7);
			return convertView;
		}

	}

}
