package com.example.masho.checking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RiceAfterlogin extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<FoodItemclass> list;
    FoodItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_after_login);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Rice");

        recyclerView = (RecyclerView) findViewById(R.id.user_list);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        recyclerView.scrollToPosition(0);
        reference = FirebaseDatabase.getInstance().getReference().child("Rice");
        list = new ArrayList<>();


      reference.addChildEventListener(new ChildEventListener() {
          @Override
          public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                  FoodItemclass foodItemclass = dataSnapshot.getValue(FoodItemclass.class);
                  list.add(foodItemclass);


              adapter = new FoodItemAdapter(RiceAfterlogin.this,list);
              recyclerView.setAdapter(adapter);
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
