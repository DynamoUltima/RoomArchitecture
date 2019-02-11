package com.example.roomarchitecture;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;

import java.util.List;

public class LocalDatabaseRepo {
    private static StoreInfoDatabase storeInfoDatabase;
    private StoreInfoDAO storeInfoDAO;
    private static final Object LOCK = new Object();

    private static RoomDatabase.Callback dbCallback = new RoomDatabase.Callback(){
        public void onCreate (SupportSQLiteDatabase db){

        }
        public void onOpen (SupportSQLiteDatabase db){
            //delete existing data
            db.execSQL("Delete From StoreOffers");

            ContentValues contentValues = new ContentValues();
            contentValues.put("storeName", "Amazon");
            contentValues.put("couponsCount", 30);
            db.insert("StoreOffers", OnConflictStrategy.IGNORE, contentValues);

            contentValues = new ContentValues();
            contentValues.put("storeName", "AmPM");
            contentValues.put("couponsCount", 13);
            db.insert("StoreOffers", OnConflictStrategy.IGNORE, contentValues);

            contentValues = new ContentValues();
            contentValues.put("storeName", "BestFashion");
            contentValues.put("couponsCount", 11);
            db.insert("StoreOffers", OnConflictStrategy.IGNORE, contentValues);

            contentValues = new ContentValues();
            contentValues.put("storeName", "FashionStore");
            contentValues.put("couponsCount", 53);
            db.insert("StoreOffers", OnConflictStrategy.IGNORE, contentValues);

            contentValues = new ContentValues();
            contentValues.put("storeName", "FashionMall");
            contentValues.put("couponsCount", 43);
            db.insert("StoreOffers", OnConflictStrategy.IGNORE, contentValues);

            contentValues = new ContentValues();
            contentValues.put("storeName", "FashionSale");
            contentValues.put("couponsCount", 23);
            db.insert("StoreOffers", OnConflictStrategy.IGNORE, contentValues);
        }
    };

    public synchronized static StoreInfoDatabase getStoreInfoDatabase(Context context){
        if(storeInfoDatabase == null) {
            synchronized (LOCK) {
                if (storeInfoDatabase == null) {
                    storeInfoDatabase = Room.databaseBuilder(context,
                            StoreInfoDatabase.class, "store info db")
                            .fallbackToDestructiveMigration()
                            .addCallback(dbCallback).build();
                }
            }
        }
        return storeInfoDatabase;
    }


    public List<StoreOffers> getStoreInfo(Context context, String storeStr) {
        if (storeInfoDAO == null) {
            storeInfoDAO = LocalDatabaseRepo.getStoreInfoDatabase(context).storeInfoDAO();
        }
        return storeInfoDAO.getStores(storeStr+"%");
    }
}