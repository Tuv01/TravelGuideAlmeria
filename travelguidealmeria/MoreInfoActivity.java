package com.tuv01.travelguidealmeria;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuv01.travelguidealmeria.model.Sites;

import static com.tuv01.travelguidealmeria.model.Config.CATEGORY_ID;

/**
 * Shows more information about the selected item.
 */
public class MoreInfoActivity extends AppCompatActivity {

    /* declare UI */
    ImageView imageView;
    TextView titleNameView, itemNameView, telView, addressView, descView;
    TextView webView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        /* get intent */
        Intent intent = getIntent();
        Sites chosenItem = intent.getParcelableExtra(CATEGORY_ID);

        /* get the logs from intent chosenItem */
        Log.v("my_tag", "sites object received is:" + chosenItem.toString());

        /* set variables */
        final String titleName = chosenItem.getTitleName();
        final String itemName = chosenItem.getItemName();
        final String address = chosenItem.getAddress();
        final String tel = chosenItem.getTel();
        final String web = chosenItem.getWeb();
        final String desc = chosenItem.getDesc();
        final int image = chosenItem.getPhotoId();

        /* Initialize UI */
        titleNameView = findViewById(R.id.detail_title_name);
        titleNameView.setText(titleName);

        itemNameView = findViewById(R.id.detail_item_name);
        itemNameView.setText(itemName);

        addressView = findViewById(R.id.detail_address);
        addressView.setText(address);

        telView = findViewById(R.id.detail_tel);
        if (chosenItem.hasTel()){
            telView.setText(tel);
            telView.setVisibility(View.VISIBLE);
        }else {
            telView.setVisibility(View.GONE);
        }

        webView = findViewById(R.id.detail_web);

        descView = findViewById(R.id.detail_desc);
        descView.setText(desc);

        imageView = findViewById(R.id.detail_image);
        imageView.setImageResource(image);

        /* Set an oncLick listener on the view*/
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickWebUrl(web);
            }
        });

        /* Set an oncLick listener on the view*/
        telView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDialPhoneNumber(tel);
            }
        });

        /* Set an oncLick listener on the view*/
        addressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickShowMap("geo:0,0?q=" + address);
            }
        });

    }

    /* This method send the web url from onclick */
    public void onClickWebUrl(String openUrl) {
        Uri webPage = Uri.parse(openUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW,webPage);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /* This method dial the number tel from onClick */
    public void onClickDialPhoneNumber (String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /* This method get the location address*/
    public void onClickShowMap (String getLocation) {
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(getLocation));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}