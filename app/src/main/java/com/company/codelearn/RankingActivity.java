package com.company.codelearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.company.codelearn.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RankingActivity extends AppCompatActivity {
    private RankingListViewAdapter adapter;
    private ListView lView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        getWindow().setBackgroundDrawableResource(R.drawable.ranking_background);
        adapter = new RankingListViewAdapter( this);
        lView = (ListView) findViewById(R.id.ranking_list);
        updateRankingList();
    }
    private void updateRankingList(){
        Map<UserData, Integer> map = new DatabaseHelper(getApplicationContext()).getRankingList();
        for (Map.Entry<UserData, Integer> entry : map.entrySet())
        {
            adapter.addRankingRecord(entry.getKey().getName(), entry.getValue().toString());
        }
        lView.setAdapter(adapter);
    }
}