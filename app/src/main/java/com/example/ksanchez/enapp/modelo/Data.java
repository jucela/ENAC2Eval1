package com.example.ksanchez.enapp.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ksanchez.enapp.pojos.Respuesta;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class Data {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelper(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public long getNumeroItemsRespuestas(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tablaRespuestas);
    }

    public void insertarRespuesta(Respuesta respuesta){
        sqLiteDatabase.insert(SQLConstantes.tablaRespuestas,null,respuesta.toValues());
    }

    public Respuesta getRespuesta(String dni){
        Respuesta respuesta = null;
        String[] whereArgs = new String[]{dni};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaRespuestas, null,SQLConstantes.WHERE_CLAUSE_DNI,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                respuesta = new Respuesta();
                respuesta.setDNI(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_DNI)));
                respuesta.setNOMBRES(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_NOMBRES)));
                respuesta.setAPELLIDOS(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_APELLIDOS)));
                respuesta.setAULA(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_AULA)));
                respuesta.setNOTA(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_NOTA)));
                respuesta.setP1(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P1)));
                respuesta.setP2(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P2)));
                respuesta.setP3_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P3_1)));
                respuesta.setP3_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P3_2)));
                respuesta.setP3_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P3_3)));
                respuesta.setP3_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P3_4)));
                respuesta.setP4(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P4)));
                respuesta.setP5_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_1)));
                respuesta.setP5_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_2)));
                respuesta.setP5_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_3)));
                respuesta.setP5_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_4)));
                respuesta.setP5_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_5)));
                respuesta.setP5_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_6)));
                respuesta.setP5_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_7)));
                respuesta.setP5_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_8)));
                respuesta.setP5_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_9)));
                respuesta.setP5_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_10)));
                respuesta.setP5_11(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5_11)));

            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return respuesta;
    }

    public void actualizarRespuestas(String dni, ContentValues contentValues){
        String[] whereArgs = new String[]{dni};
        sqLiteDatabase.update(SQLConstantes.tablaRespuestas,contentValues,SQLConstantes.WHERE_CLAUSE_DNI,whereArgs);
    }

    public boolean consultarregistro(){


        boolean correcto = true;
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaRespuestas,null,null,null,null,null,null);

            if (cursor !=null) {
                if (cursor.getCount() > 0) {


                    correcto = false;

                }
            }
        }
        finally{
            if(cursor != null) cursor.close();
        }

        return correcto;

    }

}
