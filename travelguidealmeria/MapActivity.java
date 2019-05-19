package com.tuv01.travelguidealmeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.github.chrisbanes.photoview.PhotoView;

/**
 * Displays a tourist map of the city with options zoom in and zoom out.
 */
public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //add PhotoView zoom in/out
        PhotoView photoView1 = findViewById(R.id.photo_view1);
        photoView1.setImageResource(R.drawable.map_almeria);
        PhotoView photoView2 = findViewById(R.id.photo_view2);
        photoView2.setImageResource(R.drawable.map_almeria2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}