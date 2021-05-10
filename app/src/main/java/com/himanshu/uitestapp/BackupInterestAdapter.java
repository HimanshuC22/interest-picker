package com.himanshu.uitestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BackupInterestAdapter{
    /*public Context context;
    public String[] values;

    BackupInterestAdapter(Context context, String[] textValues)
    {
        this.context = context;
        this.values = textValues;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.textview_item, null);

            // set value into textview
            TextView textView;
            textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(values[position]);
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }*/
}
