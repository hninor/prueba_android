package com.example.hnino.biblioapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, CategoryMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
