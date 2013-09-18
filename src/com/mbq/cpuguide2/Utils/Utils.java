package com.mbq.cpuguide2.Utils;

import com.mbq.cpuguide2.R;

import android.app.Activity;
import android.content.Intent;

public class Utils {
	private static int mTheme;

	public final static int Holo_Light = 0 ;	
	public final static int Holo = 1;
	
	public static void changeToTheme(Activity activity, int theme) {
		
		mTheme = theme;
		
		activity.finish();
		
		activity.startActivity(new Intent(activity, activity.getClass()));
		
	}
	
	public static void onActivityCreateSetTheme(Activity activity) {
		
		switch (mTheme) {
		
		case Holo_Light:
			activity.setTheme(R.style.AppBaseTheme);
			break;	
			
		case Holo:
			activity.setTheme(R.style.Theme_Holo);
			break;						
		}
		
		
	}
}
