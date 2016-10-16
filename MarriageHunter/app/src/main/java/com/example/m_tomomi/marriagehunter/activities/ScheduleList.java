package com.example.m_tomomi.marriagehunter.activities;

/**
 * Created by m_tomomi on 2016/10/10.
 */

public class ScheduleList {
    // メンバ変数
    private String mHour;       // 時
    private String mMinute;     // 分
    private String mAmPm;       // 午前・午後
    private String mSchedule;  // スケジュール詳細

    private int mViewType;    // ビュータイプ

    // コンストラクタ
    public ScheduleList(String hour, String minute, String ampm, String schedule, int viewtype) {
        this.mHour = hour;
        this.mMinute = minute;
        this.mAmPm = ampm;
        this.mSchedule = schedule;

        this.mViewType = viewtype;
    }

    public String getHour() {
        return mHour;
    }

    public String getMinute() {
        return mMinute;
    }

    public String getAmpm() {
        return mAmPm;
    }

    public String getSchedule() {
        return mSchedule;
    }

    public int getViewType() {
        return mViewType;
    }

    public void setHour(String hour) {
        this.mHour = hour;
    }

    public void setMinute(String minute) {
        this.mMinute = minute;
    }

    public void setAmpm(String ampm) {
        this.mAmPm = ampm;
    }

    public void setSchedule(String schedule) {
        this.mSchedule = schedule;
    }

    public void setViewType(int viewtype) {
        this.mViewType = viewtype;
    }
}
