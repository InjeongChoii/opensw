package org.androidtown.refrigerator;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.androidtown.refrigerator.Item.FoodItem;
import org.androidtown.refrigerator.Item.ListViewItem;
import org.androidtown.refrigerator.Item.StorageItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    Context context;
    int mem_seq;
    TextView noDataText;

    ListView listview ;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        listview = (ListView) findViewById(R.id.listview1);
        noDataText =(TextView) findViewById(R.id.no_data);

        selectStorageListInfo();
        listview.setAdapter(adapter);


        //등록 버튼
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistProduct.class);
                startActivity(intent);

            }
        });

    }


    protected void selectStorageListInfo(){
        int seq = ((MyApplication)getApplicationContext()).getMemberSeq();
        adapter = new ListViewAdapter(context,R.layout.activity_regist_product,new ArrayList<ListViewItem>()) ;

        MyLog.d(TAG,"selectStorageListInfo() Call");

        RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);

        Call<ArrayList<StorageItem>> call = remoteService.selectStorageListInfo(seq);
        call.enqueue(new Callback<ArrayList<StorageItem>>() {
            @Override
            public void onResponse(Call<ArrayList<StorageItem>> call, Response<ArrayList<StorageItem>> response) {
                ArrayList<StorageItem> list = response.body();
                MyLog.d(TAG,"response : " + list );

                if (response.isSuccessful() && !list.isEmpty()) {
                    for(int i =0; i <list.size(); i++){
                        StorageItem item = list.get(i);
                        MyLog.d(TAG,"item[" + i + "] : " + item);

                        selectFoodInfo(item);
                    }
                }
                MyLog.d(TAG,"response : " + list + ", adapter.isEmpty() : " + adapter.isEmpty() );

                if (adapter.isEmpty()) {
                    noDataText.setVisibility(View.VISIBLE);
                } else {
                    noDataText.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                MyLog.d(TAG, "no internet connectivity");
                MyLog.d(TAG, "t.toString()");
            }
        });
    }

    protected void selectFoodInfo(StorageItem item){

        MyLog.d(TAG,"selectFoodInfo() is called ");

        RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);

        final String exp_date = item.getExp_date();
        int food_seq = item.getFood_seq();

        Call<FoodItem> call2 = remoteService.selectFoodInfo(food_seq);
        call2.enqueue(new Callback<FoodItem>() {
            @Override
            public void onResponse(Call<FoodItem> call, Response<FoodItem> response) {
                FoodItem foodItem = response.body();

                MyLog.d(TAG,"response item : " + foodItem );

                String foodName = foodItem.getName();
                String type = foodItem.getCategory();

                adapter.addItem(foodName, type, exp_date);
                listview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FoodItem> call, Throwable t) {
                MyLog.d(TAG, "no internet connectivity");
                MyLog.d(TAG, "t.toString()");
            }
        });
    }
}