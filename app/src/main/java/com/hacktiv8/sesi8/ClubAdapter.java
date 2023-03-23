package com.hacktiv8.sesi8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    private Context mContext;

    private List<Club> mClubList;

    public ClubAdapter(Context context, List<Club> clubList){
        this.mContext = context;
        this.mClubList = clubList;
    }

    private ListItemClickListener mListener;

    public interface ListItemClickListener{
        public void onListItemClick(View v, int position);
    }

    public void setListener(ListItemClickListener listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ClubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubAdapter.ViewHolder holder, int position) {
        Club club = mClubList.get(position);

        holder.mNameView.setText(club.getNama());
        holder.mStadionNameView.setText(club.getStadion());

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.build().load(club.getLogo())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.mLogoView);

    }

    @Override
    public int getItemCount() {
        return mClubList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mLogoView;
        private TextView mNameView;
        private TextView mStadionNameView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mLogoView = itemView.findViewById(R.id.logo_view);
            mNameView = itemView.findViewById(R.id.name_view);
            mStadionNameView = itemView.findViewById(R.id.stadion_name_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onListItemClick(v, getAdapterPosition());
                }
            });

        }
    }
}
