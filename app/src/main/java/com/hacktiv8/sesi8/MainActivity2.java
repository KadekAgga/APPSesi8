package com.hacktiv8.sesi8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {

    private ImageView mLogoView;
    private TextView mNameView;
    private TextView mStadionNameView;
    private TextView mDeskripsiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mLogoView = findViewById(R.id.logo_view);
        mNameView = findViewById(R.id.name_view);
        mStadionNameView = findViewById(R.id.stadion_name_view);
        mDeskripsiView = findViewById(R.id.deskripsi_view);

        //Load data extras
        Bundle data = getIntent().getExtras();
        Club club = data.getParcelable("club");


        //View Data
        mNameView.setText(club.getNama());
        mStadionNameView.setText(club.getStadion());
        mDeskripsiView.setText(club.getDeskripsi());

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.build().load(club.getLogo())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(mLogoView);


    }
}