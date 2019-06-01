package com.example.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.ui.login.LoginActivity;


public class RegistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        final Button registButton = (Button)findViewById(R.id.regist1);

        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(intent2);
                Toast.makeText(RegistActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
