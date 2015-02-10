package com.example.aleksei_ivshin.firstapp;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.app.Fragment;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.fragment_left_container) != null){
            if(savedInstanceState != null){
                return;
            }

            ProducerFragment producerFragment = new ProducerFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_left_container,producerFragment).commit();
        }
        if(findViewById(R.id.fragment_rigth_container) != null){
            if(savedInstanceState != null){
                return;
            }

            ConsumerFragment consumerFragment = new ConsumerFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_rigth_container,consumerFragment).commit();
        }
    }

}
