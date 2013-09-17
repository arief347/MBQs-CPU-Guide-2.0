package com.mbq.cpuguide2.Governors.Definitions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbq.cpuguide2.R;

public class BrazilianWaxDefinition extends Fragment {
	
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
		  
	    final View view = inflater.inflate(R.layout.brazilianwax, container, false);
	    setHasOptionsMenu(true);
	    
		return view;
		
	  }
}