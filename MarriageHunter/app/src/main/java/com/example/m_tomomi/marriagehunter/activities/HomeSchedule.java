package com.example.m_tomomi.marriagehunter.activities;

/**
 * Created by m_tomomi on 2016/10/09.
 */

public class HomeSchedule {
    // メンバ変数
    private String mDate;       // 日付 YYYY.MM.DD
    private String mDays;       // 曜日
    private String mTime;       // 時刻 HH:MM
    private String mAmPm;       // 午前・午後
    private String mSchedule;  // スケジュール詳細

    private int mViewType;    // ビュータイプ

    // コンストラクタ
    public HomeSchedule(String date, String days, String time, String ampm, String schedule, int viewtype) {
        this.mDate = date;
        this.mDays = days;
        this.mTime = time;
        this.mAmPm = ampm;
        this.mSchedule = schedule;

        this.mViewType = viewtype;
    }

    public String getDate() {
        return mDate;
    }

    public String getDays() {
        return mDays;
    }

    public String getTime() {
        return mTime;
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

    public void setDate(String date) {
        this.mDate = date;
    }

    public void setDays(String days) {
        this.mDays = days;
    }

    public void setTime(String time) {
        this.mTime = time;
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
