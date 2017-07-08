package com.quickie.sqlitewihrecyclerview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.quickie.sqlitewihrecyclerview.R;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.btn1);
        b2=(Button) findViewById(R.id.btn2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // BackgroundTask backgroundTask = new BackgroundTask(MainActivity.this);
                 // backgroundTask.execute();

                startActivity(new Intent(MainActivity.this,FragmentActivity.class));


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,DisplayList.class));

            }
        });
    }
}
