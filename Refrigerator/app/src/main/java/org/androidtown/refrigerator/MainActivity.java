package org.androidtown.refrigerator;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.androidtown.refrigerator.Item.MemberInfoItem;
import org.androidtown.refrigerator.Item.StorageItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        adapter = new ListViewAdapter(context,R.layout.activity_regist_product,new ArrayList<StorageItem>()) ;

        RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);

        Call<ArrayList<StorageItem>> call = remoteService.selectStorageListInfo(seq);
        call.enqueue(new Callback<ArrayList<StorageItem>>() {
            @Override
            public void onResponse(Call<ArrayList<StorageItem>> call, Response<ArrayList<StorageItem>> response) {
                ArrayList<StorageItem> list = response.body();

                MyLog.d(TAG,"response : " + list);

                if (response.isSuccessful() && list != null) {
                    adapter.addItemList(list);
                    // addItemList 를 for문 addItem으로 변경
                    // 각각 selectStorageFoodInfo()를 돌려 음식 이름과 분류 정보를 불러와야함.

                    if (adapter.getCount() == 0) {
                        noDataText.setVisibility(View.VISIBLE);
                    } else {
                        noDataText.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                MyLog.d(TAG, "no internet connectivity");
                MyLog.d(TAG, "t.toString()");
            }
        });
    }
}