package com.example.ksanchez.enapp.activities;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;

import com.example.ksanchez.enapp.BaseDatosTemporal;
import com.example.ksanchez.enapp.IOHelper;
import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.Solucionario;
import com.example.ksanchez.enapp.fragments.eval1_p1;
import com.example.ksanchez.enapp.fragments.eval1_p2;
import com.example.ksanchez.enapp.fragments.eval1_p3;
import com.example.ksanchez.enapp.fragments.eval1_p4;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Timer;
import java.util.TimerTask;

import static android.os.Environment.getExternalStorageDirectory;

public class EvaluacionActivity extends AppCompatActivity {

    Button btnFinalizar, btnSiguiente, btnAnterior;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragmentActual;
    String dni = "";
    int contador = 1;
    final int TIEMPO = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnAnterior = (Button) findViewById(R.id.btnAnterior);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);


        Bundle bundle = getIntent().getExtras();
        dni = bundle.getString("dni");

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador + 1 <=4){
                    if(validarFragment(contador)){
                        guardarFragment(contador);
                        contador++;
                        setFragment(contador,1);
                    }

                }
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador - 1 > 0) {
                    guardarFragment(contador);
                    contador--;setFragment(contador,-1);
                }
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                //calcular nota
                finalizar();
            }
        });

        setFragment(1,1);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                finalizar();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, TIEMPO*60*1000);
    }



    public boolean validarFragment(int numFragment){
        boolean correcto = false;
        switch (numFragment){
            case 1:
                eval1_p1 eval1_p1 = (eval1_p1) fragmentActual;
                correcto=eval1_p1.validarFragment();
                break;
            case 2:
                eval1_p2 eval1_p2 = (eval1_p2) fragmentActual;
                correcto=eval1_p2.validarFragment();
                break;
            case 3:
                eval1_p3 eval1_p3 = (eval1_p3) fragmentActual;
                correcto=eval1_p3.validarFragment();
                break;
            case 4:
                eval1_p4 eval1_p4 = (eval1_p4) fragmentActual;
                correcto=eval1_p4.validarFragment();
                break;
        }
        return correcto;
    }


    void escribirCampoXml(XmlSerializer s, String campo,String valor){
        try {
            s.startTag("", campo);
            if(valor != null) s.text(valor);
            else s.text("");
            s.endTag("", campo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFragment(int numFragment,int direccion){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if(direccion > 0){
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }else{
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        }
        switch (numFragment){
            case 1:
                btnFinalizar.setVisibility(View.GONE);
                fragmentActual = new eval1_p1(EvaluacionActivity.this, dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina1");
                break;
            case 2:
                btnFinalizar.setVisibility(View.GONE);
                fragmentActual = new eval1_p2(EvaluacionActivity.this,dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina2");
                break;
            case 3:
                btnFinalizar.setVisibility(View.GONE);
                fragmentActual = new eval1_p3(EvaluacionActivity.this,dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina3");
                break;

            case 4:
                btnFinalizar.setVisibility(View.VISIBLE);
                fragmentActual = new eval1_p4(EvaluacionActivity.this,dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina4");
                break;
        }
        fragmentTransaction.commit();
    }

    public void guardarFragment(int numFragment){
        switch (numFragment){
            case 1:
                eval1_p1 eval1_p1 = (eval1_p1) fragmentActual;
                eval1_p1.guardarFragment();
                break;
            case 2:
                eval1_p2 eval1_p2 = (eval1_p2) fragmentActual;
                eval1_p2.guardarFragment();
                break;

            case 3:
                eval1_p3 eval1_p3 = (eval1_p3) fragmentActual;
                eval1_p3.guardarFragment();
                break;
            case 4:
                eval1_p4 eval1_p4 = (eval1_p4) fragmentActual;
                eval1_p4.guardarFragment();
                break;
        }
    }

    @SuppressLint("NewApi")
    public void finalizar(){
        guardarFragment(contador);
        Data data = new Data(EvaluacionActivity.this);
        data.open();
        Respuesta respuesta = data.getRespuesta(dni);

        double nota = 0;
        //comprobar pregunta 1
        if(respuesta.getP1().equals(Solucionario.P1)) nota = nota + 2;
        //comprobar pregunta 2
        if(respuesta.getP2().equals(Solucionario.P2)) nota = nota + 2;
        //comprobar pregunta 3
        double puntos = 0;
        if(respuesta.getP3_1().equals(Solucionario.P3_1)) puntos++;
        if(respuesta.getP3_2().equals(Solucionario.P3_2)) puntos++;
        if(respuesta.getP3_3().equals(Solucionario.P3_3)) puntos++;
        if(respuesta.getP3_4().equals(Solucionario.P3_4)) puntos++;
        nota = nota + (puntos / 4) * 2;
        //comprobar pregunta 4
        if(respuesta.getP4().equals(Solucionario.P4)) nota = nota + 4;
        //comprobar pregunta 5
        if(respuesta.getP5_1().equals(Solucionario.P5_1)) nota++;
        if(respuesta.getP5_2().equals(Solucionario.P5_2)) nota++;
        if(respuesta.getP5_3().equals(Solucionario.P5_3)) nota++;
        if(respuesta.getP5_4().equals(Solucionario.P5_4)) nota++;
        if(respuesta.getP5_5().equals(Solucionario.P5_5)) nota++;
        if(respuesta.getP5_6().equals(Solucionario.P5_6)) nota++;
        if(respuesta.getP5_7().equals(Solucionario.P5_7)) nota++;
        if(respuesta.getP5_8().equals(Solucionario.P5_8)) nota++;
        if(respuesta.getP5_9().equals(Solucionario.P5_9)) nota++;
        if(respuesta.getP5_10().equals(Solucionario.P5_10)) nota++;

        respuesta.setNOTA(String.valueOf(nota));
        data.actualizarRespuestas(dni,respuesta.toValues());

        data.close();
        String nombreArchivo =  respuesta.getDNI()+ "E1"+ ".xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "RESPUESTAS");
            serializer.attribute("", "dni", respuesta.getDNI());
            escribirCampoXml(serializer, SQLConstantes.ENA_DNI, respuesta.getDNI());
           // escribirCampoXml(serializer, SQLConstantes.ENA_NOMBRES, respuesta.getNOMBRES());
           // escribirCampoXml(serializer, SQLConstantes.ENA_APELLIDOS, respuesta.getAPELLIDOS());
            escribirCampoXml(serializer, SQLConstantes.ENA_AULA, respuesta.getAULA());
         //   escribirCampoXml(serializer, SQLConstantes.ENA_NOTA, respuesta.getNOTA());
            escribirCampoXml(serializer, SQLConstantes.ENA_P1, respuesta.getP1());
            escribirCampoXml(serializer, SQLConstantes.ENA_P2, respuesta.getP2());
            escribirCampoXml(serializer, SQLConstantes.ENA_P3_1, respuesta.getP3_1());
            escribirCampoXml(serializer, SQLConstantes.ENA_P3_2, respuesta.getP3_2());
            escribirCampoXml(serializer, SQLConstantes.ENA_P3_3, respuesta.getP3_3());
            escribirCampoXml(serializer, SQLConstantes.ENA_P3_4, respuesta.getP3_4());

            escribirCampoXml(serializer, SQLConstantes.ENA_P4, respuesta.getP4());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_1, respuesta.getP5_1());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_2, respuesta.getP5_2());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_3, respuesta.getP5_3());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_4, respuesta.getP5_4());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_5, respuesta.getP5_5());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_6, respuesta.getP5_6());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_7, respuesta.getP5_7());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_8, respuesta.getP5_8());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_9, respuesta.getP5_9());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5_10, respuesta.getP5_10());




            serializer.endTag("", "RESPUESTAS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "ENA_EVALUACION_1_2018");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finishAffinity();
    }


}
