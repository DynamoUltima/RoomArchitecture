package com.example.roomarchitecture;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StoreInfoDAO {
    @Query("SELECT * FROM StoreOffers WHERE storeName like :storeIn ")
    List<StoreOffers> getStores(String storeIn);
}