package com.codefume.advancedlistview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
    ListView listView;
    int[] movie_poster_resource = {
            R.drawable.movie_1,
            R.drawable.movie_2,
            R.drawable.movie_3,
            R.drawable.movie_4,
            R.drawable.movie_5,
            R.drawable.movie_6,
            R.drawable.movie_7,
            R.drawable.movie_8,
            R.drawable.movie_9,
            R.drawable.movie_10,
    };
    String[] movie_titles;
    String[] movie_ratings;
    MovieAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        movie_ratings = getResources().getStringArray(R.array.movie_ratings);
        movie_titles = getResources().getStringArray(R.array.movie_titles);
        int i = 0;
        adapter = new MovieAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(adapter);
        for (String titles : movie_titles) {
            MovieDataProvider dataProvider = new MovieDataProvider(
                    movie_poster_resource[i],
                    titles,
                    movie_ratings[i]
            );
            adapter.add(dataProvider);
            i++;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
