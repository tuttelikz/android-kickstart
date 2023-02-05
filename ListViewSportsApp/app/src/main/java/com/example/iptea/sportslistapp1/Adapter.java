package com.example.iptea.sportslistapp1;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iptea on 12/10/2017.
 */

public class Adapter extends ArrayAdapter <String> {

    String[] names;
    int[] icons;
    Context context;

    public Adapter(@NonNull Context context, String[] sportNames, int[] sportIcons) {
        super(context, R.layout.listview_item);
        this.names = sportNames;
        this.icons = sportIcons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder mViewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item,parent,false);

            mViewHolder.mText = (TextView)convertView.findViewById(R.id.textView);
            mViewHolder.mImage = (ImageView)convertView.findViewById(R.id.imageView);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }

        mViewHolder.mText.setText(names[position]);
        mViewHolder.mImage.setImageResource(icons[position]);

        return convertView;
    }

    static class ViewHolder {
        TextView mText;
        ImageView mImage;
    }

}
