package com.example.aircraftwar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyExpandableListAdpter extends BaseExpandableListAdapter {
    public String[] groups = {"我的好友","家人","同事","黑名单"};
    public String[][] children = {{"王长春","王春生","王倩倩"},{"王达","王盼盼"},{"张佳琪","张琪"},{"水电费了","收代理费"}};
    private Context context = null;
    public MyExpandableListAdpter(Context context){
        this.context = context;
    }
    @Override
    public Object getChild(int groupPosition,int childPosition){
        return this.children[groupPosition][childPosition];
    }
    @Override
    public long getChildId(int groupPosition, int childPosition){
        return childPosition;
    }
    @SuppressLint("ResourceType")
    public TextView buildTextView(){
        AbsListView.LayoutParams param = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 35);
        TextView textView = new TextView(this.context);
        textView.setLayoutParams(param);
        textView.setGravity(Gravity.LEFT);
        textView.setPadding(40, 8, 3, 3);
        return textView;
    }
    @Override
    public View getChildView(int groudPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
        TextView textView = buildTextView();
        textView.setText(getChild(groudPosition, childPosition).toString());
        return textView;
    }
    @Override
    public int getChildrenCount(int groupPosition){
        return this.children[groupPosition].length;
    }
    @Override
    public Object getGroup(int groupPosition){
        return this.groups[groupPosition];
    }
    @Override
    public int getGroupCount(){
        return this.groups.length;
    }
    @Override
    public long getGroupId(int groupPosition){
        return groupPosition;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){
        TextView textView = buildTextView();
        textView.setText(this.getGroup(groupPosition).toString());
        return textView;
    }
    @Override
    public boolean hasStableIds(){
        return true;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition){
        return true;
    }
}
