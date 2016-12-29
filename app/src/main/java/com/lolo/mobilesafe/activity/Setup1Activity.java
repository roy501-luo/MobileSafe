package com.lolo.mobilesafe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lolo.mobilesafe.R;


/**
 * 第一个设置向导页
 * 
 *
 */
public class Setup1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup1);
	}

	// 下一页
	public void next(View view) {
		startActivity(new Intent(this, Setup2Activity.class));
		finish();
		
		//两个界面切换的动画
		overridePendingTransition(R.anim.tran_in, R.anim.tran_out);//进入动画和退出动画
	}
}
