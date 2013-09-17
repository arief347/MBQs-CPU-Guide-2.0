package com.mbq.cpuguide2;

import com.mbq.cpuguide2.MenuDrawerFragments.AndroidTips;
import com.mbq.cpuguide2.MenuDrawerFragments.Governors;
import com.mbq.cpuguide2.MenuDrawerFragments.IOSchedulers;
import com.mbq.cpuguide2.MenuDrawerFragments.Preferences;
import com.mbq.cpuguide2.MenuDrawerFragments.TCPAlgorithms;
import com.mbq.cpuguide2.MenuDrawerFragments.Welcome;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;

import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GuideActivity extends Activity {
	Intent intent;
	
	Toast toast;
   	
	Fragment Welcome = new Welcome();
	Fragment Governors = new Governors();
	Fragment IOSchedulers = new IOSchedulers();
	Fragment TCPAlgorithms = new TCPAlgorithms();
	Fragment AndroidTips = new AndroidTips();
	Fragment Preferences = new Preferences();
	
	TextView textview;
	
    private DrawerLayout mDrawerLayout;
    
    private ListView mDrawerList;
    
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    
    private CharSequence mTitle;
    
	private String[] mCategories;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

		if(!prefs.getBoolean("firstTime", false)) {

            new AlertDialog.Builder(this)
            
            .setMessage("Welcome to version 2.0 of my CPU Guide! " +
            		"I think you'll find it to be much better this time around.")
            
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
           	 
                public void onClick(DialogInterface dialog, int which) { 
                }
            }
		)
    
            .show(); 

		    SharedPreferences.Editor editor = prefs.edit();

		    editor.putBoolean("firstTime", true);
		    editor.commit();

		}
		    
		setContentView(R.layout.menudrawer);

        mTitle = mDrawerTitle = getTitle();
        
        mCategories = getResources().getStringArray(R.array.Items);
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mCategories));
        
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        getActionBar().setHomeButtonEnabled(true);
        
        mDrawerToggle = new ActionBarDrawerToggle(
        		
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close 
                )
        
        { 
        	public void onDrawerClosed(View view) {
            	
                getActionBar().setTitle(mTitle);
                
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                
            }

            public void onDrawerOpened(View drawerView) {
            	
                getActionBar().setTitle(mDrawerTitle);
                
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                
            }
        };
        
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
        	
            selectItem(0);
        }
     } 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.guide, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        
        return super.onPrepareOptionsMenu(menu);
    }    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
		switch (item.getItemId()) {		
		
		case R.id.exit:
			finish();
			break;
             
            default:

       };     

   return super.onOptionsItemSelected(item);
}  

private class DrawerItemClickListener implements ListView.OnItemClickListener {
   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       selectItem(position);
   }
}

private void selectItem(int position) {

   FragmentTransaction ft = getFragmentManager().beginTransaction();
   switch (position) {
   
   case 0:

       ft.replace(R.id.content_frame, Welcome);
       
       break;     
    
    case 1:
        ft.replace(R.id.content_frame, Governors);
        break;     
        
    case 2:
        ft.replace(R.id.content_frame, IOSchedulers);
        break;  
        
    case 3:
        ft.replace(R.id.content_frame, TCPAlgorithms);
        break;    
        
    case 4:
        ft.replace(R.id.content_frame, AndroidTips);
        break;   
        
    case 5:
        ft.replace(R.id.content_frame, Preferences);
        break;         
    	
        }
        
        ft.commit();
        
        mDrawerList.setItemChecked(position, true);

        mDrawerLayout.closeDrawer(mDrawerList);
    }
    
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);
        
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);
        
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public static class CategoriesFragment extends Fragment {

    public static final String ARG_CATEGORY = "category";

    public CategoriesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_categories, container, false);
        
        int i = getArguments().getInt(ARG_CATEGORY);
        
        String List = getResources().getStringArray(R.array.Items)[i];
        
        getActivity().setTitle(List);
        
        return rootView;
        
          }
       }
    }