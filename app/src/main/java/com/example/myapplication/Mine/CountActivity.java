package com.example.myapplication.Mine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CountActivity extends AppCompatActivity{
    private EditText countid,agetext,sign;
    private Button countSubimt;
    private RadioGroup malecheck;
    private RadioButton male,female;
    private SharedPreferences countshare;
    private SharedPreferences.Editor countEditor;
    private CircleImageView countheadicon;
    private static String path = "/sdcar//myHead/";
    private Bitmap head;// 头像Bitmap
    String sex;
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
        countheadicon = findViewById(R.id.CountHead_icon);
        countshare = getSharedPreferences("count",MODE_PRIVATE);
        countEditor = countshare.edit();


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
                countEditor.putString("id", countid.getText().toString());
                countEditor.putString("性别", sex);
                countEditor.putString("年龄", agetext.getText().toString());
                countEditor.putString("个性签名", sign.getText().toString());
                countEditor.apply();
                Toast.makeText(CountActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
            }
        });

        countheadicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTypeDialog();
            }
        });
    }
    private void showTypeDialog() {
        //显示对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(CountActivity.this);
        final AlertDialog dialog = builder.create();
        View view = View.inflate(CountActivity.this, R.layout.dialog_select_photo, null);
        TextView tv_select_gallery = (TextView) view.findViewById(R.id.tv_select_gallery);
        TextView tv_select_camera = (TextView) view.findViewById(R.id.tv_select_camera);
        tv_select_gallery.setOnClickListener(new View.OnClickListener() {// 在相册中选取
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                //打开文件
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent1, 1);
                dialog.dismiss();
            }
        });
        tv_select_camera.setOnClickListener(new View.OnClickListener() {// 调用照相机
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent2.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
                startActivityForResult(intent2, 2);// 采用ForResult打开
                dialog.dismiss();
            }
        });
        dialog.setView(view);
        dialog.show();
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if (head != null) {
                        setPicToView(head);// 保存在SD卡中
                        Drawable drawable = new BitmapDrawable(head);
                        countheadicon.setBackground(drawable);// 用ImageButton显示出来
                    }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
