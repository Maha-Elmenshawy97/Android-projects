package com.example.data;

import android.os.Parcel;
import android.os.Parcelable;

public class People implements Parcelable{
    private int id;
    private String name;
    private String phone;

    public People() {
    }

    public People(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    protected People(Parcel in) {
        id = in.readInt();
        name = in.readString();
        phone = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(phone);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


