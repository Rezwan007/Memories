package net.deviac.memories.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.deviac.memories.Database.MemoryManager;
import net.deviac.memories.Model.MemoryModel;
import net.deviac.memories.R;

import java.util.Calendar;
import java.util.Locale;

public class MemoryUpdateActivity extends AppCompatActivity {
    EditText memoryTitleET, memoryDescriptionET;
    MemoryManager memoryManager;
    private int memoryId;
    String memoryTitle, memoryDescription, title, description, date, image;
    Calendar calendar;
    private static final String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_update);

        memoryId = getIntent().getIntExtra("memoryID", -1);
        memoryTitle = getIntent().getStringExtra("memoryTitle");
        memoryDescription = getIntent().getStringExtra("memoryDescription");

        memoryTitleET = (EditText) findViewById(R.id.updateTitle);
        memoryDescriptionET = (EditText) findViewById(R.id.updateMessage);

        memoryTitleET.setText(memoryTitle);
        memoryDescriptionET.setText(memoryDescription);

        memoryManager = new MemoryManager(this);

    }

    public void updateMemory(View view) {
        title = memoryTitleET.getText().toString();
        description = memoryDescriptionET.getText().toString();
        image = "a_generic_string";

        // Get Current Time
        calendar = Calendar.getInstance(Locale.getDefault());
        date = calendar.get(Calendar.DAY_OF_MONTH) + " " + months[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR);
        MemoryModel memoryModel = new MemoryModel(memoryId, title, description, image, date);
        if( memoryManager.updateMemory(memoryModel) ) {
            Toast.makeText(this, "Update Successfull!", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {
            Toast.makeText(this, "Update Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteMemory(View view) {

        if(memoryId > -1) {
            if( memoryManager.deleteMemory(memoryId) ) {
                Toast.makeText(this, "Memory Deleted Successfully", Toast.LENGTH_SHORT).show();
                this.finish();
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
