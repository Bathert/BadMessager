package com.example.batth.bad_chat_v3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Data_Adapter extends RecyclerView.Adapter<View_Holder> {

    ArrayList<String> messages;

    LayoutInflater in_flater;


    public Data_Adapter(Context context, ArrayList<String> messages) {
        this.messages = messages;
        this.in_flater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = in_flater.inflate(R.layout.item_message, parent, false);
        return new View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        String msg = messages.get(position);
        holder.message.setText(msg);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
