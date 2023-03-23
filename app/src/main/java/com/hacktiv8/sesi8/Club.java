package com.hacktiv8.sesi8;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Club implements Parcelable {

    private String logo;
    private String nama;
    private String stadion;
    private String deskripsi;

    protected Club(Parcel in) {
        logo = in.readString();
        nama = in.readString();
        stadion = in.readString();
        deskripsi = in.readString();
    }

    public static final Creator<Club> CREATOR = new Creator<Club>() {
        @Override
        public Club createFromParcel(Parcel in) {
            return new Club(in);
        }

        @Override
        public Club[] newArray(int size) {
            return new Club[size];
        }
    };

    public Club(String nama, String stadion, String logo, String deskripsi ) {
        this.nama = nama;
        this.stadion = stadion;
        this.logo = logo;
        this.deskripsi = deskripsi;

    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStadion() {
        return stadion;
    }

    public void setStadion(String stadion) {
        this.stadion = stadion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(logo);
        dest.writeString(nama);
        dest.writeString(stadion);
        dest.writeString(deskripsi);
    }
}
