package com.example.m_tomomi.marriagehunter.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.m_tomomi.marriagehunter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m_tomomi on 2016/10/10.
 */

public class ListViewAdapter extends ArrayAdapter<ScheduleList> {

    private LayoutInflater inflater;
    private int itemLayoutId;
    private List<String> titles;
    private List<Integer> ids;


    private static class ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.tv_hour);
        }
    }

    public ListViewAdapter(Context context, int itemLayoutId, ArrayList<ScheduleList> itemNames) {
        super(context, itemLayoutId, itemNames);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // 最初だけ View を inflate して、それを再利用する
        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // activity_main.xml に list.xml を inflate して convertView とする
            convertView = inflater.inflate(R.layout.item_card_schedule_list, null);

            // ViewHolder を生成
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            // holder を使って再利用
            holder = (ViewHolder) convertView.getTag();
        }

        // holder の imageView にセット
        //holder.imageView.setImageResource(ids.get(position));

        // 現在の position にあるファイル名リストを holder の textView にセット
        holder.textView.setText("10");

        return convertView;
    }

    @Override
    public int getCount() {
        // texts 配列の要素数
        return 2;
        //return titles.size();
    }

}
