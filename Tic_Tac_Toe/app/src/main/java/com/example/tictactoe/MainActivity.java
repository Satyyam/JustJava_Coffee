package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
    public static final String EXTRA_MESSAGE1 = "com.example.codewithsatyam.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.codewithsatyam.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void play(View view) {
        EditText p1name = findViewById(R.id.p1name);
        String  player1name = p1name.getText().toString();
        EditText p2name = findViewById(R.id.p2name);
        String player2name = p2name.getText().toString();
        Intent intent = new Intent(MainActivity.this, game.class);
        intent.putExtra(EXTRA_MESSAGE1, player1name);
        intent.putExtra(EXTRA_MESSAGE2, player2name);
        startActivity(intent);
    }
}
