package com.tuv01.travelguidealmeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
/**
 * This class displayed a list of coupon if the code is correct using firebase db.
 */

public class CouponActivity extends AppCompatActivity {

    ImageView coupon1,coupon2,coupon3,coupon4,coupon5;
    ImageButton btnCode;
    String code;

    //Firebase
    EditText couponCode;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        Toolbar toolbar = findViewById(R.id.toolbar);
        couponCode = findViewById(R.id.etPassword);
        btnCode = findViewById(R.id.btn_code);
        final ImageView coupon1 = findViewById(R.id.coupon1);
        final ImageView coupon2 = findViewById(R.id.coupon2);
        final ImageView coupon3 = findViewById(R.id.coupon3);
        final ImageView coupon4 = findViewById(R.id.coupon4);
        final ImageView coupon5 = findViewById(R.id.coupon5);
        coupon1.setVisibility(View.INVISIBLE);
        coupon2.setVisibility(View.INVISIBLE);
        coupon3.setVisibility(View.INVISIBLE);
        coupon4.setVisibility(View.INVISIBLE);
        coupon5.setVisibility(View.INVISIBLE);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codeInserted=couponCode.getText().toString();

                //Firebase db
                db = FirebaseFirestore.getInstance();
                DocumentReference docRef=db.collection("codes").document("f76zVteKih8xMBLaXJoL");
                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        String[] data= String.valueOf(documentSnapshot.getData()).split("=");
                        code= data[1].replace("}",""); //coupon access code from Firebase db.
                    }
                });

                if(codeInserted.equalsIgnoreCase(code)){
                    coupon1.setVisibility(View.VISIBLE);
                    coupon2.setVisibility(View.VISIBLE);
                    coupon3.setVisibility(View.VISIBLE);
                    coupon4.setVisibility(View.VISIBLE);
                    coupon5.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong code", Toast.LENGTH_LONG).show();
                }
            }
        });
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