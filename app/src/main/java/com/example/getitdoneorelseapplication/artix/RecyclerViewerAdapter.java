package com.example.getitdoneorelseapplication.artix;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getitdoneorelseapplication.calendar.Event;
import com.example.getitdoneorelseapplication.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RecyclerViewerAdapter extends RecyclerView.Adapter<RecyclerViewerAdapter.EventViewHolder> {

    public static ArrayList<Event> eventList = Event.eventList;

    public RecyclerViewerAdapter(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item_layout, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.bind(event);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView eventNameTextView;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventNameTextView = itemView.findViewById(R.id.eventNameTextView); // Replace with your actual TextView ID
        }

        public void bind(Event event) {
            eventNameTextView.setText(event.getName());
        }
    }
}