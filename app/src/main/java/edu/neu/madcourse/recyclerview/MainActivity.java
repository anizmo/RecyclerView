package edu.neu.madcourse.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2 Buttons, one to navigate to each activity
        Button recyclerViewButton = findViewById(R.id.buttonRecyclerView);
        Button userInputButton = findViewById(R.id.buttonUserInput);

        recyclerViewButton.setOnClickListener(view -> {
            // Open Recyclerview activity : This example shows how to make a simple recyclerview.
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(intent);
        });

        userInputButton.setOnClickListener(view -> {
            // Open User Input Activity : This example shows how to take input from the end-user
            Intent intent = new Intent(MainActivity.this, UserInputActivity.class);
            startActivity(intent);
        });

    }
}