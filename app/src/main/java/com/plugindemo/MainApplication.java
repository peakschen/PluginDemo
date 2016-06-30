package com.plugindemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

public class MainApplication extends Application {
	
	private static MainApplication instance;
	public static MainApplication getInstance() {
        return instance;
    }
	@Override
	public void onCreate() {
		super.onCreate();
		String pluginPath = Environment.getExternalStorageDirectory()+File.separator+"app-release.apk";
		try {
			PluginManager.getInstance(this).loadPlugin(pluginPath);
			Log.i("tag11", "pluginPath---"+pluginPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    private byte[] InputStreamToByte(InputStream is) throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1) {
            bytestream.write(ch);
        }
        byte imgdata[] = bytestream.toByteArray();
        bytestream.close();
        return imgdata;
    }
}
