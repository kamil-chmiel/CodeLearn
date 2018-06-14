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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Ranking", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_ranking);
        updateRankingList();
    }
    private void updateRankingList(){
        ListView rankingList = findViewById(R.id.ranking_list);

        List<String> rankingListArray = new ArrayList<>();
        Map<UserData, Integer> map = new DatabaseHelper(getApplicationContext()).getRankingList();
        for (Map.Entry<UserData, Integer> entry : map.entrySet())
        {
            rankingListArray.add(entry.getKey().getName() + " -> " + entry.getValue());
        }

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, rankingListArray);

        // DataBind ListView with items from ArrayAdapter
        rankingList.setAdapter(arrayAdapter);
    }
}