package com.mbq.cpuguide2.Adapters;

import com.mbq.cpuguide2.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
public class GovernorsListViewAdapter extends BaseAdapter {

    Context context;
    
    String[] governors;
    
    int[] flag;
    
    LayoutInflater inflater;
 
    public GovernorsListViewAdapter(Context context, String[] governors1, int[] flag) {
    	
        this.context = context;
        
        this.governors = governors1;
        
        this.flag = flag;
    }
 
    public int getCount() {
    	
        return governors.length;
    }
 
    public Object getItem(int position) {
    	
        return null;
    }
 
    public long getItemId(int position) {
    	
        return 0;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtOptions;
 
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
        View itemView = inflater.inflate(R.layout.governors_listview_items, parent, false);

        txtOptions = (TextView) itemView.findViewById(R.id.governors);

        txtOptions.setText(governors[position]);
 
        return itemView;
    }
}