package com.example.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Mine.CircleImageView;
import com.example.myapplication.Mine.CollectionActivity;
import com.example.myapplication.Mine.ConnectMeActivity;
import com.example.myapplication.Mine.CountActivity;
import com.example.myapplication.Mine.MyselfActivity;
import com.example.myapplication.Mine.SetingActivity;
import com.example.myapplication.R;



public class ThreeFragment extends Fragment {

    CircleImageView Head_icon;
    TextView Seting,Collection,Count,ConnectMe,name_id;
    CountActivity co = new CountActivity();
    String str;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Head_icon = getActivity().findViewById(R.id.Head_icon);
        Seting = getActivity().findViewById(R.id.Seting);
        Collection = getActivity().findViewById(R.id.Collection);
        Count = getActivity().findViewById(R.id.Count);
        ConnectMe = getActivity().findViewById(R.id.connectme);

        SetListeners();
    }

    private void SetListeners(){
        OnClik onclik = new OnClik();
        Head_icon.setOnClickListener(onclik);
        Seting.setOnClickListener(onclik);
        Collection.setOnClickListener(onclik);
        Count.setOnClickListener(onclik);
        ConnectMe.setOnClickListener(onclik);

    }

    private class  OnClik implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.Seting:
                    intent = new Intent(getActivity(), SetingActivity.class);
                    break;
                case R.id.Head_icon:
                    intent = new Intent(getActivity(), MyselfActivity.class);
                    break;
                case R.id.Count:
                    intent = new Intent(getActivity(), CountActivity.class);
                    break;
                case R.id.Collection:
                    intent = new Intent(getActivity(), CollectionActivity.class);
                    break;
                case R.id.connectme:
                    intent = new Intent(getActivity(), ConnectMeActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}
