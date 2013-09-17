package com.mbq.cpuguide2.MenuDrawerFragments;

import com.mbq.cpuguide2.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Welcome extends Fragment {
	
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
		  
	    final View view = inflater.inflate(R.layout.welcome, container, false);
	    
		return view;
		
	  }
}
