package com.tuv01.travelguidealmeria.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.tuv01.travelguidealmeria.R;
import com.tuv01.travelguidealmeria.fragment.BarFragment;
import com.tuv01.travelguidealmeria.fragment.BeachFragment;
import com.tuv01.travelguidealmeria.fragment.DoandSeeFragment;
import com.tuv01.travelguidealmeria.fragment.HotelFragment;
import com.tuv01.travelguidealmeria.fragment.InfoFragment;
import com.tuv01.travelguidealmeria.fragment.RestaurantFragment;
import com.tuv01.travelguidealmeria.model.Sites;

import com.tuv01.travelguidealmeria.PagerActivity;
import com.tuv01.travelguidealmeria.fragment.TabFragment;
import static com.tuv01.travelguidealmeria.model.Config.PAGES_COUNT;

/**
 * {@link PagerAdapter} is a {@link FragmentPagerAdapter}
 * that provides the layout for each list based on a data source
 * which is of {@link Sites}
 */

public class PagerAdapter extends FragmentPagerAdapter {

    /* Declare variable to handle the item's position */
    private String [] tabTitles;

    /**
     * Create a new {@link PagerAdapter} object
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each
     *           fragment's state in the adapter across swipe.
     */
    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        /* Initialize variable with the string resource */
        tabTitles = context.getResources().getStringArray(R.array.categories);
    }

    /**
     * Return the total pages of the {@link PagerActivity}.
     */
    @Override
    public int getCount() {
        return PAGES_COUNT;
    }

    /**
     * Return {@link Fragment} that should be for the given page number.
     * It is display in {@link PagerActivity}
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new InfoFragment();
            case 1:
                return new HotelFragment();
            case 2:
                return new RestaurantFragment();
            case 3:
                return new BarFragment();
            case 4:
                return new BeachFragment();
            case 5:
                return new DoandSeeFragment();
            default:
                return new InfoFragment();
        }
    }

    /**
     * Return {@link TabFragment} that should be for the given page number.
     * It is display in {@link PagerActivity}
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}