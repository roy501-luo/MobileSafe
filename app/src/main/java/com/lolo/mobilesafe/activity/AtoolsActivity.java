package com.lolo.mobilesafe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lolo.mobilesafe.R;

/**
 * 高级工具
 * 
 *
 */
public class AToolsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_atools);
	}

	/**
	 * 归属地查询
	 * 
	 */
	public void numberAddressQuery(View view) {
		startActivity(new Intent(this, AddressActivity.class));
	}

}
