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

        //Instantiate the arraylist
        personList = new ArrayList<>();

        //Adding a new person object to the personList arrayList
        personList.add(new Person("John Doe", 18));

        peopleRecyclerView = findViewById(R.id.people_recycler_view);

        //This defines the way in which the RecyclerView is oriented
        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Associates the adapter with the RecyclerView
        peopleRecyclerView.setAdapter(new PersonAdapter(personList, this));

    }
}