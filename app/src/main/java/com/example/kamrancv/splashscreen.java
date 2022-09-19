package com.example.kamrancv;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SystemClock.sleep(100);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
