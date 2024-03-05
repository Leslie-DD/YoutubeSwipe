package com.example.youtubeswipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youtubeswipe.swipe.SwipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button swipeButton = findViewById(R.id.swipe);
        swipeButton.setOnClickListener(view -> startActivity(new Intent(this, SwipeActivity.class)));
    }

}