package edu.neu.madcourse.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final List<Person> people;
    private final Context context;

    public PersonAdapter(List<Person> people, Context context) {
        this.people = people;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PersonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_person, null));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.name.setText(people.get(position).getName());
        holder.age.setText(String.valueOf(people.get(position).getAge()));

        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(context, people.get(position).getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
