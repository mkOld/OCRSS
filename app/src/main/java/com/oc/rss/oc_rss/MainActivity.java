package com.oc.rss.oc_rss;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button myButton;
    Context myContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = this;
        setContentView(R.layout.activity_main);
        myButton = (Button)findViewById(R.id.btnClickHere);
        myButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, "CA MARCHE !", Toast.LENGTH_SHORT).show();
                Log.i("haja", "Ca marche !!!");
                Intent myIntent = new Intent(myContext, NextActivity.class);
                startActivity(myIntent);
                MainActivity.this.finish(); // we closed this activity after launch the new one
            }
        });
    }
}
