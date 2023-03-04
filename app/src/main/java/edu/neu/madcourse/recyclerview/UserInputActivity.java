package edu.neu.madcourse.recyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * This example shows how to take input from the end-user and create an object from it.
 */
public class UserInputActivity extends AppCompatActivity {

    private TextView nameTextView;

    private TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        nameTextView = findViewById(R.id.name);
        ageTextView = findViewById(R.id.age);

        // Get an instance of the floating action button that is available in the xml layout
        FloatingActionButton addPerson = findViewById(R.id.addPerson);

        addPerson.setOnClickListener(view -> {
            // Create a dialog with the Alert Dialog Builder
            AlertDialog dialog = new AlertDialog
                    .Builder(UserInputActivity.this)
                    // Set custom view from the XML file that defines the layout of the dialog
                    .setView(R.layout.dialog_input_person)
                    // Show the dialog
                    .show();

            // Get the button of the dialog
            Button addPersonDialogButton = dialog.findViewById(R.id.addButton);
            // Get the edit text from the dialog that takes input for name of person
            EditText nameEditText = dialog.findViewById(R.id.nameInput);
            // Get the edit text from the dialog that takes input for age of person
            EditText ageEditText = dialog.findViewById(R.id.ageInput);

            // Add a click listener to the button of the dialog
            addPersonDialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get the text of the edit texts and covert it to String
                    String name = nameEditText.getText().toString();
                    String age = ageEditText.getText().toString();

                    // Validate if both the edit texts are not empty
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(age)) {
                        // Create a new Person object from the data entered by the user
                        Person person = new Person(name, Integer.parseInt(age));
                        // Call the method that sets the name and age of the person to UI
                        addPersonFromUserInput(person);
                        // Close the dialog
                        dialog.dismiss();
                        // Show some feedback to the user
                        Toast.makeText(UserInputActivity.this, "Person Added Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        // Show some feedback to the user when the edittexts are empty and add button is pressed
                        Toast.makeText(UserInputActivity.this, "Input Name and Age First", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
    }

    private void addPersonFromUserInput(Person person) {
        // Set the name of the person to the name text view
        nameTextView.setText(person.getName());
        // Set the age of the person to the age text view
        ageTextView.setText(String.valueOf(person.getAge()));
    }
}