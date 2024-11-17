package com.example.assignment5;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView departmentNameText = findViewById(R.id.departmentName);
        TextView departmentDetailsText = findViewById(R.id.departmentDetails);
        ImageView departmentImage = findViewById(R.id.departmentImage);

        // Get intent data
        String departmentName = getIntent().getStringExtra("departmentName");
        String details = getIntent().getStringExtra("details");

        if (departmentName != null && details != null) {
            // Set data to views
            departmentNameText.setText(departmentName);
            departmentDetailsText.setText(details);

            // Set an image based on the department
            switch (departmentName) {
                case "Computer Science & Engineering":
                    departmentImage.setImageResource(R.drawable.cse);
                    break;
                case "Electrical & Electronic Engineering":
                    departmentImage.setImageResource(R.drawable.eee);
                    break;
                case "Law":
                    departmentImage.setImageResource(R.drawable.law);
                    break;
                case "English":
                    departmentImage.setImageResource(R.drawable.english);
                    break;
                default:
                    departmentImage.setVisibility(View.GONE); // Hide image if no match
                    break;
            }
        } else {
            departmentNameText.setText("No information available");
            departmentDetailsText.setText("");
            departmentImage.setVisibility(View.GONE);
        }
    }
}
