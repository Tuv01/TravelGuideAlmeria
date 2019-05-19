package com.tuv01.travelguidealmeria.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuv01.travelguidealmeria.R;
import com.tuv01.travelguidealmeria.model.Sites;

import java.util.ArrayList;

/**
 * {@link GridAdapter} is an {@link ArrayAdapter} that provides
 * the layout for each list based on data source {@link Sites} object.
 */

public class GridAdapter extends ArrayAdapter<Sites> {

    /**This is a custom constructor.
     * The context is used to inflate the layout file.
     * The list is the data we want to populate into the list
     * @param context The current context. Used to inflate the layout.
     * @param itemList A list of Sites object to display in a list
     */

    public GridAdapter(Activity context, ArrayList<Sites> itemList) {
        super(context, 0, itemList);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView)
     * @param position The position in the list of data that should be displayed.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, @Nullable ViewGroup parent) {
        /* Check if the existing view is being reused, otherwise inflate the view */
        View gridView = convertView;
        if(gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item, parent, false);
        }

        /* Get {@link Sites} object located at this position in the list */
        Sites currentList = getItem(position);

        /* Find the TextView, get and set the text from the current titleName object */
        TextView titleName = gridView.findViewById(R.id.title);
        if (currentList != null) {
            titleName.setText(currentList.getTitleName());
        }

        /* Find the ImageView, get and set the image from the current drawable object */
        ImageView drawablePicId = gridView.findViewById(R.id.image);
        if (currentList != null) {
            drawablePicId.setImageResource(currentList.getPhotoId());
        }

        /* Find the ImageView, get and set the image from the current drawable object */
        ImageView drawableIconId = gridView.findViewById(R.id.icon);
        if (currentList != null) {
            drawableIconId.setImageResource(currentList.getIconId());
        }

        /* Return the whole list item layout */
        return gridView;
    }
}