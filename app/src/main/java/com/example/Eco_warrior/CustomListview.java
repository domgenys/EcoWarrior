package com.example.Eco_warrior;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListview extends ArrayAdapter<String> {


    private String[] recycleName;
    private String[] logoDesc;
    private Integer[] logoId;
    private Activity context;


    public CustomListview(Activity context, String[] recycleName,String[] logoDesc, Integer[] logoId) {
        super(context, R.layout.row_layout, recycleName);

        this.context = context;
        this.recycleName = recycleName;
        this.logoDesc = logoDesc;
        this.logoId = logoId;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder = null;
        if(r == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.row_layout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)r.getTag();
        }
        viewHolder.imgview.setImageResource(logoId[position]);
        viewHolder.txtview1.setText(recycleName[position]);
        viewHolder.txtview2.setText(logoDesc[position]);
        return r;


    }
    class ViewHolder{
        TextView txtview1;
        TextView txtview2;
        ImageView imgview;
        ViewHolder(View v){
            txtview1= (TextView) v.findViewById(R.id.tvName);
            txtview2= (TextView) v.findViewById(R.id.tvDesc);
            imgview= (ImageView) v.findViewById(R.id.imageView2);


        }

    }
}
