package com.example.waterwest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Day {
    private String date;
    private HashMap<String, String> Times;

    public Day(String date, HashMap<String, String> times) {
        this.date = date;
        this.Times = times;
    }

    public Day(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Map.Entry<String, String>> getTimes() {

        return HashMapToArrayList(Times);
    }
    public  ArrayList<Map.Entry<String, String>> HashMapToArrayList(HashMap<String, String> map){

        //Getting Set of keys from map
        Set<String> keySet = map.keySet();

        //Creating an ArrayList of keys
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collections.sort(listOfKeys);

        TreeMap<String, String> sorted = new TreeMap<>();
        sorted.putAll(map);

        //Getting Collection of values
        Collection<String> values = map.values();

        //Creating an ArrayList of values
        ArrayList<String> listOfValues = new ArrayList<String>(values);

        //Getting the Set of entries
        Set<Map.Entry<String, String>> entrySet = sorted.entrySet();

        //Creating an ArrayList Of Entry objects
        ArrayList<Map.Entry<String, String>> listOfEntry = new ArrayList<Map.Entry<String,String>>(entrySet);
        //Collections.reverse(listOfKeys);

        return listOfEntry;
    }

    public void setTimes(HashMap<String, String> times) {
        this.Times = times;
    }
}
