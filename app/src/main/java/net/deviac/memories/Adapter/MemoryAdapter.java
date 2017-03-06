package net.deviac.memories.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.deviac.memories.Model.MemoryModel;
import net.deviac.memories.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by SUMIT on 1/17/2017.
 */

public class MemoryAdapter extends ArrayAdapter<MemoryModel> {

    ArrayList<MemoryModel> memoryList;
    Context context;

    public MemoryAdapter(Context context, ArrayList<MemoryModel> memories) {
        super(context, R.layout.activity_memory_list, memories);
        memoryList = memories;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MemoryModel memoryModel = memoryList.get(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.memory_list_item, parent, false);

        TextView id = (TextView) convertView.findViewById(R.id.memoryId);
        TextView title = (TextView) convertView.findViewById(R.id.memoryTitle);
        TextView description = (TextView) convertView.findViewById(R.id.memoryDescription);
        TextView date = (TextView) convertView.findViewById(R.id.memoryDate);

        id.setText(String.valueOf(memoryModel.getMemoryId()));
        title.setText(memoryModel.getMemoryTitle());
        description.setText(memoryModel.getMemoryDescription());
        date.setText(memoryModel.getMemoryDate());

        return convertView;
    }


}
