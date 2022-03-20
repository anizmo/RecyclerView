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

        // Setup action on the click of the floating action button.
        floatingActionButton.setOnClickListener(view -> {
            addItemToRecyclerView("John Doe", 18);
        });

    }

    /**
     * This method adds a new person to the personList at the end of the list.
     *
     * @param name  name of the person to be added.
     * @param age   age of the person to be added.
     */
    private void addItemToRecyclerView(String name, int age) {
        //Add a new person to the personList array list
        personList.add(new Person(name, age));
        //After adding the new person to the list, we need to notify the recyclerview adapter
        //that a new item is inserted in the arraylist which is used to display the recycler view
        //at the specified position. Since we are adding it at the end of the list, we get the size
        //of the list and subtract 1 for adjusting index starting from 0.
        personAdapter.notifyItemInserted(personList.size() - 1);
    }

}