package com.example.hnino.biblioapps.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hnino.biblioapps.R;
import com.example.hnino.biblioapps.greendao.App;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by hnino on 22/08/2016.
 */
public class AbsListViewAdapter extends ArrayAdapter<App> {

    private Activity activity;
    private List<App> countries;

    public AbsListViewAdapter(Activity context, int resource, List<App> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.countries = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_abslistview, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        String url = getItem(position).getImage_app().get(2).getUrl();
        Uri uri = Uri.parse(url);
        holder.flag.setImageURI(uri);
        holder.countryName.setText(getItem(position).getName());

        convertView.setOnClickListener(onClickListener(getItem(position), String.valueOf(position + 1)));

        return convertView;
    }

    private View.OnClickListener onClickListener(final App country, final String pos) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        };
    }

    private static class ViewHolder {
        private SimpleDraweeView flag;
        private TextView countryName;

        public ViewHolder(View v) {
            flag = (SimpleDraweeView) v.findViewById(R.id.my_image_view);
            countryName = (TextView) v.findViewById(R.id.country_name);
        }
    }
}