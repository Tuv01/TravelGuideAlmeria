package com.tuv01.travelguidealmeria.model;

import android.content.Context;

import com.tuv01.travelguidealmeria.R;
import java.util.ArrayList;

/**
 * Creating a {@link Helper} function Class. It creates the arrays used
 * in the listViews and allows pass through data with parcelable.
 */

public class Helper {

    /**
     * Create a private constructor because no one should ever create a {@link Helper} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name Helper (and an object instance of Helper is not needed).
     */
    private Helper() {
    }

    /**
     *
     * @param context The current context. used to initialize the string arrays.
     * @return return the array list of category grid view.
     */
    public static ArrayList<Sites> getCategory (Context context) {

        String [] category = context.getResources().getStringArray(R.array.categories);
        int [] photoId = new int[]{R.drawable.cat_1, R.drawable.cat_2, R.drawable.cat_3, R.drawable.cat_4,
                R.drawable.cat_5, R.drawable.cat_6};

        ArrayList<Sites> categoryList = new ArrayList<>();
        for (int i = 0; i<6; i++){
            categoryList.add(new Sites(category[i], photoId[i], R.drawable.ic_next));
        }return categoryList;
    }

    /**
     *
     * @param context The current context. used to initialize the string arrays.
     * @return return the array list of info list view.
     */
    public static ArrayList<Sites> getInfo (Context context) {

        String [] titleName = context.getResources().getStringArray(R.array.info_desc);
        String [] itemName = context.getResources().getStringArray(R.array.info_desc_1);
        int [] photoId = new int[]{R.drawable.info_1, R.drawable.info_2, R.drawable.info_3, R.drawable.info_4, R.drawable.info_5};

        ArrayList<Sites> infoList = new ArrayList<>();
        for (int i = 0; i<5; i++){
            infoList.add(new Sites(titleName[i], itemName[i], photoId[i]));
        }return infoList;
    }

    /**
     *
     * @param context The current context. used to initialize the string arrays.
     * @return return the array list of hotel list view.
     */
    public static ArrayList<Sites> getHotel (Context context) {

        String[] titleName = context.getResources().getStringArray(R.array.title_name_1);
        String[] itemName = context.getResources().getStringArray(R.array.item_name_1);
        String[] address = context.getResources().getStringArray(R.array.address_1);
        String[] tel = context.getResources().getStringArray(R.array.tel_1);
        String[] web = context.getResources().getStringArray(R.array.web_1);
        String[] desc = context.getResources().getStringArray(R.array.desc_1);
        int [] photoId = new int[]{R.drawable.hotel_1, R.drawable.hotel_2, R.drawable.hotel_3, R.drawable.hotel_4, R.drawable.hotel_5,
                R.drawable.hotel_6, R.drawable.hotel_7};

        ArrayList<Sites> hotelList = new ArrayList<>();
        for(int i = 0; i<7; i++){
            hotelList.add(new Sites(titleName[i], itemName[i], address[i], tel[i], web[i], desc[i], photoId[i], R.drawable.ic_next));
        }return hotelList;
    }

    /**
     *
     * @param context The current context. used to initialize the string arrays.
     * @return return the array list of restaurant list view.
     */
    public static ArrayList<Sites> getRestaurant (Context context) {

        String[] titleName = context.getResources().getStringArray(R.array.title_name_2);
        String[] itemName = context.getResources().getStringArray(R.array.item_name_2);
        String[] address = context.getResources().getStringArray(R.array.address_2);
        String[] tel = context.getResources().getStringArray(R.array.tel_2);
        String[] web = context.getResources().getStringArray(R.array.web_2);
        String[] desc = context.getResources().getStringArray(R.array.desc_2);
        int [] photoId = new int[]{R.drawable.food_1, R.drawable.food_2, R.drawable.food_3, R.drawable.food_4, R.drawable.food_5,
                R.drawable.food_6};

        ArrayList<Sites> foodList = new ArrayList<>();
        for(int i = 0; i<6; i++){
            foodList.add(new Sites(titleName[i], itemName[i], address[i], tel[i], web[i], desc[i], photoId[i], R.drawable.ic_next));
        }return foodList;
    }

    /**
     *
     * @param context The current context. used to initialize the string arrays.
     * @return return the array list of bar list view.
     */
    public static ArrayList<Sites> getBar (Context context) {

        String[] titleName = context.getResources().getStringArray(R.array.title_name_3);
        String[] itemName = context.getResources().getStringArray(R.array.item_name_3);
        String[] address = context.getResources().getStringArray(R.array.address_3);
        String[] tel = context.getResources().getStringArray(R.array.tel_3);
        String[] web = context.getResources().getStringArray(R.array.web_3);
        String[] desc = context.getResources().getStringArray(R.array.desc_3);
        int [] photoId = new int[]{R.drawable.bar_1, R.drawable.bar_2, R.drawable.bar_3, R.drawable.bar_4, R.drawable.bar_5};

        ArrayList<Sites> barList = new ArrayList<>();
        for(int i = 0; i<5; i++){
            barList.add(new Sites(titleName[i], itemName[i], address[i], tel[i], web[i], desc[i], photoId[i], R.drawable.ic_next));
        }return barList;
    }

    /**
     *
     * @param context The current context. used to initialize the string arrays.
     * @return return the array list of beach list view.
     */
    public static ArrayList<Sites> getBeaches (Context context) {

        String[] titleName = context.getResources().getStringArray(R.array.title_name_4);
        String[] itemName = context.getResources().getStringArray(R.array.item_name_4);
        String[] address = context.getResources().getStringArray(R.array.address_4);
        String[] tel = context.getResources().getStringArray(R.array.tel_4);
        String[] web = context.getResources().getStringArray(R.array.web_4);
        String[] desc = context.getResources().getStringArray(R.array.desc_4);
        int [] photoId = new int[]{R.drawable.beach_1, R.drawable.beach_2, R.drawable.beach_3, R.drawable.beach_4,
                R.drawable.beach_5};

        ArrayList<Sites> eventsList = new ArrayList<>();
        for(int i = 0; i<5; i++){
            eventsList.add(new Sites(titleName[i], itemName[i], address[i], tel[i], web[i], desc[i], photoId[i], R.drawable.ic_next));
        }return eventsList;
    }

    /**
     *
     * @param context The current context. used to initialize the string arrays.
     * @return return the array list of places list view.
     */
    public static ArrayList<Sites> getPlaces (Context context) {

        String[] titleName = context.getResources().getStringArray(R.array.title_name_5);
        String[] itemName = context.getResources().getStringArray(R.array.item_name_5);
        String[] address = context.getResources().getStringArray(R.array.address_5);
        String[] tel = context.getResources().getStringArray(R.array.tel_5);
        String[] web = context.getResources().getStringArray(R.array.web_5);
        String[] desc = context.getResources().getStringArray(R.array.desc_5);
        int [] photoId = new int[]{R.drawable.places_1, R.drawable.places_2, R.drawable.places_3, R.drawable.places_4,
                R.drawable.places_5, R.drawable.places_6};

        ArrayList<Sites> placesList = new ArrayList<>();
        for(int i = 0; i<6; i++){
            placesList.add(new Sites(titleName[i], itemName[i], address[i], tel[i], web[i], desc[i], photoId[i], R.drawable.ic_next));
        }return placesList;
    }
}