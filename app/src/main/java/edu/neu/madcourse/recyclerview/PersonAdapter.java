package edu.neu.madcourse.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * This is a recyclerview adapter class, the purpose of this class is to act as a bridge between the
 * collection (arraylist) and the view (recyclerview). This class provides 3 methods that are
 * utilised for binding the data to the view. The explanation of each method is provided in comments
 * within the methods.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final List<Person> people;
    private final Context context;
    private final CallbackInterface callback;

    /**
     * Creates a PersonAdapter with the provided arraylist of Person objects.
     *
     * @param people    arraylist of person object.
     * @param context   context of the activity used for inflating layout of the viewholder.
     * @param callback  instance of the callback interface used to interact with the activity which
     *                  has the recyclerview.
     */
    public PersonAdapter(List<Person> people, Context context, CallbackInterface callback) {
        this.people = people;
        this.context = context;
        this.callback = callback;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create an instance of the viewholder by passing it the layout inflated as view and no root.
        return new PersonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_person, null));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        // sets the name of the person to the name textview of the viewholder.
        holder.name.setText(people.get(position).getName());

        // sets the age of the person to the age textview of the viewholder.
        holder.age.setText(String.valueOf(people.get(position).getAge()));

        // set a click event on the whole itemView (every element of the recyclerview).
        holder.itemView.setOnClickListener(view -> callback.onPersonItemClicked(people.get(position)));
    }

    @Override
    public int getItemCount() {
        // Returns the size of the recyclerview that is the list of the arraylist.
        return people.size();
    }
}
