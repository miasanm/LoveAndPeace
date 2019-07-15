package com.example.myapplication.Mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class searchActivity extends AppCompatActivity {

    private Button btn_1;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        btn_1 = findViewById(R.id.searchBtn);
        edt = findViewById(R.id.searchBlock);


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt.getText().toString().equals("dog")) {
                    Intent intent = new Intent(searchActivity.this, searchRecycle.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(searchActivity.this, EmputyActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
