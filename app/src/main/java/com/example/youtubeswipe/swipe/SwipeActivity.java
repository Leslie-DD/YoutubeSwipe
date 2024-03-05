package com.example.youtubeswipe.swipe;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeswipe.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MySwipeHelper swipeHelper = new MySwipeHelper(SwipeActivity.this, recyclerView, 300) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buffer) {
                buffer.add(new MyButton(SwipeActivity.this,
                        "Delete",
                        60,
                        0,
                        Color.parseColor("#FF9502"),
                        pos -> Toast.makeText(SwipeActivity.this, "Delete click", Toast.LENGTH_SHORT).show()));
                buffer.add(new MyButton(SwipeActivity.this,
                        "Favor",
                        30,
                        R.drawable.ic_favor,
                        Color.parseColor("#FF3C30"),
                        pos -> Toast.makeText(SwipeActivity.this, "Favor click", Toast.LENGTH_SHORT).show()));
            }
        };
        generateItem();
    }

    private void generateItem() {
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            itemList.add(new Item("Pie 0" + (++i),
                    "100.000$",
                    "https://www.jinyongwang.net/public/uploads/2015-07-28/55b74f3eca494_175_250.jpg"));

        }
        adapter = new SwipeAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
    }
}