package com.mhr.squad.satellitevpn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.mhr.squad.satellitevpn.adapter.ServerListAdapter;
import com.mhr.squad.satellitevpn.model.Servers;

import android.os.Bundle;

import java.util.ArrayList;

public class Server_List_Activity extends AppCompatActivity {

    private AdView mAdView;
    RecyclerView ServerRecyclerView;
    ArrayList<Servers> ServerList;
    ServerListAdapter serverListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_list);
        ServerRecyclerView=findViewById(R.id.ServerRv);

        ServerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ServerList=getServerList();
//---------------------------
        {
            serverListAdapter=new ServerListAdapter(this, ServerList);
            ServerRecyclerView.setAdapter(serverListAdapter);
        }

//--------------------


        //---------------Banner Ads Implement------------------
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private ArrayList getServerList() {
        ArrayList<Servers> servers= new ArrayList<>();
        servers.add(new Servers
                ("Germany",
                        Utiles.getImageUrl(R.drawable.icons_germany),
                        "germany.ovpn",
                        "vpn",
                        "vpn"));
        servers.add(new Servers
                ("japan",
                        Utiles.getImageUrl(R.drawable.icons_japan),
                        "japan.ovpn",
                        "vpn",
                        "vpn"));
        servers.add(new Servers
                ("Korea",
                        Utiles.getImageUrl(R.drawable.southkorea),
                        "korea.ovpn",
                        "vpn",
                        "vpn"));
        servers.add(new Servers
                ("NetherLands",
                        Utiles.getImageUrl(R.drawable.netherlands),
                        "netharlands.ovpn",
                        "vpn",
                        "vpn"));
        servers.add(new Servers
                ("Romania",
                        Utiles.getImageUrl(R.drawable.romania),
                        "romania.ovpn",
                        "vpn",
                        "vpn"));
        servers.add(new Servers
                ("Thailand",
                        Utiles.getImageUrl(R.drawable.icons_thailand),
                        "thailands.ovpn",
                        "vpn",
                        "vpn"));
        servers.add(new Servers
                ("United State",
                        Utiles.getImageUrl(R.drawable.icons_unitedstate),
                        "unitedstate.ovpn",
                        "vpn",
                        "vpn"));
        servers.add(new Servers
                ("Vietnam",
                        Utiles.getImageUrl(R.drawable.icons_vietnam),
                        "vietnam.ovpn",
                        "vpn",
                        "vpn"));




        return servers;

    }
}