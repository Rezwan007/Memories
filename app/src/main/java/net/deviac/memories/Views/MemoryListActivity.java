package net.deviac.memories.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import net.deviac.memories.Adapter.MemoryAdapter;
import net.deviac.memories.Database.MemoryManager;
import net.deviac.memories.Model.MemoryModel;
import net.deviac.memories.R;

import java.util.ArrayList;

public class MemoryListActivity extends AppCompatActivity {

    ListView memoryListView;
    ArrayList<MemoryModel> allMemories;
    MemoryManager memoryManager;
    MemoryAdapter memoryAdapter;
    TextView memoryIdTV, memoryTitleTV, memoryDescriptionTV, memoryDateTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_full_list);

        memoryListView = (ListView) findViewById(R.id.memoryListView);
        memoryManager = new MemoryManager(this);
        allMemories = memoryManager.getAllMemories();

        memoryAdapter = new MemoryAdapter(this, allMemories);
        memoryListView.setAdapter(memoryAdapter);


        memoryListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                memoryIdTV = (TextView) view.findViewById(R.id.memoryId);
                TextView memoryTitleTV = (TextView) view.findViewById(R.id.memoryTitle);
                TextView memoryDescriptionTV = (TextView) view.findViewById(R.id.memoryDescription);

                int memoryId = Integer.parseInt(memoryIdTV.getText().toString());
                String memoryTitle = memoryTitleTV.getText().toString();
                String memoryDescription = memoryDescriptionTV.getText().toString();

                Intent intentUpdateMemory = new Intent(getApplicationContext(), MemoryUpdateActivity.class);
                intentUpdateMemory.putExtra("memoryID", memoryId);
                intentUpdateMemory.putExtra("memoryTitle", memoryTitle);
                intentUpdateMemory.putExtra("memoryDescription", memoryDescription);

                startActivity(intentUpdateMemory);
                MemoryListActivity.this.finish();
                return false;
            }
        });
    }
}
