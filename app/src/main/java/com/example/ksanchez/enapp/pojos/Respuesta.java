package com.example.ksanchez.enapp.pojos;

import android.content.ContentValues;

import com.example.ksanchez.enapp.modelo.SQLConstantes;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class Respuesta {
    private String DNI;
    private String NOMBRES;
    private String APELLIDOS;
    private String AULA;
    private String NOTA;
    private String P1;
    private String P2;
    private String P3_1;
    private String P3_2;
    private String P3_3;
    private String P3_4;
    private String P4;
    private String P5_1;
    private String P5_2;
    private String P5_3;
    private String P5_4;
    private String P5_5;
    private String P5_6;
    private String P5_7;
    private String P5_8;
    private String P5_9;
    private String P5_10;
    private String P5_11;


    public Respuesta() {
        this.DNI = "";
        this.NOMBRES = "";
        this.APELLIDOS = "";
        this.AULA = "";
        this.NOTA = "";
        P1 = "";
        P2 = "";
        P3_1 = "";
        P3_2 = "";
        P3_3 = "";
        P3_4 = "";
        P4 = "";
        P5_1 = "";
        P5_2 = "";
        P5_3 = "";
        P5_4 = "";
        P5_5 = "";
        P5_6 = "";
        P5_7 = "";
        P5_8 = "";
        P5_9 = "";
        P5_10 = "";
        P5_11 = "";

    }

    public Respuesta(String DNI, String NOMBRES, String APELLIDOS, String AULA, String NOTA, String p1, String p2, String p3_1, String p3_2, String p3_3, String p3_4,String p4, String p5_1, String p5_2, String p5_3, String p5_4, String p5_5, String p5_6, String p5_7, String p5_8, String p5_9, String p5_10, String p5_11) {
        this.DNI = DNI;
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
        this.AULA = AULA;
        this.NOTA = NOTA;
        P1 = p1;
        P2 = p2;
        P3_1 = p3_1;
        P3_2 = p3_2;
        P3_3 = p3_3;
        P3_4 = p3_4;
        P4 = p4;
        P5_1 = p5_1;
        P5_2 = p5_2;
        P5_3 = p5_3;
        P5_4 = p5_4;
        P5_5 = p5_5;
        P5_6 = p5_6;
        P5_7 = p5_7;
        P5_8 = p5_8;
        P5_9 = p5_9;
        P5_10 = p5_10;
        P5_11 = p5_11;

    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getAULA() {
        return AULA;
    }

    public void setAULA(String AULA) {
        this.AULA = AULA;
    }

    public String getNOTA() {
        return NOTA;
    }

    public void setNOTA(String NOTA) {
        this.NOTA = NOTA;
    }

    public String getP1() {
        return P1;
    }

    public void setP1(String p1) {
        P1 = p1;
    }

    public String getP2() {
        return P2;
    }

    public void setP2(String p2) {
        P2 = p2;
    }

    public String getP3_1() {
        return P3_1;
    }

    public void setP3_1(String p3_1) {
        P3_1 = p3_1;
    }

    public String getP3_2() {
        return P3_2;
    }

    public void setP3_2(String p3_2) {
        P3_2 = p3_2;
    }

    public String getP3_3() {
        return P3_3;
    }

    public void setP3_3(String p3_3) {
        P3_3 = p3_3;
    }

    public String getP3_4() {
        return P3_4;
    }

    public void setP3_4(String p3_4) {
        P3_4 = p3_4;
    }

    public String getP4() {
        return P4;
    }

    public void setP4(String p4) {
        P4 = p4;
    }

    public String getP5_1() {
        return P5_1;
    }

    public void setP5_1(String p5_1) {
        P5_1 = p5_1;
    }

    public String getP5_2() {
        return P5_2;
    }

    public void setP5_2(String p5_2) {
        P5_2 = p5_2;
    }

    public String getP5_3() {
        return P5_3;
    }

    public void setP5_3(String p5_3) {
        P5_3 = p5_3;
    }

    public String getP5_4() {
        return P5_4;
    }

    public void setP5_4(String p5_4) {
        P5_4 = p5_4;
    }

    public String getP5_5() {
        return P5_5;
    }

    public void setP5_5(String p5_5) {
        P5_5 = p5_5;
    }

    public String getP5_6() {
        return P5_6;
    }

    public void setP5_6(String p5_6) {
        P5_6 = p5_6;
    }

    public String getP5_7() {
        return P5_7;
    }

    public void setP5_7(String p5_7) {
        P5_7 = p5_7;
    }

    public String getP5_8() {
        return P5_8;
    }

    public void setP5_8(String p5_8) {
        P5_8 = p5_8;
    }

    public String getP5_9() {
        return P5_9;
    }

    public void setP5_9(String p5_9) {
        P5_9 = p5_9;
    }

    public String getP5_10() {
        return P5_10;
    }

    public void setP5_10(String p5_10) {
        P5_10 = p5_10;
    }

    public String getP5_11() {
        return P5_11;
    }

    public void setP5_11(String p5_11) {
        P5_11 = p5_11;
    }



    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.ENA_DNI,DNI);
        contentValues.put(SQLConstantes.ENA_NOMBRES,NOMBRES);
        contentValues.put(SQLConstantes.ENA_APELLIDOS,APELLIDOS);
        contentValues.put(SQLConstantes.ENA_AULA,AULA);
        contentValues.put(SQLConstantes.ENA_NOTA,NOTA);
        contentValues.put(SQLConstantes.ENA_P1,P1);
        contentValues.put(SQLConstantes.ENA_P2,P2);
        contentValues.put(SQLConstantes.ENA_P3_1,P3_1);
        contentValues.put(SQLConstantes.ENA_P3_2,P3_2);
        contentValues.put(SQLConstantes.ENA_P3_3,P3_3);
        contentValues.put(SQLConstantes.ENA_P3_4,P3_4);
        contentValues.put(SQLConstantes.ENA_P4,P4);
        contentValues.put(SQLConstantes.ENA_P5_1,P5_1);
        contentValues.put(SQLConstantes.ENA_P5_2,P5_2);
        contentValues.put(SQLConstantes.ENA_P5_3,P5_3);
        contentValues.put(SQLConstantes.ENA_P5_4,P5_4);
        contentValues.put(SQLConstantes.ENA_P5_5,P5_5);
        contentValues.put(SQLConstantes.ENA_P5_6,P5_6);
        contentValues.put(SQLConstantes.ENA_P5_7,P5_7);
        contentValues.put(SQLConstantes.ENA_P5_8,P5_8);
        contentValues.put(SQLConstantes.ENA_P5_9,P5_9);
        contentValues.put(SQLConstantes.ENA_P5_10,P5_10);
        contentValues.put(SQLConstantes.ENA_P5_11,P5_11);

        return contentValues;
    }
}
