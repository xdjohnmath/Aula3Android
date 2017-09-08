package com.example.aluno.aula3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button   button;
    ListView listView;

    List <String> lista;

    ArrayAdapter adapter ;                                                               //Cria-se o adaptador para converter a lista em ListView

    final String TAG        = "CADASTRO_ALUNO";                                         //TAGS como playerprefs para salvar os dados e retornar
    final String ALUNOSKEY  = "Lista";

    int adapterLayout = android.R.layout.simple_list_item_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button   = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);

        lista = new ArrayList<String>();                                                //criar uma nova lista

        adapter = new ArrayAdapter <String>(this, adapterLayout, lista);                 //vincula o adaptador ao arraylist

        listView.setAdapter (adapter);                                                   //vincula o adaptador ao listview


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lista.add(editText.getText().toString());                               //adiciona um item à lista

                editText.setText("");                                                   //limpa a lista para um novo item

                adapter.notifyDataSetChanged();                                         //o adaptador recebe as mudanças e envia ao listview

            }
        });
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putStringArrayList(ALUNOSKEY, (ArrayList<String>) lista);    //salva os dados da activity
        super.onSaveInstanceState(savedInstanceState);

        Log.i(TAG, "onSaveInstanceState()"+lista);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {                  //retorna os dados salvos
        super.onRestoreInstanceState(savedInstanceState);
        lista = savedInstanceState.getStringArrayList(ALUNOSKEY);

        adapter = new ArrayAdapter <String>(this, adapterLayout, lista);                //exibe a listview novamente

        listView.setAdapter (adapter);

        Log.i(TAG, "onResumeInstanceState()"+lista);
    }
}
