package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button recipesBtn = (Button) findViewById(R.id.recipesBtn);
        recipesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), RecipesActivity.class);
                startActivity(startIntent);
            }
        });

        Button buyBtn = (Button) findViewById(R.id.buyBtn);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lidl = "https://www.lidl.fi/";
                Uri webAddress = Uri.parse(lidl);

                Intent gotoLidl = new Intent(Intent.ACTION_VIEW, webAddress);
                if (gotoLidl.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoLidl);
                }
            }
        });

        Button listBtn = (Button) findViewById(R.id.listBtn);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(startIntent);
            }
        });

        SwitchMaterial modeSwitch = (SwitchMaterial) findViewById(R.id.modeSwitch);
        modeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    compoundButton.setText(R.string.night_mode);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    compoundButton.setText(R.string.day_mode);
                }
            }
        });

        boolean isNightModeOn = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
        modeSwitch.setChecked(isNightModeOn);
        if (isNightModeOn){
            modeSwitch.setText(R.string.night_mode);
        }else{
            modeSwitch.setText(R.string.day_mode);
        }
    }
}