package com.example.myapplication.Mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.R;

public class CountActivity extends AppCompatActivity{
   public EditText countid,agetext,sign;
    private Button countSubimt;
    private RadioGroup malecheck;
    private RadioButton male,female;
    String sex;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        countid = findViewById(R.id.count_id);
        agetext = findViewById(R.id.agetext);
        sign = findViewById(R.id.sign);
        countSubimt = findViewById(R.id.countsubmit);
        malecheck = findViewById(R.id.malecheck);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        malecheck.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               if(male.getId()==checkedId){
                   sex = male.getText().toString();
               }else if(female.getId()==checkedId){
                   sex = female.getText().toString();
               }
            }
        });


        countSubimt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String idcount = countid.getText().toString();
               String age = agetext.getText().toString();
               String Sign = sign.getText().toString();
               String Sex = sex;
               if(!"".equals(idcount)&&!"".equals(age)&&!"".equals(Sign)&&!"".equals(Sex)) {
                   Intent intent2 = new Intent(CountActivity.this,MyselfActivity.class);
                   Bundle bundle = new Bundle();
                   bundle.putString("id",idcount);
                   bundle.putString("Age",age);
                   bundle.putString("sign",Sign);
                   bundle.putString("sex1",Sex);
                   intent2.putExtras(bundle);
                   startActivity(intent2);//myself中的id

                   Toast.makeText(CountActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                   flag=1;
               }else {
                   Toast.makeText(CountActivity.this, "请填写完整", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }

}
