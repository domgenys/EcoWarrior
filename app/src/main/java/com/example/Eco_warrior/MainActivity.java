package com.example.Eco_warrior;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Eco_warrior.SearchByLogo;

public class MainActivity extends AppCompatActivity {


    Button buttonList, buttonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonList = findViewById(R.id.buttonList);
        buttonHelp = findViewById(R.id.buttonHelp);


        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, ChooseOption.class));

            }
        });


        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, SearchByLogo.class));
            }
        });
    }
}
