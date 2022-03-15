package edu.neu.madcourse.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView peopleRecyclerView;

    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = new ArrayList<>();

        personList.add(new Person("John Doe", 18));

        peopleRecyclerView = findViewById(R.id.people_recycler_view);

        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        peopleRecyclerView.setAdapter(new PersonAdapter(personList, this));

    }
}