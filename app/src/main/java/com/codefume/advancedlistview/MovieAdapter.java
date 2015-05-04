package com.codefume.advancedlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeffschmitz on 5/3/15.
 */
public class MovieAdapter extends ArrayAdapter {

    List _list = new ArrayList();

    public MovieAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler {
        ImageView poster;
        TextView title;
        TextView rating;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        _list.add(object);
    }

    @Override
    public int getCount() {
        return _list.size();
    }

    @Override
    public Object getItem(int position) {
        return this._list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        DataHandler dataHandler;
        if (rowView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = layoutInflater.inflate(R.layout.row_layout, parent, false);
            dataHandler = new DataHandler();
            dataHandler.poster = (ImageView) rowView.findViewById(R.id.movie_poster);
            dataHandler.title = (TextView) rowView.findViewById(R.id.movie_title);
            dataHandler.rating = (TextView) rowView.findViewById(R.id.movie_rating);
            rowView.setTag(dataHandler);
        } else {
            dataHandler = (DataHandler) rowView.getTag();
        }
        MovieDataProvider dataProvider = (MovieDataProvider) this.getItem(position);
        dataHandler.poster.setImageResource(dataProvider.getMovie_poster_resource());
        dataHandler.title.setText(dataProvider.getMovie_title());
        dataHandler.rating.setText(dataProvider.getMovie_rating());

        return rowView;
//        return super.getView(position, convertView, parent);
    }
}












