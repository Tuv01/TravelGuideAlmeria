package com.tuv01.travelguidealmeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Displays a list of events obtained through firebase db.
 */
public class EventActivity extends AppCompatActivity {

    public static TextView txtEvent1,txtEvent2,txtEvent3,txtEvent4;

    //Firebase
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        txtEvent1 = findViewById(R.id.txtevent1);
        txtEvent2 = findViewById(R.id.txtevent2);
        txtEvent3 = findViewById(R.id.txtevent3);
        txtEvent4 = findViewById(R.id.txtevent4);

        //Firebase DB

        db = FirebaseFirestore.getInstance();

        DocumentReference docRef=db.collection("events").document("T4rfS5ql8TyquvLS1qiA");

        /**
         * Sets the information obtained through firebase into the TextViews
         */
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                String[] data= String.valueOf(documentSnapshot.getData()).split("=");

                //txtEvent1.setText(data[1].replace("}"," "));
                txtEvent1.setText(data[1].replace(", event4",""));
                txtEvent2.setText(data[2].replace(", event3",""));
                txtEvent3.setText(data[3].replace(", event2",""));
                txtEvent4.setText(data[4].replace("}",""));
            }
        });
    }
}