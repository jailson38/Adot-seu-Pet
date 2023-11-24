package com.example.adoteoseupet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListaPets extends AppCompatActivity {

    ListView listaCao;

    Button novoPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pets);
        listaCao = (ListView)  findViewById(R.id.ListviewListapets);

        novoPet =(Button)  findViewById(R.id.buttonListaNovoPet);

        novoPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaPets.this, TelaCadastroPet.class));
            }
        });

        String [] porte = new String[]{"Porte Grande","Porte Médio","Porte Pequeno"};

        ArrayAdapter <String> listaCaoadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,porte);
        listaCao.setAdapter(listaCaoadapter);
    }
}