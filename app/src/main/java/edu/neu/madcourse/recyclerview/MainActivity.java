package edu.neu.madcourse.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList;
    private PersonAdapter personAdapter;
    private RecyclerView peopleRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = new ArrayList<>();

        personAdapter = new PersonAdapter(personList, this);

        peopleRecyclerView = findViewById(R.id.people_recycler_view);

        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        peopleRecyclerView.setAdapter(personAdapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.add_item);

        //Setup action on the click of the floating action button.
        floatingActionButton.setOnClickListener(view -> {
            addItemToRecyclerView("John Doe", 18);
        });

        setupSwipeToDelete();

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
        personAdapter.notifyItemInserted(personList.size()-1);
    }

    /**
     * Setup a swipe to delete and attach it to the recyclerview
     *
     */
    private void setupSwipeToDelete() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT,
                ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                // this method is called when the item is moved.
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // this method is called when item is swiped,
                // below line is to remove item from our array list.
                personList.remove(viewHolder.getAdapterPosition());

                // Notify the adapter that the swiped item is removed from the array list.
                personAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                Snackbar.make(peopleRecyclerView, "Item Deleted", Snackbar.LENGTH_SHORT).show();
            }

        }).attachToRecyclerView(peopleRecyclerView);
    }

}