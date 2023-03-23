package com.hacktiv8.sesi8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements ClubAdapter.ListItemClickListener {

    private RecyclerView mClubRv;

    private List<Club> mClubList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClubRv = findViewById(R.id.club_rv);

        mClubList = new ArrayList<>();

        String deskripsi = "Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " +
                "commodo consequat. Duis aute irure dolor in reprehenderit in " +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                " Excepteur sint occaecat cupidatat non proident, sunt in culpa " +
                "qui officia deserunt mollit anim id est laborum.";

        mClubList.add(new Club("Arsenal", "Emirates Stadium", "https://dreamleague-soccer-kits.com/wp-content/uploads/2019/02/Arsenal-Team-512x512-Logo.png", deskripsi));
        mClubList.add(new Club("Manchester United","Old Trafford", "https://dreamleague-soccer-kits.com/wp-content/uploads/2019/02/Manchester-United-logo.png", deskripsi ));
        mClubList.add(new Club("Chelsea", "Stamford Bridge", "https://dreamleague-soccer-kits.com/wp-content/uploads/2019/04/Chelsea-DLS-Team-Logo.png", deskripsi));
        mClubList.add(new Club("Liverpool", "Anfield", "https://dreamleague-soccer-kits.com/wp-content/uploads/2019/02/Liverpool-logo.png", deskripsi));

        ClubAdapter clubAdapter = new ClubAdapter(this, mClubList);
        clubAdapter.setListener(this);
        mClubRv.setAdapter(clubAdapter);

        //List
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mClubRv.setLayoutManager(layoutManager);

        //Grid
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
//        mClubRv.setLayoutManager(layoutManager);


    }

    @Override
    public void onListItemClick(View v, int position) {
        Club selectedClub = mClubList.get(position);
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("club", selectedClub);
        startActivity(intent);

    }
}