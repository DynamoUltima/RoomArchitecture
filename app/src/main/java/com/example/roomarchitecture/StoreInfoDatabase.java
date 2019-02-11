package com.example.roomarchitecture;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {StoreOffers.class}, version = 2)
public abstract class StoreInfoDatabase extends RoomDatabase {
    public abstract StoreInfoDAO storeInfoDAO();
}