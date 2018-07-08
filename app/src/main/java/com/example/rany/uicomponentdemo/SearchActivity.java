package com.example.rany.uicomponentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity
implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener{

    private SearchView searchView;
    private TextView tvResult;
    private Button btnTextOnly;
    private ImageButton btnImage;

    private CheckBox chiOS,chJava,chAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView =findViewById(R.id.searchView);
        tvResult=findViewById(R.id.searchResult);
        btnTextOnly=findViewById(R.id.btnTextonly);
        btnImage=findViewById(R.id.btnImage);
        //checkbox
        chiOS=findViewById(R.id.checkBox);
        chJava=findViewById(R.id.checkBox2);
        chAndroid=findViewById(R.id.checkBox3);

        btnImage.setOnClickListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tvResult.setText(query.toString());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tvResult.setText(newText.toString());
                return true;
            }
        });

        //register button event
        btnTextOnly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "button click", Toast.LENGTH_SHORT).show();

            }
        });

        //register checkbox event
        chiOS.setOnCheckedChangeListener(this);
        chAndroid.setOnCheckedChangeListener(this);
        chJava.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnImage){

            Toast.makeText(this, "Image button click", Toast.LENGTH_SHORT).show();

        }
        if (v.getId()==R.id.btnTextonly){

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        CheckBox ch= (CheckBox) buttonView;
        switch (buttonView.getId()){
            case R.id.checkBox:
                doCheckbox(ch,isChecked);
               break;
            case R.id.checkBox2:
                /*if(isChecked)
                    showMessage(ch.getText().toString() +" check");
                else
                    showMessage(ch.getText().toString()+" uncheck");*/
                doCheckbox(ch,isChecked);
                break;
            case R.id.checkBox3:
               /* if(isChecked)
                    showMessage(ch.getText().toString() +" check");
                else
                    showMessage(ch.getText().toString()+" uncheck");*/
                doCheckbox(ch,isChecked);
                break;
        }
    }

    void doCheckbox(CheckBox ch,boolean isChecked){
        if(isChecked)
            showMessage(ch.getText().toString() +" check");
        else
            showMessage(ch.getText().toString()+" uncheck");
    }

    void showMessage(String smg){
        Toast.makeText(this, smg, Toast.LENGTH_SHORT).show();
    }
}
