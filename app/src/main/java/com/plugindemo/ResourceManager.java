package com.plugindemo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;


public class ResourceManager {

    private static final String DEFTYPE_DRAWABLE = "drawable";
    private static final String DEFTYPE_COLOR = "color";
    private static final String DEFTYPE_DIMEN = "dimen";
    private static final String DEFTYPE_ANIM = "anim";
    private static final String DEFTYPE_STRING = "string";
    
    private Resources mResources;
    private String mPluginPackageName;
 
    
    public ResourceManager(Resources res, String pluginPackageName) {
        this.mResources = res;
        this.mPluginPackageName = pluginPackageName;
    }
    
    public String getStringByName(String name){
    	try {
    		int resId = mResources.getIdentifier(name, DEFTYPE_STRING, mPluginPackageName);
    		return mResources.getString(resId);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
    }
    public Drawable getAnimByName(String name) {
        try {
            int resId = mResources.getIdentifier(name, DEFTYPE_ANIM, mPluginPackageName);
            return mResources.getDrawable(resId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e) {
            //默认
            Resources appResources = MainApplication.getInstance().getResources();
            int resId = appResources.getIdentifier(name, DEFTYPE_ANIM, MainApplication.getInstance().getPackageName());
            return appResources.getDrawable(resId);
        }
    }

    public Drawable getDrawableByName(String name) {
    	Log.i("tag11", "PackageName---"+mPluginPackageName);
        try {
            int resId = mResources.getIdentifier(name, DEFTYPE_DRAWABLE, mPluginPackageName);
            Log.i("tag11", "resId---"+resId);
            return mResources.getDrawable(resId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e) {
            //默认
            Resources appResources = MainApplication.getInstance().getResources();
            int resId = appResources.getIdentifier(name, DEFTYPE_DRAWABLE, MainApplication.getInstance().getPackageName());
            return appResources.getDrawable(resId);
        }
    }
    
    public int getColorByName(String name) {
        try {
            int resId = mResources.getIdentifier(name, DEFTYPE_COLOR, mPluginPackageName);
            return mResources.getColor(resId);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public int getDimenByName(String name) {
        try {
            int resId = mResources.getIdentifier(name, DEFTYPE_DIMEN, mPluginPackageName);
            return mResources.getDimensionPixelSize(resId);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}