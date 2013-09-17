package com.mbq.cpuguide2.Adapters.Governors;

import com.mbq.cpuguide2.Governors.Definitions.BrazilianWaxDefinition;
import com.mbq.cpuguide2.Governors.Usage.BrazilianWaxUsage;

import android.support.v4.app.FragmentPagerAdapter;
import android.view.MenuItem;
 
public class BrazilianWaxPagerAdapter extends FragmentPagerAdapter {
	
	MenuItem menu;

	private final String[] TITLES = { 
			"Definition", 
			"Usage" 
			};

	public BrazilianWaxPagerAdapter(android.support.v4.app.FragmentManager fm) {
		super(fm);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return TITLES[position];
		
	}

	@Override
	public int getCount() {
		return TITLES.length;
	}

	@Override
	public android.support.v4.app.Fragment getItem(int position) {
		switch (position) {
        case 0:
            BrazilianWaxDefinition ondemand = new BrazilianWaxDefinition();
            return ondemand;

        case 1:
            BrazilianWaxUsage ondemandusage = new BrazilianWaxUsage();
            return ondemandusage;                   	
		}
		
		return null;
		
		}
}