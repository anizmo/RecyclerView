package edu.neu.madcourse.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList;
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = new ArrayList<>();

        personAdapter = new PersonAdapter(personList, this);

        RecyclerView peopleRecyclerView = findViewById(R.id.people_recycler_view);

        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        peopleRecyclerView.setAdapter(personAdapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.add_item);

        floatingActionButton.setOnClickListener(view -> {
            addItemToRecyclerView("John Doe", 18);
        });

    }

    private void addItemToRecyclerView(String name, int age) {
        personList.add(new Person(name, age));
        personAdapter.notifyItemInserted(personList.size()-1);
    }

}