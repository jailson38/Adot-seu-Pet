package com.example.adoteoseupet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaCadastroPet extends AppCompatActivity {

    DatabaseHelper helper;

    EditText raca;
    EditText quantidade;

    Spinner tipo;
    Spinner porte;
    Button salvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_pet);

        raca = findViewById(R.id.editTextTextTelaCadastroPetsRaca);
        quantidade = findViewById(R.id.editTextTextTelaCadastroPetsQuntidade);
        tipo = findViewById(R.id.spinnerTelaCadastroPetsTipo);
        porte = findViewById(R.id.spinnerTelaCadatroPetsPorte);
        salvar = findViewById(R.id.buttonTelaCadastroPetesSalva);
        helper = new DatabaseHelper(this);

        raca.setText("");
        quantidade.setText("");

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvaPets(view);
            }
        });

    }

    public void salvaPets(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        if(raca.getText().length() >0 && quantidade.getText().length() >0)
        {


        valores.put("raca",raca.getText().toString());
        valores.put("quantidade",quantidade.getText().toString());
        valores.put("tipo",tipo.getSelectedItem().toString());
        valores.put("porte",porte.getSelectedItem().toString());


        long resultado = db.insert( "pets",null, valores);
        if (resultado != -1 ){
            Toast.makeText(this, getString(R.string.activity_tela_cadastro_pets_salvo_com_sucesso),Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, getString(R.string.activite_tela_cadastro_pets_erro_ao_salva), Toast.LENGTH_SHORT).show();

        }

        } else
        {
            Toast.makeText(this,getString(R.string.activity_tela_cadastros_pets_campos_vazios),Toast.LENGTH_SHORT).show();
        }

    }

}