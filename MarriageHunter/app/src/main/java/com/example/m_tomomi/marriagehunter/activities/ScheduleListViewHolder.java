package com.example.m_tomomi.marriagehunter.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.m_tomomi.marriagehunter.R;

/**
 * Created by m_tomomi on 2016/10/10.
 */

public class ScheduleListViewHolder extends RecyclerView.ViewHolder  {

    View base;

    TextView tvHour;
    TextView tvMinute;
    TextView tvAmpm;
    TextView tvSchedule;

    //TextView textViewComment;
    int mviewType;


    public ScheduleListViewHolder(View v, int viewType) {
        super(v);
        this.base = v;

        this.tvHour = (TextView) v.findViewById(R.id.tv_hour);
        this.tvMinute = (TextView) v.findViewById(R.id.tv_minute);
        this.tvAmpm = (TextView) v.findViewById(R.id.tv_ampm);
        this.tvSchedule = (TextView) v.findViewById(R.id.tv_schedule);

        this.mviewType = viewType;
        //this.textViewComment = (TextView) v.findViewById(R.id.comment);
    }


}
