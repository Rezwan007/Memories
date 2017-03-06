package net.deviac.memories.Views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import net.deviac.memories.Database.MemoryManager;
import net.deviac.memories.Model.MemoryModel;
import net.deviac.memories.R;
import net.deviac.memories.Views.HomeScreenActivity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NewMemoryActivity extends AppCompatActivity {
    private static final String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    EditText memoryTitle, memoryDescription;
    Intent intentDiscard;
    MemoryManager memoryManager;
    MemoryModel memoryModel;

    Calendar calendar;

    String title, description, date, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memory);

        memoryTitle = (EditText) findViewById(R.id.addTitleTV);
        memoryDescription = (EditText) findViewById(R.id.addMessageTV);
        memoryManager = new MemoryManager(this);
    }

    public void addMemory(View view) {
        title = memoryTitle.getText().toString();
        description = memoryDescription.getText().toString();

        // Get Current Time
        calendar = Calendar.getInstance(Locale.getDefault());

        date = calendar.get(Calendar.DAY_OF_MONTH) + " " + months[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR);

        image = "a_generic_image_string";

        memoryModel = new MemoryModel(title, description, image, date);

        long addMemory = memoryManager.addMemory(memoryModel);
        
        if( addMemory > 0) {
            Toast.makeText(this, "Memory Added Successfully", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {
            Toast.makeText(this, String.valueOf(addMemory), Toast.LENGTH_SHORT).show();
        }

    }

    public void discard(View view) {
        intentDiscard = new Intent(getApplicationContext(), HomeScreenActivity.class);
        startActivity(intentDiscard);
    }

}
