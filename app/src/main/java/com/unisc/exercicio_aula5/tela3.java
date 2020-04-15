package com.unisc.exercicio_aula5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class tela3 extends AppCompatActivity {

    private Spinner estados;
    private ListView listView;
    String[] estadosSul = {"Rio Grande do Sul","Santa Catarina","Paraná"};
    String [] rs = {"Porto Alegre","Santa Cruz do Sul","Cachoeira do Sul"};
    String [] sc = {"Florianópolis","Balneário Camboriú","Tubarão"};
    String[] pr = {"Curitiba", "Londrina", "Maringá"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        String nomePassado = getIntent().getStringExtra("nome");
        TextView textView = findViewById(R.id.textview);
        textView.setText("Nome: " + nomePassado);

        listView = findViewById(R.id.listView);

        estados = findViewById(R.id.estados);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, estadosSul);
        estados.setAdapter(adapter);
        estados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Posiçao : " + position, Toast.LENGTH_SHORT).show();
                //int pos = estados.getSelectedItemPosition();
                switch (position){
                    case 0:
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(), R.layout.listalayout, Arrays.asList(rs));
                        listView.setAdapter(adapter1);
                        break;
                    case 1:
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getApplicationContext(), R.layout.listalayout, Arrays.asList(sc));
                        listView.setAdapter(adapter2);
                        break;
                    case 2:
                        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getApplicationContext(), R.layout.listalayout, Arrays.asList(pr));
                        listView.setAdapter(adapter3);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
