package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class RecActivity extends AppCompatActivity {

    TextView recTextView;
    Button newRecBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);

        // Get text and btn
        recTextView = findViewById(R.id.recTextView);
        newRecBtn = findViewById(R.id.newRecBtn);

        Resources res = getResources();
        String[] recipes = res.getStringArray(R.array.recipes);

        // Generate recommendation
        recTextView.setText(randomRecipe(recipes));

        // Each time the button is clicked a new recommendation appears
        newRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change recommended recipe
                recTextView.setText(randomRecipe(recipes));
            }
        });

    }

    private String randomRecipe(String[] recipes){
        //Simple random generator
        Random random = new Random();
        String recipe = recTextView.getText().toString();

        while (recipe == recTextView.getText().toString()){
            recipe = recipes[random.nextInt(recipes.length)];
        }

        return recipe;
    }
}