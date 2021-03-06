package com.tuv01.travelguidealmeria.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tuv01.travelguidealmeria.MoreInfoActivity;
import com.tuv01.travelguidealmeria.R;
import com.tuv01.travelguidealmeria.adapter.ListAdapter;
import com.tuv01.travelguidealmeria.model.Config;
import com.tuv01.travelguidealmeria.model.Helper;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeachFragment extends Fragment {

    public BeachFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_pager, container, false);

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list
        ListAdapter listAdapter = new ListAdapter(getActivity(), Helper.getBeaches(getContext()));

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_main xml layout file.
        ListView listView = rootView.findViewById(R.id.view_pager_activity);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        listView.setAdapter(listAdapter);

        // Set an listener on each item in the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), MoreInfoActivity.class);
                i.putExtra(Config.CATEGORY_ID, Helper.getBeaches(getContext()).get(position));
                startActivity(i);
            }
        });

        return rootView;

    }
}