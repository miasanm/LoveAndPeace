package com.example.myapplication.Mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class SetingActivity extends AppCompatActivity {

    private Button changecountsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seting);
        changecountsubmit = findViewById(R.id.changecountsubmit);
        changecountsubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(SetingActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
