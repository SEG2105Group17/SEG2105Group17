package com.example.fall2021profejct1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

//Copied from Firbase slides!

public class AdminCreateClass extends ArrayAdapter<ClassClass> {
    private Activity context;
    List<ClassClass> classes;

    public AdminCreateClass(Activity context, List<ClassClass> classes){
        super(context, R.layout.adminlogin_activity, classes);
        this.context = context;
        this.classes = classes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.adminlogin_activity, null, true);

        TextView adminAddClassTextView = (TextView) listViewItem.findViewById(R.id.adminAddClassTextView);

        ClassClass Class = classes.get(position);
        adminAddClassTextView.setText(Class.getName());

        return listViewItem;
    }
}
