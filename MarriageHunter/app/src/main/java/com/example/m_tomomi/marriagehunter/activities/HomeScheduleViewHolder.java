package com.example.m_tomomi.marriagehunter.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.m_tomomi.marriagehunter.R;

/**
 * Created by m_tomomi on 2016/10/09.
 */

public class HomeScheduleViewHolder extends RecyclerView.ViewHolder  {

    View base;

    TextView tvDate;
    TextView tvDays;
    TextView tvTime;
    TextView tvSchedule;

    //TextView textViewComment;
    int mviewType;

    public HomeScheduleViewHolder(View v, int viewType) {
        super(v);
        this.base = v;

        this.tvDate = (TextView) v.findViewById(R.id.tv_date);
        this.tvDays = (TextView) v.findViewById(R.id.tv_days);
        this.tvTime = (TextView) v.findViewById(R.id.tv_time);
        this.tvSchedule = (TextView) v.findViewById(R.id.tv_schedule);

        this.mviewType = viewType;
        //this.textViewComment = (TextView) v.findViewById(R.id.comment);
    }


}
