package com.tuv01.travelguidealmeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This activity displayed information about the location of the QR Code and
 * starts ScanQRcodeActivity if the user wants to scan the code.
 * The location information is obtained using firebase db.
 */
public class GameActivity extends AppCompatActivity {

    public static TextView textViewResult;
    Button scan_btn;

    //Firebase
    TextView textViewLocation;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textViewResult = findViewById(R.id.result_text);
        scan_btn = findViewById(R.id.btn_scanqr);

        //Firebase DB
        textViewLocation = findViewById(R.id.location_text);
        db = FirebaseFirestore.getInstance();
        DocumentReference docRef=db.collection("locations").document("pEKi2xzQfF1pdxkRffrF");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                String[] data= String.valueOf(documentSnapshot.getData()).split("=");
                String location= data[1].replace("}"," ");
                String message="The QR code is located in "+ location;

                textViewLocation.setText(message);
            }
        });

        //Button QR scan.
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ScanQRcodeActivity.class));
            }
        });
    }
}