package com.example.waterwest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerView_days);
        new FirebaseDatabaseHelper().readDays(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Day> days, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecycler, MainActivity.this, days, keys);

            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }



    public  ArrayList<Map.Entry<String, String>> HashMapToArrayList(HashMap<String, String> map){

        //Getting Set of keys from map
        Set<String> keySet = map.keySet();

        //Creating an ArrayList of keys
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collections.sort(listOfKeys);
        Collections.reverse(listOfKeys);

        //Getting Collection of values
        Collection<String> values = map.values();

        //Creating an ArrayList of values
        ArrayList<String> listOfValues = new ArrayList<String>(values);

        //Getting the Set of entries
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        //Creating an ArrayList Of Entry objects
        ArrayList<Map.Entry<String, String>> listOfEntry = new ArrayList<Map.Entry<String,String>>(entrySet);

        return listOfEntry;
    }



}