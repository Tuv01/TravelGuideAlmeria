package com.tuv01.travelguidealmeria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
/**
 * QR reader
 */
public class ScanQRcodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    ZXingScannerView ScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);
    }

    @Override
    public void handleResult(Result rawResult) {

        GameActivity.textViewResult.setText(rawResult.getText()); //set the QrCode txt to the txtView in GameActivity.
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        ScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }
}