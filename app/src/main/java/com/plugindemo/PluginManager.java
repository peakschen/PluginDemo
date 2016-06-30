package com.plugindemo;

import java.lang.reflect.Method;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;


public class PluginManager {
	private Context mContext;
	private Resources mResources;
	private static PluginManager instanceManager;
	private ResourceManager mResourceManager;

	public static PluginManager getInstance(Context context){
		if(instanceManager == null){
			synchronized (PluginManager.class) {
				if(instanceManager == null){
					instanceManager = new PluginManager(context);
				}
			}
		}
		return instanceManager;
	}
	
	private PluginManager(Context context){
		this.mContext = context;
	}
	
	public void loadPlugin(String pluginPath) throws Exception {
        AssetManager assetManager = AssetManager.class.newInstance();
        Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
        addAssetPath.invoke(assetManager, pluginPath);

        Resources superRes = mContext.getResources();
        mResources = new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
        mResourceManager = new ResourceManager(mResources, "com.plugintest");
        
    }
	
	public Resources getResources(){
		return mResources;
	}
	
	public ResourceManager getResourceManager() {
		Log.i("tag11", "mResourceManager----"+mResourceManager);
		if(null == mResourceManager){
			mResourceManager = new ResourceManager(mContext.getResources(), mContext.getPackageName());
		}
        return this.mResourceManager;
    }
	
}
