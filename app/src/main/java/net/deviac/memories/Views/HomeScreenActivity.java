package net.deviac.memories.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.deviac.memories.Database.MemoryManager;
import net.deviac.memories.Model.MemoryModel;
import net.deviac.memories.R;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity {
    Intent intentAddMemory, intentMemoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }


    public void addMemory(View view) {
        intentAddMemory = new Intent(getApplicationContext(), NewMemoryActivity.class);
        startActivity(intentAddMemory);
    }

    public void showMemory(View view) {
        intentMemoryList = new Intent(getApplicationContext(), MemoryListActivity.class);
        startActivity(intentMemoryList);
    }

}
