package com.example.myapplication.Mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyselfActivity extends AppCompatActivity {
    String a = "观爱首席铲屎官";
    TextView idshow,age,sex,sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself);
        idshow = findViewById(R.id.mysellfid);
        idshow.setText(a);
        CountActivity r = new CountActivity();
        try {
            if(r.flag ==0){
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                a = bundle.getString("id");
                idshow.setText(a);
            }else{
                idshow.setText("关爱首席铲屎官");
            }
        }catch(NullPointerException e)
        {
            //do nothing
        }
    }
}
