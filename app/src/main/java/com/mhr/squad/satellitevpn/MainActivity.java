package com.mhr.squad.satellitevpn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private AdView mAdView;
    NavigationView NaviView;
    DrawerLayout drawerLayout;
    ImageButton naviOpenClosse, moreservericon;
    ImageButton premiumversion;
    MaterialCardView serverlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        premiumversion = findViewById(R.id.premium);
        serverlist = findViewById(R.id.moreserver);



        //----navigation drawer---
        NaviView = findViewById(R.id.Navi_View);
        drawerLayout=findViewById(R.id.drawer_layout);
        naviOpenClosse=findViewById(R.id.naviOpencloss);

        NaviView.setCheckedItem(R.id.AllServer);


        drawerLayout.bringToFront();
        //----OnItem click listener of navigation view----
        NaviView.setNavigationItemSelectedListener(this);


        //--------------------------------
        premiumversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Setting_Activity.class));
            }

        });

        //-----navigation set click listener Start//

        naviOpenClosse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)){

                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        //End Navigation---



        //----Banner Ads---------//
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }







    public void next(View view) {
        startActivity(new Intent(MainActivity.this, Server_List_Activity.class));
    }


//----now if you want to close your navigation drawer by backPress-----

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}



