package com.example.masho.checking;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ListView mlistView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private DatabaseReference ref;
    private FirebaseDatabase database;
    EstimateTimeClass fooditem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        fooditem = new EstimateTimeClass();
        mlistView = (ListView) findViewById(R.id.EstlistView);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users");

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.est_list_item, R.id.EstItem, list);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren())
                {
                    fooditem  = data.getValue(EstimateTimeClass.class);
                    list.add(data.getKey());
                    mlistView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
