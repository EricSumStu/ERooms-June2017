package com.example.eowemcn.myapplication.list;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eowemcn.myapplication.ExpandableListAdapter;
import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.models.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends Activity {

    private boolean clicked;
    RoomListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Room>> listDataChild;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Typeface myTypeFace4 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView4 = (TextView) findViewById(R.id.textview4);
        myTextView4.setTypeface(myTypeFace4);

        final TextView textviewclick = (TextView) findViewById(R.id.lblListItem);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing Oldlist data
        prepareListData();

        listAdapter = new RoomListAdapter(this, listDataHeader, listDataChild);

        // setting Oldlist adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                TextView textViewColor = (TextView) v.findViewById(R.id.lblListItem);




                if(!clicked){
                    textViewColor.setTextColor(getResources().getColor(R.color.drawer_color));
                    // set the default color
                    clicked = true;
                }else{
                    textViewColor.setTextColor(getResources().getColor(R.color.colorGreen));
                    //set secondary color
                    clicked = false;
                }


          /*      Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show(); */
                return false;
            }
        });
    }



    /*
     * Preparing the Oldlist data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Zone 1");
        listDataHeader.add("Zone 3");
        listDataHeader.add("Zone 4");
        listDataHeader.add("Zone 5");
        listDataHeader.add("Zone 6");
        listDataHeader.add("Zone 7");
        listDataHeader.add("Zone 8");
        listDataHeader.add("Zone 9");


        // Adding child data
        List<Room> zone1 = new ArrayList<>();
        String larsName = getString(R.string.LarsMagnus); // get the room name from res/values/strings.xml
        Room lars = new Room(larsName); // Create a room object with the name
        lars.setCapacity(R.integer.Lars_Magnus);
        zone1.add(lars); // add the room to the list of rooms for zone1

        // add another room
        String rey = getString(R.string.Reykjavik); // get the room name from res/values/strings.xml
        Room reyk = new Room(rey); // Create a room object with the name
        reyk.setCapacity(R.integer.Reykjavik);
        zone1.add(reyk); // add the room to the list of rooms for zone1

        String nuu = getString(R.string.Nuuk); // get the room name from res/values/strings.xml
        Room nuuk = new Room(nuu); // Create a room object with the name
        nuuk.setCapacity(R.integer.Nuuk);
        zone1.add(nuuk); // add the room to the list of rooms for zone1

        String q1 = getString(R.string.Quiet_Room_1_16); // get the room name from res/values/strings.xml
        Room qu1 = new Room(q1); // Create a room object with the name
        qu1.setCapacity(R.integer.Quiet_Room_1_16);
        zone1.add(qu1); // add the room to the list of rooms for zone1

        String q2 = getString(R.string.Quiet_Room_1_17); // get the room name from res/values/strings.xml
        Room qu2 = new Room(q2); // Create a room object with the name
        qu2.setCapacity(R.integer.Quiet_Room_1_17);
        zone1.add(qu2); // add the room to the list of rooms for zone1

        String q3 = getString(R.string.Quiet_Room_1_20); // get the room name from res/values/strings.xml
        Room qu3 = new Room(q3); // Create a room object with the name
        qu3.setCapacity(R.integer.Quiet_Room_1_20);
        zone1.add(qu3); // add the room to the list of rooms for zone1

        String q4 = getString(R.string.Quiet_Room_1_21); // get the room name from res/values/strings.xml
        Room qu4 = new Room(q4); // Create a room object with the name
        qu4.setCapacity(R.integer.Quiet_Room_1_21);
        zone1.add(qu4); // add the room to the list of rooms for zone1

        String q5 = getString(R.string.Quiet_Room_1_28); // get the room name from res/values/strings.xml
        Room qu5 = new Room(q5); // Create a room object with the name
        qu5.setCapacity(R.integer.Quiet_Room_1_21);
        zone1.add(qu5); // add the room to the list of rooms for zone1

        String q6 = getString(R.string.Quiet_Room_1_29); // get the room name from res/values/strings.xml
        Room qu6 = new Room(q6); // Create a room object with the name
        qu6.setCapacity(R.integer.Quiet_Room_1_29);
        zone1.add(qu6); // add the room to the list of rooms for zone1

        List<Room> zone3 = new ArrayList<>();
        String Pa = getString(R.string.Paris); // get the room name from res/values/strings.xml
        Room Par = new Room(Pa); // Create a room object with the name
        Par.setCapacity(R.integer.Paris);
        zone3.add(Par); // add the room to the list of rooms for zone1

        String At = getString(R.string.Athlone_Conference_Room); // get the room name from res/values/strings.xml
        Room Ath = new Room(At); // Create a room object with the name
        Ath.setCapacity(R.integer.Athlone_Conference_Room);
        zone3.add(Ath); // add the room to the list of rooms for zone1

        String Q336 = getString(R.string.Quiet_Room_3_36); // get the room name from res/values/strings.xml
        Room Qr336 = new Room(Q336); // Create a room object with the name
        Qr336.setCapacity(R.integer.Quiet_Room_3_36);
        zone3.add(Qr336); // add the room to the list of rooms for zone1

        String Q344  = getString(R.string.Quiet_Room_3_44); // get the room name from res/values/strings.xml
        Room Qr344 = new Room(Q344); // Create a room object with the name
        Qr344.setCapacity(R.integer.Quiet_Room_3_44);
        zone3.add(Qr344); // add the room to the list of rooms for zone1

        String Q345 = getString(R.string.Quiet_Room_3_45); // get the room name from res/values/strings.xml
        Room Qr345 = new Room(Q345); // Create a room object with the name
        Qr345.setCapacity(R.integer.Quiet_Room_3_45);
        zone3.add(Qr345); // add the room to the list of rooms for zone1

        List<Room> zone4 = new ArrayList<>();
        String De = getString(R.string.Demo_Room); // get the room name from res/values/strings.xml
        Room Dem = new Room(De); // Create a room object with the name
        Dem.setCapacity(R.integer.Demo_Room);
        zone4.add(Dem); // add the room to the list of rooms for zone1

        String Ku = getString(R.string.Kuala_Lumpur); // get the room name from res/values/strings.xml
        Room Kua = new Room(Ku); // Create a room object with the name
        Kua.setCapacity(R.integer.Kuala_Lumpur);
        zone4.add(Kua); // add the room to the list of rooms for zone1

        String Q401 = getString(R.string.Quiet_Room_4_01); // get the room name from res/values/strings.xml
        Room Qr401 = new Room(Q401); // Create a room object with the name
        Qr401.setCapacity(R.integer.Quiet_Room_4_01);
        zone4.add(Qr401); // add the room to the list of rooms for zone1

        String Q402 = getString(R.string.Quiet_Room_4_02); // get the room name from res/values/strings.xml
        Room Qr402 = new Room(Q402); // Create a room object with the name
        Qr402.setCapacity(R.integer.Quiet_Room_4_02);
        zone4.add(Qr402); // add the room to the list of rooms for zone1

        String Q427 = getString(R.string.Quiet_Room_4_27); // get the room name from res/values/strings.xml
        Room Qr427 = new Room(Q427); // Create a room object with the name
        Qr427.setCapacity(R.integer.Quiet_Room_4_27);
        zone4.add(Qr427); // add the room to the list of rooms for zone1

        String Q445 = getString(R.string.Quiet_Room_4_45); // get the room name from res/values/strings.xml
        Room Qr445 = new Room(Q445); // Create a room object with the name
        Qr445.setCapacity(R.integer.Quiet_Room_4_45);
        zone4.add(Qr445); // add the room to the list of rooms for zone1

        String Q455 = getString(R.string.Quiet_Room_4_55); // get the room name from res/values/strings.xml
        Room Qr455 = new Room(Q455); // Create a room object with the name
        Qr455.setCapacity(R.integer.Quiet_Room_4_55);
        zone4.add(Qr455); // add the room to the list of rooms for zone1

        String Q456 = getString(R.string.Quiet_Room_4_56); // get the room name from res/values/strings.xml
        Room Qr456 = new Room(Q456); // Create a room object with the name
        Qr456.setCapacity(R.integer.Quiet_Room_4_56);
        zone4.add(Qr456); // add the room to the list of rooms for zone1

        String Q457 = getString(R.string.Quiet_Room_4_57); // get the room name from res/values/strings.xml
        Room Qr457 = new Room(Q457); // Create a room object with the name
        Qr457.setCapacity(R.integer.Quiet_Room_4_57);
        zone4.add(Qr457); // add the room to the list of rooms for zone1

        List<Room> zone5 = new ArrayList<>();
        String S = getString(R.string.Stockholm); // get the room name from res/values/strings.xml
        Room St = new Room(S); // Create a room object with the name
        St.setCapacity(R.integer.Stockholm);
        zone5.add(St); // add the room to the list of rooms for zone1

        String B = getString(R.string.Berlin); // get the room name from res/values/strings.xml
        Room Be = new Room(B); // Create a room object with the name
        Be.setCapacity(R.integer.Berlin);
        zone5.add(Be); // add the room to the list of rooms for zone1

        String H = getString(R.string.Helsinki); // get the room name from res/values/strings.xml
        Room He = new Room(H); // Create a room object with the name
        He.setCapacity(R.integer.Helsinki);
        zone5.add(He); // add the room to the list of rooms for zone1

        String Ro = getString(R.string.Rome); // get the room name from res/values/strings.xml
        Room Rom = new Room(Ro); // Create a room object with the name
        Rom.setCapacity(R.integer.Rome);
        zone5.add(Rom); // add the room to the list of rooms for zone1

        String Q504 = getString(R.string.Quiet_Room_5_04); // get the room name from res/values/strings.xml
        Room Qr504 = new Room(Q504); // Create a room object with the name
        Qr504.setCapacity(R.integer.Quiet_Room_5_04);
        zone5.add(Qr504); // add the room to the list of rooms for zone1

        String Q510 = getString(R.string.Quiet_Room_5_10); // get the room name from res/values/strings.xml
        Room Qr510 = new Room(Q510); // Create a room object with the name
        Qr510.setCapacity(R.integer.Quiet_Room_5_10);
        zone5.add(Qr510); // add the room to the list of rooms for zone1

        List<Room> zone6 = new ArrayList<>();
        String W = getString(R.string.Wellington); // get the room name from res/values/strings.xml
        Room We = new Room(W); // Create a room object with the name
        We.setCapacity(R.integer.Wellington);
        zone6.add(We); // add the room to the list of rooms for zone1

        String C = getString(R.string.Canberra); // get the room name from res/values/strings.xml
        Room Ca = new Room(C); // Create a room object with the name
        Ca.setCapacity(R.integer.Canberra);
        zone6.add(Ca); // add the room to the list of rooms for zone1

        String T = getString(R.string.Tokyo); // get the room name from res/values/strings.xml
        Room To = new Room(T); // Create a room object with the name
        To.setCapacity(R.integer.Tokyo);
        zone6.add(To); // add the room to the list of rooms for zone1

        String Wa = getString(R.string.Warsaw); // get the room name from res/values/strings.xml
        Room War = new Room(Wa); // Create a room object with the name
        War.setCapacity(R.integer.Warsaw);
        zone6.add(War); // add the room to the list of rooms for zone1

        String K = getString(R.string.Kiev); // get the room name from res/values/strings.xml
        Room Ki = new Room(K); // Create a room object with the name
        zone6.add(Ki); // add the room to the list of rooms for zone1

        String M = getString(R.string.Moscow); // get the room name from res/values/strings.xml
        Room Mo = new Room(M); // Create a room object with the name
        Mo.setCapacity(R.integer.Moscow);
        zone6.add(Mo); // add the room to the list of rooms for zone1

        String Q601 = getString(R.string.Quiet_Room_6_01); // get the room name from res/values/strings.xml
        Room Qr601 = new Room(Q601); // Create a room object with the name
        Qr601.setCapacity(R.integer.Quiet_Room_6_01);
        zone6.add(Qr601); // add the room to the list of rooms for zone1

        String Q615 = getString(R.string.Quiet_Room_6_15); // get the room name from res/values/strings.xml
        Room Qr615 = new Room(Q615); // Create a room object with the name
        Qr615.setCapacity(R.integer.Quiet_Room_6_15);
        zone6.add(Qr615); // add the room to the list of rooms for zone1

        String Q616 = getString(R.string.Quiet_Room_6_16); // get the room name from res/values/strings.xml
        Room Qr616 = new Room(Q616); // Create a room object with the name
        Qr616.setCapacity(R.integer.Quiet_Room_6_16);
        zone6.add(Qr616); // add the room to the list of rooms for zone1

        String Q629 = getString(R.string.Quiet_Room_6_29); // get the room name from res/values/strings.xml
        Room Qr629 = new Room(Q629); // Create a room object with the name
        Qr629.setCapacity(R.integer.Quiet_Room_6_29);
        zone6.add(Qr629); // add the room to the list of rooms for zone1

        String Q630 = getString(R.string.Quiet_Room_6_30); // get the room name from res/values/strings.xml
        Room Qr630 = new Room(Q630); // Create a room object with the name
        Qr630.setCapacity(R.integer.Quiet_Room_6_30);
        zone6.add(Qr630); // add the room to the list of rooms for zone1

        String Q636 = getString(R.string.Quiet_Room_6_36); // get the room name from res/values/strings.xml
        Room Qr636 = new Room(Q636); // Create a room object with the name
        Qr636.setCapacity(R.integer.Quiet_Room_6_36);
        zone6.add(Qr636); // add the room to the list of rooms for zone1

        List<Room> zone7 = new ArrayList<>();
        String CA = getString(R.string.Cape_Town); // get the room name from res/values/strings.xml
        Room CAP = new Room(CA); // Create a room object with the name
        CAP.setCapacity(R.integer.Cape_Town);
        zone7.add(CAP); // add the room to the list of rooms for zone1

        String J = getString(R.string.Jakarta); // get the room name from res/values/strings.xml
        Room Ja = new Room(J); // Create a room object with the name
        Ja.setCapacity(R.integer.Jakarta);
        zone7.add(Ja); // add the room to the list of rooms for zone1

        String Q708 = getString(R.string.Quiet_Room_7_08); // get the room name from res/values/strings.xml
        Room Qr708 = new Room(Q708); // Create a room object with the name
        Qr708.setCapacity(R.integer.Quiet_Room_7_08);
        zone7.add(Qr708); // add the room to the list of rooms for zone1

        String Q709 = getString(R.string.Quiet_Room_7_09); // get the room name from res/values/strings.xml
        Room Qr709 = new Room(Q709); // Create a room object with the name
        We.setCapacity(R.integer.Wellington);
        zone7.add(Qr709); // add the room to the list of rooms for zone1

        String Q711 = getString(R.string.Quiet_Room_7_11); // get the room name from res/values/strings.xml
        Room Qr711 = new Room(Q711); // Create a room object with the name
        Qr711.setCapacity(R.integer.Quiet_Room_7_11);
        zone7.add(Qr711); // add the room to the list of rooms for zone1

        String Q714 = getString(R.string.Quiet_Room_7_14); // get the room name from res/values/strings.xml
        Room Qr714 = new Room(Q714); // Create a room object with the name
        Qr714.setCapacity(R.integer.Quiet_Room_7_14);
        zone7.add(Qr714); // add the room to the list of rooms for zone1

        String Q719 = getString(R.string.Quiet_Room_7_19); // get the room name from res/values/strings.xml
        Room Qr719 = new Room(Q719); // Create a room object with the name
        Qr719.setCapacity(R.integer.Quiet_Room_7_19);
        zone7.add(Qr719); // add the room to the list of rooms for zone1

        String Q720 = getString(R.string.Quiet_Room_7_20); // get the room name from res/values/strings.xml
        Room Qr720 = new Room(Q720); // Create a room object with the name
        Qr720.setCapacity(R.integer.Quiet_Room_7_20);
        zone7.add(Qr720); // add the room to the list of rooms for zone1

        List<Room> zone8 = new ArrayList<>();
        String Ho = getString(R.string.Honolulu); // get the room name from res/values/strings.xml
        Room Hon = new Room(Ho); // Create a room object with the name
        Hon.setCapacity(R.integer.Honolulu);
        zone8.add(Hon); // add the room to the list of rooms for zone1

        String Ot = getString(R.string.Ottowa); // get the room name from res/values/strings.xml
        Room Ott = new Room(Ot); // Create a room object with the name
        Ott.setCapacity(R.integer.Ottowa);
        zone8.add(Ott); // add the room to the list of rooms for zone1

        String An = getString(R.string.Anchorage); // get the room name from res/values/strings.xml
        Room Anc = new Room(An); // Create a room object with the name
        Anc.setCapacity(R.integer.Anchorage);
        zone8.add(Anc); // add the room to the list of rooms for zone1

        String Q812 = getString(R.string.Quiet_Room_8_12); // get the room name from res/values/strings.xml
        Room Qr812 = new Room(Q812); // Create a room object with the name
        Qr812.setCapacity(R.integer.Quiet_Room_8_12);
        zone8.add(Qr812); // add the room to the list of rooms for zone1

        String Q818 = getString(R.string.Quiet_Room_8_18); // get the room name from res/values/strings.xml
        Room Qr818 = new Room(Q818); // Create a room object with the name
        Qr818.setCapacity(R.integer.Quiet_Room_8_18);
        zone8.add(Qr818); // add the room to the list of rooms for zone1

        String Q823 = getString(R.string.Quiet_Room_8_23); // get the room name from res/values/strings.xml
        Room Qr823 = new Room(Q823); // Create a room object with the name
        Qr823.setCapacity(R.integer.Quiet_Room_8_23);
        zone8.add(Qr823); // add the room to the list of rooms for zone1

        String Q828 = getString(R.string.Quiet_Room_8_28); // get the room name from res/values/strings.xml
        Room Qr828 = new Room(Q828); // Create a room object with the name
        Qr828.setCapacity(R.integer.Quiet_Room_8_28);
        zone8.add(Qr828); // add the room to the list of rooms for zone1

        String Q829 = getString(R.string.Quiet_Room_8_29); // get the room name from res/values/strings.xml
        Room Qr829 = new Room(Q829); // Create a room object with the name#
        Qr829.setCapacity(R.integer.Quiet_Room_8_29);
        zone8.add(Qr829); // add the room to the list of rooms for zone1

        String Q830 = getString(R.string.Quiet_Room_8_30); // get the room name from res/values/strings.xml
        Room Qr830 = new Room(Q830); // Create a room object with the name
        Qr830.setCapacity(R.integer.Quiet_Room_8_30);
        zone8.add(Qr830); // add the room to the list of rooms for zone1

        String Q834 = getString(R.string.Quiet_Room_8_34); // get the room name from res/values/strings.xml
        Room Qr834 = new Room(Q834); // Create a room object with the name
        Qr834.setCapacity(R.integer.Quiet_Room_8_34);
        zone8.add(Qr834); // add the room to the list of rooms for zone1

        String Q835 = getString(R.string.Quiet_Room_8_35); // get the room name from res/values/strings.xml
        Room Qr835 = new Room(Q835); // Create a room object with the name
        Qr834.setCapacity(R.integer.Quiet_Room_8_35);
        zone8.add(Qr835); // add the room to the list of rooms for zone1

        List<Room> zone9 = new ArrayList<>();
        String BU = getString(R.string.Buenos_Aires); // get the room name from res/values/strings.xml
        Room BUA = new Room(BU); // Create a room object with the name
        BUA.setCapacity(R.integer.Buenos_Aires);
        zone9.add(BUA); // add the room to the list of rooms for zone1

        String BR = getString(R.string.Brasillia); // get the room name from res/values/strings.xml
        Room BRA = new Room(BR); // Create a room object with the name
        BRA.setCapacity(R.integer.Brasillia);
        zone9.add(BRA); // add the room to the list of rooms for zone1

        String WD = getString(R.string.Washington_DC); // get the room name from res/values/strings.xml
        Room WDC = new Room(WD); // Create a room object with the name
        WDC.setCapacity(R.integer.Washington_DC);
        zone9.add(WDC); // add the room to the list of rooms for zone1

        String V = getString(R.string.V_A_Lab); // get the room name from res/values/strings.xml
        Room VA = new Room(V); // Create a room object with the name
        VA.setCapacity(R.integer.V_A_Lab);
        zone9.add(VA); // add the room to the list of rooms for zone1

        String Q906 = getString(R.string.Quiet_Room_9_06); // get the room name from res/values/strings.xml
        Room Qr906 = new Room(Q906); // Create a room object with the name#
        Qr906.setCapacity(R.integer.Quiet_Room_9_06);
        zone9.add(Qr906); // add the room to the list of rooms for zone1

        String Q917 = getString(R.string.Quiet_Room_9_17); // get the room name from res/values/strings.xml
        Room QR917 = new Room(Q917); // Create a room object with the name
        QR917.setCapacity(R.integer.Quiet_Room_9_17);
        zone9.add(QR917); // add the room to the list of rooms for zone1

        String Q925 = getString(R.string.Quiet_Room_9_25); // get the room name from res/values/strings.xml
        Room Qr925 = new Room(Q925); // Create a room object with the name
        Qr925.setCapacity(R.integer.Quiet_Room_9_25);
        zone9.add(Qr925); // add the room to the list of rooms for zone1

        String Q927 = getString(R.string.Quiet_Room_9_27); // get the room name from res/values/strings.xml
        Room Qr927 = new Room(Q927); // Create a room object with the name
        Qr927.setCapacity(R.integer.Quiet_Room_9_27);
        zone9.add(Qr927); // add the room to the list of rooms for zone1

        String Q939 = getString(R.string.Quiet_Room_9_39); // get the room name from res/values/strings.xml
        Room QR939 = new Room(Q939); // Create a room object with the name
        QR939.setCapacity(R.integer.Quiet_Room_9_39);
        zone9.add(QR939); // add the room to the list of rooms for zone1

        String Q941 = getString(R.string.Quiet_Room_9_41); // get the room name from res/values/strings.xml
        Room QR941 = new Room(Q941); // Create a room object with the name
        QR941.setCapacity(R.integer.Quiet_Room_9_41);
        zone9.add(QR941); // add the room to the list of rooms for zone1

        String Q948 = getString(R.string.Quiet_Room_9_48); // get the room name from res/values/strings.xml
        Room QR948 = new Room(Q948); // Create a room object with the name
        QR948.setCapacity(R.integer.Quiet_Room_9_48);
        zone9.add(QR948); // add the room to the list of rooms for zone1






        listDataChild.put(listDataHeader.get(0), zone1); // Header
        listDataChild.put(listDataHeader.get(1), zone3); // Header
        listDataChild.put(listDataHeader.get(2), zone4); // Header
        listDataChild.put(listDataHeader.get(3), zone5); // Header
        listDataChild.put(listDataHeader.get(4), zone6); // Header
        listDataChild.put(listDataHeader.get(5), zone7); // Header
        listDataChild.put(listDataHeader.get(6), zone8); // Header
        listDataChild.put(listDataHeader.get(7), zone9); // Header
    }
}