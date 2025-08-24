package com.example.batth.bad_chat_v3;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class View_Holder extends RecyclerView.ViewHolder {

    TextView message;

    public View_Holder(@NonNull View itemView) {
        super(itemView);
        message = itemView.findViewById(R.id.message_item);
    }
}
