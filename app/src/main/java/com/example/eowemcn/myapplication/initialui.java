package com.example.eowemcn.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eowemcn.myapplication.list.availability.FreeRoomActivity;
import com.example.eowemcn.myapplication.list.features.FeatureListActivity;
import com.example.eowemcn.myapplication.list.zone.ZoneListActivity;
import com.example.eowemcn.myapplication.map.Maps;
import com.example.eowemcn.myapplication.models.Room;
import com.example.eowemcn.myapplication.tasks.RetrieveRoomsJSONTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class initialui extends Activity {

    public Button textview2;
    ArrayList<String> listDataHeader;
    HashMap<String, List<Room>> listDataChild;
    public Button textview4;
    List<Room> rooms;

    public void init4() {
        textview4 = (Button) findViewById(R.id.textview4);
        textview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newscreen4 = new Intent(initialui.this, FreeRoomActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("allrooms",(Serializable) rooms);
                newscreen4.putExtras(bundle);

                startActivity(newscreen4);
            }
        });
    }
    public void init2() {
        textview2 = (Button) findViewById(R.id.textview2);
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newscreen2 = new Intent(initialui.this, Maps.class);

                startActivity(newscreen2);
            }
        });
    }

    public Button textview1;

    public void init() {
        textview1 = (Button) findViewById(R.id.textview1);
        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newscreen = new Intent(initialui.this, ZoneListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("allrooms",(Serializable) rooms);
                newscreen.putExtras(bundle);

                startActivity(newscreen);

            }
        });
    }

    public Button textview3;

    public void init3() {
        textview3 = (Button) findViewById(R.id.textview3);
        textview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newscreen3 = new Intent(initialui.this, FeatureListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("allrooms",(Serializable) rooms);
                newscreen3.putExtras(bundle);
    //            newscreen3.putExtra("header",  listDataHeader);
      //          newscreen3.putExtra("children", listDataChild);

                startActivity(newscreen3);
            }
        });
    }





    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.initialui);


        // Execute Background Task to get JSON
        try {
            rooms = new RetrieveRoomsJSONTask(initialui.this).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Typeface myTypeFace1 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView1 = (TextView) findViewById(R.id.textview1);
        myTextView1.setTypeface(myTypeFace1);
        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView2 = (TextView) findViewById(R.id.textview2);
        myTextView2.setTypeface(myTypeFace2);
        Typeface myTypeFace3 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView3 = (TextView) findViewById(R.id.textview3);
        myTextView3.setTypeface(myTypeFace3);
        Typeface myTypeFace4 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView4 = (TextView) findViewById(R.id.textview4);
        myTextView4.setTypeface(myTypeFace4);

        ImageView myImageView = (ImageView) findViewById(R.id.imageView1);
        myImageView.setImageResource(R.drawable.logo);


        init();
        init2();
        init3();
        init4();
    }



}
