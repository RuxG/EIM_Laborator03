package com.example.phonedialer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhoneDialer extends AppCompatActivity {

    List<Button> keys;
    EditText phoneNumber;
    ImageButton backSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        phoneNumber.setText("");

        backSpace = (ImageButton) findViewById(R.id.backSpace);
        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumberStr = phoneNumber.getText().toString();
                if (phoneNumberStr.length() > 0) {
                    phoneNumber.setText(phoneNumberStr.substring(0, phoneNumberStr.length() - 1));
                }
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber.setText(phoneNumber.getText().toString().concat(((Button) view).getText().toString()));
            }
        };

        keys = new ArrayList<>();
        initKeys(listener);


    }

    private void initKeys(View.OnClickListener listener) {

        Button key_0 = findViewById(R.id._0);
        key_0.setOnClickListener(listener);
        keys.add(key_0);

        Button key_1 = findViewById(R.id._1);
        key_1.setOnClickListener(listener);
        keys.add(key_1);

        Button key_2 = findViewById(R.id._2);
        key_2.setOnClickListener(listener);
        keys.add(key_2);

        Button key_3 = findViewById(R.id._3);
        key_3.setOnClickListener(listener);
        keys.add(key_3);

        Button key_4 = findViewById(R.id._4);
        key_4.setOnClickListener(listener);
        keys.add(key_4);

        Button key_5 = findViewById(R.id._5);
        key_5.setOnClickListener(listener);
        keys.add(key_5);

        Button key_6 = findViewById(R.id._6);
        key_6.setOnClickListener(listener);
        keys.add(key_6);

        Button key_7 = findViewById(R.id._7);
        key_7.setOnClickListener(listener);
        keys.add(key_7);

        Button key_8 = findViewById(R.id._8);
        key_8.setOnClickListener(listener);
        keys.add(key_8);

        Button key_9 = findViewById(R.id._9);
        key_9.setOnClickListener(listener);
        keys.add(key_9);

        Button key_asterix = findViewById(R.id._asterix);
        key_asterix.setOnClickListener(listener);
        keys.add(key_asterix);

        Button key_diez = findViewById(R.id._diez);
        key_diez.setOnClickListener(listener);
        keys.add(key_diez);
    }
}
