package com.lolo.mobilesafe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.lolo.mobilesafe.R;
import com.lolo.mobilesafe.db.dao.AddressDao;

/**
 * 归属地查询页面
 * 
 *
 */
public class AddressActivity extends Activity {

	private EditText etNumber;
	private TextView tvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_address);
		etNumber = (EditText) findViewById(R.id.et_number);
		tvResult = (TextView) findViewById(R.id.tv_result);

		// 监听EditText的变化
		etNumber.addTextChangedListener(new TextWatcher() {

			// 文字 发生变化时的回调
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String address = AddressDao.getAddress(s.toString());
				tvResult.setText(address);
			}

			// 文字变化前的回调
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			// 文字变化结束之后的回调
			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

	/**
	 * 开始查询
	 * 
	 */
	public void query(View view) {
		String number = etNumber.getText().toString().trim();

		if (!TextUtils.isEmpty(number)) {
			String address = AddressDao.getAddress(number);
			tvResult.setText(address);
		} else {
			Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
//			插补器，拷贝自Android源码

			// shake.setInterpolator(new Interpolator() {
			//
			// @Override
			// public float getInterpolation(float x) {
			// //y=ax+b
			// int y=0;
			// return y;
			// }
			// });

			etNumber.startAnimation(shake);
			vibrate();
		}
	}

	/**
	 * 手机震动, 需要权限 android.permission.VIBRATE
	 */
	private void vibrate() {
		Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		// vibrator.vibrate(2000);震动两秒
		vibrator.vibrate(new long[] { 1000, 2000, 1000, 3000 }, -1);// 先等待1秒,再震动2秒,再等待1秒,再震动3秒,
																	// 参2等于-1表示只执行一次,不循环,
																	// 参2等于0表示从头循环,
																	// 参2表示从第几个位置开始循环
		// 取消震动vibrator.cancel()
	}
}
