package com.example.ksanchez.enapp.modelo;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class SQLConstantes {
    public static final String dbName = "ena.db";
    public static final String tablaRespuestas = "respuestas";

    //COLUMNAS
    public static final String ENA_DNI = "DNI";
    public static final String ENA_NOMBRES = "NOMBRES";
    public static final String ENA_APELLIDOS = "APELLIDOS";
    public static final String ENA_AULA = "AULA";
    public static final String ENA_NOTA = "NOTA";
    public static final String ENA_P1 = "P1";
    public static final String ENA_P2 = "P2";
    public static final String ENA_P3_1 = "P3_1";
    public static final String ENA_P3_2 = "P3_2";
    public static final String ENA_P3_3 = "P3_3";
    public static final String ENA_P3_4 = "P3_4";
    public static final String ENA_P4 = "P4";
    public static final String ENA_P5_1 = "P5_1";
    public static final String ENA_P5_2 = "P5_2";
    public static final String ENA_P5_3 = "P5_3";
    public static final String ENA_P5_4 = "P5_4";
    public static final String ENA_P5_5 = "P5_5";
    public static final String ENA_P5_6 = "P5_6";
    public static final String ENA_P5_7 = "P5_7";
    public static final String ENA_P5_8 = "P5_8";
    public static final String ENA_P5_9 = "P5_9";
    public static final String ENA_P5_10 = "P5_10";
    public static final String ENA_P5_11 = "P5_11";



    public static final String SQL_CREATE_TABLA_PREGUNTAS =
            "CREATE TABLE " + tablaRespuestas + "(" +
                    ENA_DNI + " TEXT PRIMARY KEY," +
                    ENA_NOMBRES + " TEXT," +
                    ENA_APELLIDOS + " TEXT," +
                    ENA_AULA + " TEXT," +
                    ENA_NOTA + " TEXT," +
                    ENA_P1 + " TEXT," +
                    ENA_P2 + " TEXT," +
                    ENA_P3_1 + " TEXT," +
                    ENA_P3_2 + " TEXT," +
                    ENA_P3_3 + " TEXT," +
                    ENA_P3_4 + " TEXT," +

                    ENA_P4 + " TEXT," +

                    ENA_P5_1 + " TEXT," +
                    ENA_P5_2 + " TEXT," +
                    ENA_P5_3 + " TEXT," +
                    ENA_P5_4 + " TEXT," +
                    ENA_P5_5 + " TEXT," +
                    ENA_P5_6 + " TEXT," +
                    ENA_P5_7 + " TEXT," +
                    ENA_P5_8 + " TEXT," +
                    ENA_P5_9 + " TEXT," +
                    ENA_P5_10 + " TEXT," +

                    ENA_P5_11 + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_TABLA_PREGUNTAS = "DROP TABLE " + tablaRespuestas;

    public static final String WHERE_CLAUSE_DNI = "DNI=?";


}
