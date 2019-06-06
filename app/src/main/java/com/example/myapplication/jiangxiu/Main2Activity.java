package com.example.myapplication.jiangxiu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.myapplication.ChatActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Mine.CollectionActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    public LocationClient mLocationClient;
    private TextView positionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());

        positionText = (TextView) findViewById(R.id.position_text_view);
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!((ArrayList) permissionList).isEmpty()) {
            String[] permissions = (String[]) ((ArrayList) permissionList).toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(Main2Activity.this, permissions, 1);
        } else {
            requestLocation();
        }

        //私聊
        ImageButton imageButton1 = findViewById( R.id.talk3 );
        imageButton1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Main2Activity.this, ChatActivity.class );
                startActivity( intent );
            }
        } );

        //收藏
        ImageButton imageButton2 = findViewById( R.id.collect3 );
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Main2Activity.this, CollectionActivity.class );
                startActivity( intent );
            }
        } );

    }

    private void requestLocation() {
        initLocation();
        mLocationClient.start();
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        //option.setLocationMode( LocationClientOption.LocationMode.Device_Sensors );
        option.setScanSpan(5000000);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    public class MyLocationListener extends BDAbstractLocationListener {


        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            StringBuilder currentPosition = new StringBuilder();

            currentPosition.append("").append(bdLocation.getProvince()).append(".");
            currentPosition.append("").append(bdLocation.getCity()).append(".");
            currentPosition.append("").append(bdLocation.getDistrict()).append(".");
            currentPosition.append("").append(bdLocation.getStreet()).append("");
            //currentPosition.append( "纬度：" ).append( bdLocation.getLatitude() ).append( "\n" );
            //currentPosition.append( "经线：" ).append( bdLocation.getLatitude() ).append( "\n" );
            //currentPosition.append( "定位方式：" );
            //if(bdLocation.getLocType() == BDLocation.TypeGpsLocation){
            //currentPosition.append( "GPS" );
            //}else if(bdLocation.getLocType() == BDLocation.TypeNetWorkLocation){
            //currentPosition.append( "网络" );
            //}
            positionText.setText(currentPosition);
        }
    }
}
