package com.example.ksanchez.enapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.NumericKeyBoardTransformationMethod;
import com.example.ksanchez.enapp.modelo.Data;

public class MainActivity extends AppCompatActivity {

    EditText txtToken;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtToken = (EditText) findViewById(R.id.txtToken);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        txtToken.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        txtToken.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});


        Data data = new Data(MainActivity.this);
        data.open();


        if ( data.consultarregistro()){
            btnIngresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String token = txtToken.getText().toString();

                    if(!token.equals("")){
                        if(token.equals("32186")){
                            Intent intent = new Intent(MainActivity.this, UsuarioActivity.class);
                            startActivity(intent);
                            finish();
                        }else Toast.makeText(MainActivity.this, "Token incorrecto", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(MainActivity.this, "Debe indicar token", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            Toast.makeText(MainActivity.this, "Ya se dió una prueba en esta tablet", Toast.LENGTH_SHORT).show();
        }
        data.close();

    }
    }


