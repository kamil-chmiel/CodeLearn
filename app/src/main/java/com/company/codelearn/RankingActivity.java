package com.company.codelearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        String[] lokaLoka = new String[] {
                "NUMER: LOGIN PUNKTY",
                "2: KOTEK 999",
                "Lokka Lokka",
                "Lokka Lokka",
                "Lokka Lokka",
                "Lokka Lokka",
                "Lokka Lokka",
                "Lokka Lokka",
                "Lokka Lokka",
                "Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka",
                "Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka","Lokka Lokka",
                "Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry",
                "Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry",
                "Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry",
                "Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry",
                "Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry",
                "Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry","Capuli cherry",
        };

        // Create a List from String Array elements
        final List<String> lokaLoka_list = new ArrayList<>(Arrays.asList(lokaLoka));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, lokaLoka_list);

        // DataBind ListView with items from ArrayAdapter
        rankingList.setAdapter(arrayAdapter);
    }
}