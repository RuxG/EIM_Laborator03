package com.example.phonedialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.List;

public class PhoneDialer extends AppCompatActivity {

    EditText phoneNumber;
    HashMap<Integer, String> buttonsIdMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_land);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        phoneNumber.setText("");
        phoneNumber.setEnabled(false);

        ButtonsListener buttonsListener = new ButtonsListener();
        initKeys(buttonsListener);

    }


    private class ButtonsListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (buttonsIdMap.get(view.getId()).compareTo(Constants.BUTTON_TYPE_DIAL) == 0) {
                phoneNumber.setText(phoneNumber.getText().toString().concat(((Button) view).getText().toString()));
            } else if (buttonsIdMap.get(view.getId()).compareTo(Constants.BUTTON_TYPE_ACCEPT_CALL) == 0) {
                if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(PhoneDialer.this, Manifest.permission.CALL_PHONE)) {
                    ActivityCompat.requestPermissions(
                            PhoneDialer.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            0);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                    startActivity(intent);
                }
            } else if (buttonsIdMap.get(view.getId()).compareTo(Constants.BUTTON_TYPE_HANGUP_CALL) == 0) {
                finish();
            } else if (buttonsIdMap.get(view.getId()).compareTo(Constants.BUTTON_TYPE_BACKSPACE) == 0) {
                String phoneNumberStr = phoneNumber.getText().toString();
                if (phoneNumberStr.length() > 0) {
                    phoneNumber.setText(phoneNumberStr.substring(0, phoneNumberStr.length() - 1));
                }
            }
        }
    }

    private void initKeys(View.OnClickListener buttonsListener) {

        buttonsIdMap = new HashMap<>();
        View view;

        view = (ImageButton) findViewById(R.id.backSpace);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_BACKSPACE);

        view = (View)findViewById(R.id._0);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._1);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._2);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._3);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._4);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._5);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._6);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._7);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._8);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._9);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._asterix);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id._diez);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_DIAL);

        view = (View)findViewById(R.id.acceptCall);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_ACCEPT_CALL);

        view = (View)findViewById(R.id.hangUpCall);
        view.setOnClickListener(buttonsListener);
        buttonsIdMap.put(view.getId(), Constants.BUTTON_TYPE_HANGUP_CALL);

    }
}
