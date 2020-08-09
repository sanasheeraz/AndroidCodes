package com.example.tabwithfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] tabsData={"Tab1" , "Tab2","Tab3","Tab4","Tab4","Tab4"};
        setContentView(R.layout.activity_main);
        tabs=findViewById(R.id.tabs);
        int count =6;
        for(int i=0;i<count;i++)
        {
            tabs.addTab(tabs.newTab().setText(tabsData[i]));
        }
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                        Fragment1 fragment1=new Fragment1();
                        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fragment_container,fragment1);
                        ft.commit();
                        break;
                    case 1:
                        Fragment2 fragment2=new Fragment2();
                        FragmentTransaction ft2=getSupportFragmentManager().beginTransaction();
                        ft2.replace(R.id.fragment_container,fragment2);
                        ft2.commit();
                        break;
                    case 2:
                        Fragment3 fragment3=new Fragment3();
                        FragmentTransaction ft3=getSupportFragmentManager().beginTransaction();
                        ft3.replace(R.id.fragment_container,fragment3);
                        ft3.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}