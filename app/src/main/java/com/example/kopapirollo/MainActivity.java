package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView playersImage;
    private ImageView computersImage;
    private TextView playersPoints;
    private TextView computersPoints;
    private Button koGomb;
    private Button olloGomb;
    private Button papirGomb;
    private int valasztas;
    private Random rnd;
    private int gepValasztasa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();
    }

    private void init() {
        playersImage.findViewById(R.id.playersImage);
        computersImage.findViewById(R.id.computersImage);
        playersPoints.findViewById(R.id.playersPoints);
        computersPoints.findViewById(R.id.computersPoints);
        koGomb.findViewById(R.id.koGomb);
        papirGomb.findViewById(R.id.papirGomb);
        olloGomb.findViewById(R.id.olloGomb);
        valasztas = -1;
    }

    private void addListeners() {
        koGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valasztas = 0;
                ComputerGenerate();
                playersImage.setImageResource(R.drawable.rock);
                if (valasztas==gepValasztasa) {
                    Toast.makeText(getApplicationContext(),"Döntetlen",Toast.LENGTH_SHORT).show();
                } else if (gepValasztasa==1){
                    Toast.makeText(getApplicationContext(),"Vesztettél!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Nyertél!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        papirGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valasztas = 1;
                ComputerGenerate();
                playersImage.setImageResource(R.drawable.paper);
                if (valasztas==gepValasztasa) {
                    Toast.makeText(getApplicationContext(),"Döntetlen",Toast.LENGTH_SHORT).show();
                } else if (gepValasztasa==2){
                    Toast.makeText(getApplicationContext(),"Vesztettél!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Nyertél!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        olloGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valasztas = 2;
                ComputerGenerate();
                playersImage.setImageResource(R.drawable.scissors);
                if (valasztas==gepValasztasa) {
                    Toast.makeText(getApplicationContext(),"Döntetlen",Toast.LENGTH_SHORT).show();
                } else if (gepValasztasa==0){
                    Toast.makeText(getApplicationContext(),"Vesztettél!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Nyertél!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ComputerGenerate() {
        rnd = new Random(3);
        gepValasztasa = rnd.nextInt();
        if (gepValasztasa == 0) {
            computersImage.setImageResource(R.drawable.rock);
        } else if (gepValasztasa==1) {
            computersImage.setImageResource(R.drawable.paper);
        } else if (gepValasztasa==2){
            computersImage.setImageResource(R.drawable.scissors);
        } else {
            Toast.makeText(getApplicationContext(),"Hiba!",Toast.LENGTH_SHORT).show();
        }
    }
}