package com.example.adoteoseupet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class ListaPets extends AppCompatActivity {
    DatabaseHelper helper;

    ArrayList<Pets> petscadastrados;

    ListView listaCao;

    Button novoPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pets);

        helper = new DatabaseHelper(this);

        petscadastrados = new ArrayList<Pets>();


        listaCao = (ListView)  findViewById(R.id.ListviewListapets);

        novoPet =(Button)  findViewById(R.id.buttonListaNovoPet);

        novoPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaPets.this, TelaCadastroPet.class));
            }
        });

        ArrayAdapter <String> listaCaoadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lerPets());
        listaCao.setAdapter(listaCaoadapter);
    }

    private String [] lerPets(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id,pets,quantidade,tipo,port from pets",null);
        cursor.moveToFirst();
        String [] petslidos = new String[cursor.getColumnCount()];
        for (int item = 0; item <cursor.getCount();item++){
           petscadastrados.add(new Pets(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4)));
           petslidos[item] = cursor.getString(1);
        }
        cursor.close();

        return petslidos;
    }
}