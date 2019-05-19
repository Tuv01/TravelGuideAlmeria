package com.tuv01.travelguidealmeria;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.tuv01.travelguidealmeria.adapter.GridAdapter;
import com.tuv01.travelguidealmeria.model.Helper;

import static com.tuv01.travelguidealmeria.model.Config.TAB_SELECT;

/**
 * Grid Menu
 */
public class MainActivity extends AppCompatActivity {

    /* Declare global variable */
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Create {@link Places} a gridView
        the data source is a list of object from the ArrayList.
        */
        GridAdapter adapter = new GridAdapter(this, Helper.getCategory(getApplicationContext()));
        gridView = findViewById(R.id.grid_container);
        gridView.setAdapter(adapter);

        /* Create an intent to handle onItemClick position and send it to PagerActivity */
        final Intent intent = new Intent(MainActivity.this, PagerActivity.class);

        /* Bind the abstract method to the gridView and gives parameters to its interface */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent.putExtra(TAB_SELECT,0); // InfoFragment
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra(TAB_SELECT,1); // HotelFragment
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra(TAB_SELECT, 2); // RestaurantFragment
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra(TAB_SELECT, 3); // BarFragment
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra(TAB_SELECT, 4); // BeachFragment
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra(TAB_SELECT, 5); // DoandSeeFragment
                        startActivity(intent);
                        break;
                    default:
                        intent.putExtra(TAB_SELECT, 0); // InfoFragment
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}