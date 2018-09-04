package com.example.masho.checking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
FirebaseDatabase database;
DatabaseReference databaseReference;
private EditText name,age;
private Button btn;
int orderNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    name = findViewById(R.id.Name);
    age = findViewById(R.id.Age);
    btn = findViewById(R.id.Submit);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Users");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RiceAfterlogin.class);
                SubmitOrder();
                startActivity(i);

            }
        });
    }
    private void SubmitOrder()
    {
        String Name = name.getText().toString();
        int Age = Integer.parseInt(age.getText().toString());
        databaseReference = database.getReference("Users").child("Orders"+ ++orderNo);
        databaseReference.child("Name").setValue(Name);
        databaseReference.child("Age").setValue(Age);
        Toast.makeText(getApplicationContext(),"Data saved to database",Toast.LENGTH_SHORT).show();
    }
}
