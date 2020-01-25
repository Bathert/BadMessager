package com.example.batth.bad_chat_v3;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static int max_message_length = 150;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference my_ref = database.getReference("messages");
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    User user = new User("Anton","Male", "24");

    EditText m_edit_text_message;
    Button m_send_button;
    RecyclerView m_messages_recycler;
    TextView user_id;
    TextView user_name_text;


    ArrayList<String> messages = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_send_button = findViewById(R.id.send_message_b);
        m_edit_text_message = findViewById(R.id.message_input);
        m_messages_recycler = findViewById(R.id.message_recycle);
        m_messages_recycler.setLayoutManager(new LinearLayoutManager(this));
        user_id = findViewById(R.id.user_id);
        //user_name_text = findViewById(R.id.user_name_text);

       // user_name_text.setText("Battrip");
        //Присваиваем уникальный id пользователю
       final int random_id_user = (int) (Math.random()*(9000)) + 1000;


        final Data_Adapter data_adapter = new Data_Adapter(this, messages);

        m_messages_recycler.setAdapter(data_adapter);


        m_send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String msg = m_edit_text_message.getText().toString().trim();
                if (msg.equals("")){
                    Toast.makeText(getApplicationContext(),"Введите сообщение",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (msg.equals("Я булка")){
                    Toast.makeText(getApplicationContext(),"Покажи сиськи )))",Toast.LENGTH_SHORT).show();
                    return;

                }
                if (msg.length()> max_message_length){
                    Toast.makeText(getApplicationContext(),"Слишком длинное сообщение",Toast.LENGTH_SHORT).show();
                    return;
                }
                my_ref.push().setValue(msg);
                m_edit_text_message.setText("");
                user_id.setText("" + random_id_user);
            }
        });

        my_ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String msg = dataSnapshot.getValue(String.class);
                messages.add(msg);
                data_adapter.notifyDataSetChanged();
                m_messages_recycler.smoothScrollToPosition(messages.size());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
