package com.example.estudiante.clienttriki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button [] botones;
    Comunicacion com;

   // private Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com = new Comunicacion(this);
        com.start();

        botones = new Button[9];

        botones[0] = findViewById(R.id.btn_0);
        botones[1] = findViewById(R.id.btn_1);
        botones[2] = findViewById(R.id.btn_2);
        botones[3] = findViewById(R.id.btn_3);
        botones[4] = findViewById(R.id.btn_4);
        botones[5] = findViewById(R.id.btn_5);
        botones[6] = findViewById(R.id.btn_6);
        botones[7] = findViewById(R.id.btn_7);
        botones[8] = findViewById(R.id.btn_8);

        for(int i=0;i <botones.length;i++){
            final int pos=i;
            botones[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    com.enviarMensaje(pos);
                }
            });
        }

    }

}
