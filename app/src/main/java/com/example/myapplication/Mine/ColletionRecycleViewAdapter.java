package com.example.myapplication.Mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

public class ColletionRecycleViewAdapter extends RecyclerView.Adapter<ColletionRecycleViewAdapter.CountViewHolder> {
    @NonNull
    private Context collectioncontext;
    public ColletionRecycleViewAdapter(Context context){
        this.collectioncontext = context;
    }
    @Override
    public ColletionRecycleViewAdapter.CountViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new CountViewHolder(LayoutInflater.from(collectioncontext).inflate(R.layout.collec_recycle_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ColletionRecycleViewAdapter.CountViewHolder viewHolder, int i) {
        viewHolder.textview.setText("震惊，噬元兽开始侵略地球，人类缺并未反抗，欣然接受........");
    }

    @Override
    public int getItemCount() {

        return 30;   //暂时固定，数据库出来调动数据库中的收藏帖子数
    }
    class CountViewHolder extends RecyclerView.ViewHolder{
        private TextView textview;
        public CountViewHolder(@NonNull View itemView) {

            super(itemView);
            textview = itemView.findViewById(R.id.countrecycleitem);
        }
    }
}
