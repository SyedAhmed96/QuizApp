package com.example.ahmed.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startQuiz = (Button) findViewById(R.id.startQuiz);

        startQuiz.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Quiz.class);
                startActivity(i);
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.exit:
                System.exit(0);
                break;
        }
        return true;
    }

}