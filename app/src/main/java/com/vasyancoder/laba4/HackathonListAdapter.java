package com.vasyancoder.laba4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HackathonListAdapter extends ArrayAdapter<HackathonListItem> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<HackathonListItem> items;


    public HackathonListAdapter(@NonNull Context context, int resource, List<HackathonListItem> items) {
        super(context, resource, items);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView hackathonTitleItem = view.findViewById(R.id.hackathonTitleItem);
        TextView hackathonDescItem = view.findViewById(R.id.hackathonDescItem);
        HackathonListItem item = items.get(position);
        hackathonTitleItem.setText(item.getTextTitle());
        hackathonDescItem.setText(item.getTextDesc());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Item " + (position + 1) + " clicked", Toast.LENGTH_SHORT).show();
                Log.d("myLogs", "Item " + (position + 1) + " clicked");
            }
        });
        return view;
    }
}
