package com.mbq.cpuguide2.Governors;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;

import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;
import com.mbq.cpuguide2.R;
import com.mbq.cpuguide2.Adapters.Governors.BrazilianWaxPagerAdapter;

public class BrazilianWax extends FragmentActivity {

	private final Handler handler = new Handler();

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private BrazilianWaxPagerAdapter adapter;

	private Drawable oldBackground = null;
	private int currentColor = 0xFF666666;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.brazilianwax);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);

		tabs = (PagerSlidingTabStrip) findViewById(R.id.Waxtabs);
		pager = (ViewPager) findViewById(R.id.Waxpager);
		adapter = new BrazilianWaxPagerAdapter(getSupportFragmentManager());

		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
				.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setViewPager(pager);

		changeColor(currentColor);
	}

	private void changeColor(int newColor) {

		tabs.setIndicatorColor(newColor);

		// change ActionBar color just if an ActionBar is available
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

			@SuppressWarnings("unused")
			Drawable colorDrawable = new ColorDrawable(newColor);

			if (oldBackground == null) {

				}
			}


			// http://stackoverflow.com/questions/11002691/actionbar-setbackgrounddrawable-nulling-background-from-thread-handler
			getActionBar().setDisplayShowTitleEnabled(false);
			getActionBar().setDisplayShowTitleEnabled(true);

		}

	public void onColorClicked(View v) {

		int color = Color.parseColor(v.getTag().toString());
		changeColor(color);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("currentColor", currentColor);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		currentColor = savedInstanceState.getInt("currentColor");
		changeColor(currentColor);
	}

	@SuppressWarnings("unused")
	private Drawable.Callback drawableCallback = new Drawable.Callback() {
		@Override
		public void invalidateDrawable(Drawable who) {
			getActionBar().setBackgroundDrawable(who);
		}

		@Override
		public void scheduleDrawable(Drawable who, Runnable what, long when) {
			handler.postAtTime(what, when);
		}

		@Override
		public void unscheduleDrawable(Drawable who, Runnable what) {
			handler.removeCallbacks(what);
		}
	};
}
