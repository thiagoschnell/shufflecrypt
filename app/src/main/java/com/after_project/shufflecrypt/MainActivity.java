package com.after_project.shufflecrypt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ShuffleCrypt crypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            crypt = new ShuffleCrypt(99999);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ((Button)findViewById(R.id.crypt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    System.out.println("start time: " + System.currentTimeMillis());

                    String enc = crypt.encryptStringToBase64("my text to encrypt " + getCurrentDateTimeString());

                    String dec = crypt.decryptFromBase64String(enc);

                    System.out.println(dec);
                    System.out.println("end time: " + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    String getCurrentDateTimeString(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date now = new Date(System.currentTimeMillis()+25*24*60*60*1000l);
        return fmt.format(now);
    }
}