package com.plugindemo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView iv = (ImageView) findViewById(R.id.iv);
		Drawable drawable = PluginManager.getInstance(MainApplication.getInstance()).getResourceManager().getDrawableByName("a");
		iv.setBackgroundDrawable(drawable);
		TextView tv = (TextView) findViewById(R.id.tv);
		String str = PluginManager.getInstance(MainApplication.getInstance()).getResourceManager().getStringByName("plugin_test");
		tv.setText(str);
//		int resID = getResources().getIdentifier("a", "drawable", getPackageName()); 
//		iv.setBackgroundResource(resID);
		Log.i("tag11", "str--====="+str);
		
	}

}
