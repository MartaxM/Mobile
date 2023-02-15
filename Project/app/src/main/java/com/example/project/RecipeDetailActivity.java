package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetailActivity extends AppCompatActivity {

    String name;
    String description;
    String instructions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.project.ITEM_INDEX",-1);

        if (index > -1){

            // Get all necessary strings
            Resources res = getResources();
            String name = in.getStringExtra("com.example.project.ITEM_NAME");
            String description = in.getStringExtra("com.example.project.ITEM_DESC");;
            String[] auxIns=res.getStringArray(R.array.instructions);
            String instruction = auxIns[index];

            // Get image by index and set it
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.recipeImageView);
            setImage(img, pic);

            // Set the text of each TextView
            TextView nameTexView = findViewById(R.id.nameTextView);
            nameTexView.setText(name);
            TextView descriptionTextView = findViewById(R.id.descriptionTextView);
            descriptionTextView.setText(description);
            TextView instructionsTextView= findViewById(R.id.instructionsTextView);
            instructionsTextView.setText(instruction);
        }



    }

    // To get the id of the drawable
    private int getImg(int index) {
        switch (index){
            case 0: return R.drawable.pasta;
            case 1: return R.drawable.pizza;
            case 2: return R.drawable.salad;
            case 3: return R.drawable.soup;
            case 4: return R.drawable.stew;
            default: return -1;
        }
    }

    private void setImage(ImageView img, int pic){
        img.setCropToPadding(true);
        img.setImageDrawable(getDrawable(pic));
    }
}