package com.company.codelearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RankingListViewAdapter extends BaseAdapter implements ListAdapter {
        private ArrayList<String> list,points;
        private Context context;

        public RankingListViewAdapter(Context context) {
            this.list = new ArrayList<>();
            this.context = context;
            this.points = new ArrayList<>();
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int pos) {
            return list.get(pos);
        }

        public void changeScore(String name, String newScore) {
            int pos = list.indexOf(name);
            if(pos != -1) {
                points.set(pos,newScore);
            }
            notifyDataSetChanged();
        }
        @Override
        public long getItemId(int pos) {
            return 0;
        }

        public void addRankingRecord(String name, String score) {
            list.add(name);
            points.add(score);
            notifyDataSetChanged();
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.ranking_list_view_content, null);
            }

            TextView listItemText = (TextView) view.findViewById(R.id.list_item_name);
            listItemText.setText(new StringBuilder().append(position + 1).append(". ").append(list.get(position)).toString());

            TextView pointsText = (TextView) view.findViewById(R.id.list_item_points);
            pointsText.setText(points.get(position));

            return view;
        }
}
