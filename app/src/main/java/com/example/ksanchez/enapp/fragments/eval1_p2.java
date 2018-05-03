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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksanchez.enapp.BaseDatosTemporal;
import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.activities.UsuarioActivity;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;

import static com.example.ksanchez.enapp.BaseDatosTemporal.P2;
import static com.example.ksanchez.enapp.BaseDatosTemporal.P3_1;
import static com.example.ksanchez.enapp.BaseDatosTemporal.P3_2;
import static com.example.ksanchez.enapp.BaseDatosTemporal.P3_3;
import static com.example.ksanchez.enapp.BaseDatosTemporal.P3_4;

/**
 * A simple {@link Fragment} subclass.
 */
public class eval1_p2 extends Fragment {


    RadioGroup rgP2;
    Spinner spP3sp1;
    Spinner spP3sp2;
    Spinner spP3sp3;
    Spinner spP3sp4;

    Context contexto;

    public eval1_p2() {
        // Required empty public constructor
    }

    String dni;


    @SuppressLint("ValidFragment")
    public eval1_p2(Context contexto, String dni) {
        this.contexto = contexto;
        this.dni = dni;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_eval1_p2, container, false);
        rgP2 = (RadioGroup) rootView.findViewById(R.id.e1_p2_rg);
        spP3sp1 = (Spinner) rootView.findViewById(R.id.eval1_p3_sp1);
        spP3sp2 = (Spinner) rootView.findViewById(R.id.eval1_p3_sp2);
        spP3sp3 = (Spinner) rootView.findViewById(R.id.eval1_p3_sp3);
        spP3sp4 = (Spinner) rootView.findViewById(R.id.eval1_p3_sp4);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       cargarDatos();

    }

    public void cargarDatos(){
        Data data =  new Data(contexto);
        data.open();
        Respuesta respuesta =  data.getRespuesta(dni);
        data.close();

        if(!respuesta.getP2().equals("")){
            int childPos = Integer.parseInt(respuesta.getP2());
            ((RadioButton)rgP2.getChildAt(childPos)).setChecked(true);
        }



        if(!respuesta.getP3_1().equals("")){
            spP3sp1.setSelection(Integer.parseInt(respuesta.getP3_1()));
        }
        if(!respuesta.getP3_2().equals("")){
            spP3sp2.setSelection(Integer.parseInt(respuesta.getP3_2()));
        }
        if(!respuesta.getP3_3().equals("")){
            spP3sp3.setSelection(Integer.parseInt(respuesta.getP3_3()));
        }
        if(!respuesta.getP3_4().equals("")){
            spP3sp4.setSelection(Integer.parseInt(respuesta.getP3_4()));
        }
    }


    public boolean validarFragment(){
        boolean correcto = true;

        if ( spP3sp1.getSelectedItemPosition()==spP3sp2.getSelectedItemPosition()
            || spP3sp1.getSelectedItemPosition() ==spP3sp3.getSelectedItemPosition() || spP3sp1.getSelectedItemPosition()==spP3sp4.getSelectedItemPosition()
                || spP3sp2.getSelectedItemPosition()==spP3sp3.getSelectedItemPosition() || spP3sp2.getSelectedItemPosition()==spP3sp4.getSelectedItemPosition()
                || spP3sp3.getSelectedItemPosition()==spP3sp4.getSelectedItemPosition()
                )
        {
            correcto=false;
            Toast.makeText(getActivity(),"Las respuestas no deben coincidir",Toast.LENGTH_SHORT).show();
        }

        return correcto;
    }

    public void guardarFragment(){

        ContentValues contentValues =  new ContentValues();

        if(rgP2.indexOfChild(rgP2.findViewById(rgP2.getCheckedRadioButtonId())) >= 0){
            P2 = rgP2.indexOfChild(rgP2.findViewById(rgP2.getCheckedRadioButtonId())) + "";

            contentValues.put(SQLConstantes.ENA_P2, P2);
        }

        P3_1 = spP3sp1.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.ENA_P3_1, P3_1);
        P3_2 = spP3sp2.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.ENA_P3_2, P3_2);
        P3_3 = spP3sp3.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.ENA_P3_3, P3_3);
        P3_4 = spP3sp4.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.ENA_P3_4, P3_4);

        if(contentValues.size() > 0){
            Data data =  new Data(contexto);
            data.open();
            data.actualizarRespuestas(dni,contentValues);
            data.close();
        }


    }
}
