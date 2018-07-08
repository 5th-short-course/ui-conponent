package com.example.rany.uicomponentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etText;
    private TextView tvText;
    private EditText etSearch;

    private SearchView searchView;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText=findViewById(R.id.editText);
        tvText=findViewById(R.id.textView);
        tvText.setText("Korea hrd center");

        searchView=findViewById(R.id.searchView);
        tvResult=findViewById(R.id.searchResult);


        etSearch=findViewById(R.id.etSarch);
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO: 7/8/2018  
                Log.e(TAG, "onKey: "+ ((EditText) v).getText().toString());
                return true;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tvResult.setText(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private static final String TAG = "MainActivity";
}
