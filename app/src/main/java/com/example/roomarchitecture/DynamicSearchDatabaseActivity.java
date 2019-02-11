package com.example.roomarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DynamicSearchDatabaseActivity extends AppCompatActivity {

    private StoreListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView nameTV = (AutoCompleteTextView) findViewById(R.id.store);

        List<StoreOffers> storeOffers = new ArrayList<StoreOffers>();
         adapter = new StoreListAdapter(this, R.layout.store_item, storeOffers);


        nameTV.setAdapter(adapter);
        nameTV.setOnItemClickListener(onItemClickListener);


    }

    private AdapterView.OnItemClickListener onItemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                    Toast.makeText(DynamicSearchDatabaseActivity.this, adapter.getItem(i).getStoreName(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(DynamicSearchDatabaseActivity.this,String.valueOf(adapter.getItem(i).getCouponsCount()), Toast.LENGTH_SHORT).show();

                    Toast.makeText(DynamicSearchDatabaseActivity.this,
                            "Clicked item from auto completion list "
                                    + adapterView.getItemAtPosition(i)
                            , Toast.LENGTH_LONG).show();
                }
            };
}
