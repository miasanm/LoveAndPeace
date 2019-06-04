package com.example.myapplication.Mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyselfActivity extends AppCompatActivity {
    String a = "观爱首席铲屎官";
    String b = "19981010";
    String c = "女";
    String d = "关爱流浪猫狗从我做起";
    TextView idshow,age,sex,sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself);
        idshow = findViewById(R.id.mysellfid);
        age = findViewById(R.id.age);
        sex = findViewById(R.id.sex);
        sign = findViewById(R.id.sign);
        idshow.setText(a);
        age.setText(b);
        sex.setText(c);
        sign.setText(d);
        CountActivity r = new CountActivity();
        try {
            if(r.flag ==0){
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                a = bundle.getString("id");
                b = bundle.getString("Age");
                c = bundle.getString("Sex1");
                d = bundle.getString("sign");
                idshow.setText(a);
                age.setText(b);
                sex.setText(c);
                sign.setText(d);
            }else{
                idshow.setText("关爱首席铲屎官");
                age.setText("19981010");
                sex.setText("女");
                sign.setText("关爱流浪猫狗从我做起");
            }
        }catch(NullPointerException e)
            {
                //do nothing
        }
    }
}
