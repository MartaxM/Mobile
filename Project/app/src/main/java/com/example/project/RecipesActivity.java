package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class RecipesActivity extends AppCompatActivity {

    ListView recipesListView;
    String[] recipes;
    String[] descriptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

    Resources res = getResources();
    recipesListView = (ListView) findViewById(R.id.recipesListView);
    recipes = res.getStringArray(R.array.recipes);
    descriptions = res.getStringArray(R.array.descriptions);

    ItemAdapter itemAdapter = new ItemAdapter(this, recipes, descriptions);
        recipesListView.setAdapter((itemAdapter));

        recipesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        // On click, start RecipeDetailActivity to see the detais of each recipe
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent showRecipeDetailActivity = new Intent(getApplicationContext(), RecipeDetailActivity.class);
            showRecipeDetailActivity.putExtra("com.example.project.ITEM_INDEX", i);
            showRecipeDetailActivity.putExtra("com.example.project.ITEM_NAME", recipes[i]);
            showRecipeDetailActivity.putExtra("com.example.project.ITEM_DESC", descriptions[i]);
            startActivity(showRecipeDetailActivity);
        }
    });
    }
}