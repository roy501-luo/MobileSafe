package com.lolo.mobilesafe.view;

import android.content.Context;
import android.net.LocalSocketAddress;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lolo.mobilesafe.R;

/**
 * 自定义布局
 * Created by Administrator on 2016/12/11.
 */

public class SettingItemView extends RelativeLayout {

    private TextView tvTitle;
    private TextView tvDesc;
    private CheckBox cbStatus;
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.lolo.mobilesafe";
    private String mDescoff;
    private String mDescon;
    private String mTitle;

    public SettingItemView(Context context) {
        super(context);
        iniView();
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniView();
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTitle = attrs.getAttributeValue(NAMESPACE, "title");
        mDescon = attrs.getAttributeValue(NAMESPACE, "desc_on");
        mDescoff = attrs.getAttributeValue(NAMESPACE, "desc_off");

        iniView();
//        获取该属性的数量
        int attributeCount = attrs.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attrs.getAttributeName(i);
            String attributeValue = attrs.getAttributeValue(i);
            System.out.println("attributeName" + "=" + attributeValue);
        }

    }

    //初始化布局
    private void iniView() {
//        将自定义好的布局文件设置给当前的SettingItemView
        View.inflate(getContext(), R.layout.view_setting_item, this);

        tvTitle = (TextView) findViewById(R.id.tv_title);//根据属性名称获取属性的值
        tvDesc = (TextView) findViewById(R.id.tv_desc);
        cbStatus = (CheckBox) findViewById(R.id.cb_status);

        setTitle(mTitle);

    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setDesc(String desc) {
        tvDesc.setText(desc);
    }

    /*
    * 返回勾选状态
    *
    * */
    public boolean isChecked() {
        return cbStatus.isChecked();
    }

    public void setChecked(boolean check) {
        cbStatus.setChecked(check);
//        根据选择的状态，更新文本的描述
        if (check) {
            setDesc(mDescon);
        } else {
            setDesc(mDescoff);
        }
    }

}
