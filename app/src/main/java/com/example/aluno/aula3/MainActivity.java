package com.example.aluno.aula3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button   button;
    ListView listView;

    List <String> lista;

    ArrayAdapter adapter ;

    int adapterLayout = android.R.layout.simple_list_item_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button   = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);

        lista = new ArrayList<String>();

        adapter = new ArrayAdapter <String>(this, adapterLayout, lista);

        listView.setAdapter (adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lista.add(editText.getText().toString());

                editText.setText("");

                adapter.notifyDataSetChanged();


            }
        });

    }
}
