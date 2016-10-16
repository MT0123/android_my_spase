package com.example.m_tomomi.marriagehunter.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m_tomomi.marriagehunter.R;

import java.util.ArrayList;

/**
 * Created by m_tomomi on 2016/10/10.
 */

public class ScheduleListAdapter extends RecyclerView.Adapter<ScheduleListViewHolder> {

    private ArrayList<ScheduleList> rouletteDataSet;

    // コンストラクタ
    public ScheduleListAdapter(ArrayList<ScheduleList> roulette) {
        this.rouletteDataSet = roulette;
    }


    // 新しいViewを作成する
    // レイアウトマネージャーにより起動される
    @Override
    public ScheduleListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // parentはRecyclerView
        // public View inflate (int resource, ViewGroup root, boolean attachToRoot)

        // 新しいViewを作成する　★cards_layout★
        View view;
        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_schedule_list, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_schedule_calendar, parent, false);
        }

        // Log.d("Anbayasi", parent.toString());
        //AnbayasiViewHolder anbayasiViewHolder = new AnbayasiViewHolder(view);

        //
        return new ScheduleListViewHolder(view, viewType);
    }


    // Viewの内容を交換する（リサイクルだから）
    // レイアウトマネージャーにより起動される
    @Override
    public void onBindViewHolder(final ScheduleListViewHolder holder, final int listPosition) {

        // データをセット
        if (holder.getItemViewType() == 1) {
            holder.tvHour.setText(rouletteDataSet.get(listPosition).getHour());
            holder.tvMinute.setText(rouletteDataSet.get(listPosition).getMinute());
            holder.tvAmpm.setText(rouletteDataSet.get(listPosition).getAmpm());
            holder.tvSchedule.setText(rouletteDataSet.get(listPosition).getSchedule());
        } else {
            //
        }


        //holder.textViewComment.setText(rouletteDataSet.get(listPosition).getComment());

        /*
        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // vはCardView
                Toast.makeText(v.getContext(),"おまけ" +
                        rouletteDataSet.get(listPosition).getAddition()+ "本",Toast.LENGTH_SHORT).show();
            }
        });
        */

    }

    @Override
    public int getItemViewType(int position) {
        // サンプルコードなので手軽に position が偶数の項目と奇数の項目で view type を分ける。
        return rouletteDataSet.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return rouletteDataSet.size();
    }
}
