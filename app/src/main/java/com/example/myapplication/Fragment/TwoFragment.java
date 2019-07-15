package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myapplication.ChatActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoFragment extends Fragment {

    private ListView lv;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        lv = (ListView) view.findViewById(R.id.list_view);	//实例化
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_two, container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new SimpleAdapter(getActivity(), getData(), R.layout.listview,
                new String[]{"img", "id", "message"},
                new int[]{R.id.itemimg, R.id.itemtitle, R.id.itembody});      //配置适配器，并获取对应Item中的ID
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), ChatActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
    //数据的获取@！
    private List<? extends Map<String, ?>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

//将需要的值传入map中
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "爱护小动物");
        map.put("message", "你好啊！！！");
        map.put("img", R.drawable.boy);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("id", "Iris");
        map.put("message", "你好啊！！！");
        map.put("img", R.drawable.qt2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("id", "日行一善");
        map.put("message", "你好");
        map.put("img", R.drawable.woman);
        list.add(map);

        return list;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }




}
