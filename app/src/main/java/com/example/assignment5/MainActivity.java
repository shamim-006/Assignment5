package com.example.assignment5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.departmentListView);

        // Department data
        final String[] departments = {"Computer Science & Engineering", "Electrical & Electronic Engineering", "Law", "English"};
        final String[] details = {
                "Computer Science & Engineering:\nTotal Cost: $10,000",
                "Electrical & Electronic Engineering:\nTotal Cost: $8,500",
                "Law:\nTotal Cost: $7,000",
                "English:\nTotal Cost: $6,000"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, departments);
        listView.setAdapter(adapter);

        // Item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("departmentName", departments[position]);
                intent.putExtra("details", details[position]);
                startActivity(intent);
            }
        });

        // Item hover listener (Toast message)
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Department: " + departments[position], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
