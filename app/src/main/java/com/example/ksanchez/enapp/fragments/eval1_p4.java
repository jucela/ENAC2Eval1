package com.example.ksanchez.enapp.fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ksanchez.enapp.BaseDatosTemporal;
import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;

/**
 * A simple {@link Fragment} subclass.
 */
public class eval1_p4 extends Fragment {


    RadioGroup rgP5sp1;
    RadioGroup rgP5sp2;
    RadioGroup rgP5sp3;
    RadioGroup rgP5sp4;
    RadioGroup rgP5sp5;
    RadioGroup rgP5sp6;
    RadioGroup rgP5sp7;
    RadioGroup rgP5sp8;
    RadioGroup rgP5sp9;
    RadioGroup rgP5sp10;

    Context contexto;
    String dni;


    private String P5_1 = "";
    private String P5_2= "";
    private String P5_3= "";
    private String P5_4= "";
    private String P5_5= "";
    private String P5_6= "";
    private String P5_7= "";
    private String P5_8= "";
    private String P5_9= "";
    private String P5_10= "";




    public eval1_p4() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public eval1_p4(Context contexto, String dni) {
        this.contexto = contexto;
        this.dni = dni;
    }

    @SuppressLint("ValidFragment")


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_eval1_p4, container, false);

        rgP5sp1 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg1);
        rgP5sp2 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg2);
        rgP5sp3 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg3);
        rgP5sp4 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg4);
        rgP5sp5 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg5);
        rgP5sp6 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg6);
        rgP5sp7 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg7);
        rgP5sp8 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg8);
        rgP5sp9 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg9);
        rgP5sp10 = (RadioGroup) rootView.findViewById(R.id.e1_p5_rg10);



        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
    }


    public void cargarDatos(){
        Data data = new Data(contexto);
        data.open();
        Respuesta respuesta = data.getRespuesta(dni);
        if(respuesta != null){
            if(!respuesta.getP5_1().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_1());
                ((RadioButton) rgP5sp1.getChildAt(childPos)).setChecked(true);
            }
            if(!respuesta.getP5_2().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_2());
                ((RadioButton) rgP5sp2.getChildAt(childPos)).setChecked(true);
            }
            if(!respuesta.getP5_3().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_3());
                ((RadioButton) rgP5sp3.getChildAt(childPos)).setChecked(true);
            }

            if(!respuesta.getP5_4().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_4());
                ((RadioButton) rgP5sp4.getChildAt(childPos)).setChecked(true);
            }
            if(!respuesta.getP5_5().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_5());
                ((RadioButton) rgP5sp5.getChildAt(childPos)).setChecked(true);
            }
            if(!respuesta.getP5_6().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_6());
                ((RadioButton) rgP5sp6.getChildAt(childPos)).setChecked(true);
            }
            if(!respuesta.getP5_7().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_7());
                ((RadioButton) rgP5sp7.getChildAt(childPos)).setChecked(true);
            }
            if(!respuesta.getP5_8().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_8());
                ((RadioButton) rgP5sp8.getChildAt(childPos)).setChecked(true);
            }

            if(!respuesta.getP5_9().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_9());
                ((RadioButton) rgP5sp9.getChildAt(childPos)).setChecked(true);
            }
            if(!respuesta.getP5_10().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5_10());
                ((RadioButton) rgP5sp10.getChildAt(childPos)).setChecked(true);
            }



        }
        data.close();

    }
    public boolean validarFragment(){
        boolean correcto = true;



        return correcto;
    }

    public void guardarFragment(){
        ContentValues contentValues = new ContentValues();
        if (rgP5sp1.indexOfChild(rgP5sp1.findViewById(rgP5sp1.getCheckedRadioButtonId())) >= 0){
            P5_1 = rgP5sp1.indexOfChild(rgP5sp1.findViewById(rgP5sp1.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_1,P5_1);
        }
        if (rgP5sp2.indexOfChild(rgP5sp2.findViewById(rgP5sp2.getCheckedRadioButtonId())) >= 0){
            P5_2 = rgP5sp2.indexOfChild(rgP5sp2.findViewById(rgP5sp2.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_2,P5_2);
        }
        if (rgP5sp3.indexOfChild(rgP5sp3.findViewById(rgP5sp3.getCheckedRadioButtonId())) >= 0){
            P5_3 = rgP5sp3.indexOfChild(rgP5sp3.findViewById(rgP5sp3.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_3,P5_3);
        }
        if (rgP5sp4.indexOfChild(rgP5sp4.findViewById(rgP5sp4.getCheckedRadioButtonId())) >= 0){
            P5_4 = rgP5sp4.indexOfChild(rgP5sp4.findViewById(rgP5sp4.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_4,P5_4);
        }
        if (rgP5sp5.indexOfChild(rgP5sp5.findViewById(rgP5sp5.getCheckedRadioButtonId())) >= 0){
            P5_5 = rgP5sp5.indexOfChild(rgP5sp5.findViewById(rgP5sp5.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_5,P5_5);
        }
        if (rgP5sp6.indexOfChild(rgP5sp6.findViewById(rgP5sp6.getCheckedRadioButtonId())) >= 0){
            P5_6 = rgP5sp6.indexOfChild(rgP5sp6.findViewById(rgP5sp6.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_6,P5_6);
        }
        if (rgP5sp7.indexOfChild(rgP5sp7.findViewById(rgP5sp7.getCheckedRadioButtonId())) >= 0){
            P5_7 = rgP5sp7.indexOfChild(rgP5sp7.findViewById(rgP5sp7.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_7,P5_7);
        }
        if (rgP5sp8.indexOfChild(rgP5sp8.findViewById(rgP5sp8.getCheckedRadioButtonId())) >= 0){
            P5_8 = rgP5sp8.indexOfChild(rgP5sp8.findViewById(rgP5sp8.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_8,P5_8);
        }

        if (rgP5sp9.indexOfChild(rgP5sp9.findViewById(rgP5sp9.getCheckedRadioButtonId())) >= 0){
            P5_9 = rgP5sp9.indexOfChild(rgP5sp9.findViewById(rgP5sp9.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_9,P5_9);
        }
        if (rgP5sp10.indexOfChild(rgP5sp10.findViewById(rgP5sp10.getCheckedRadioButtonId())) >= 0){
            P5_10 = rgP5sp10.indexOfChild(rgP5sp10.findViewById(rgP5sp10.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5_10,P5_10);
        }


        if(contentValues.size() > 0){
            Data data =  new Data(contexto);
            data.open();
            data.actualizarRespuestas(dni,contentValues);
            data.close();
        }
    }
}
