package com.example.roomarchitecture;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class StoreOffers {
    @PrimaryKey(autoGenerate = true)
    private int id;

    String storeName;
    int couponsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getCouponsCount() {
        return couponsCount;
    }

    public void setCouponsCount(int couponsCount) {
        this.couponsCount = couponsCount;
    }
} 