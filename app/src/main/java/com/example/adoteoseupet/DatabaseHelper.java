package com.example.adoteoseupet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String BANCO_DADOS_NOME = "adotseupet";
    private static int BANCO_DADOS_VERSAO = 1;

    public DatabaseHelper(Context context){
        super(context, BANCO_DADOS_NOME,null,BANCO_DADOS_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE pets(.id INTEGGER PRIMARY KEY,maca TEXT, quantidade INTEGER, tipo Text, parte TEXT);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAnterior, int versaoproxima){

    }

}
