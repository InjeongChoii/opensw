package org.androidtown.refrigerator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.inset;

public class IndexActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    Context context;

    /**
     * 현재 폰의 전화번호와 동일한 사용자 정보를 조회할 수 있도록
     * selectMemberInfo() 메소드를 호출한다.
     * @param savedInstanceState 액티비티가 새로 생성되었을 경우 이전 상태 값을 가지는 객채
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        context = this;

    }

    /**
     * 1.2초 후 startTask()를 호출한다.
     */
    @Override
    protected void onStart() {
        super.onStart();

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startTask();
            }
        },1200);
    }

    /**
     * 현재 폰의 전화번호와 동일한 사용자 정보를 조회할 수 있도록
     * selectMemberInfo() 를 호출한다.
     */
    public void startTask(){
        String phone = PhoneLib.getInstance().getPhoneNumber(this);

        selectMemberInfo(phone);
    }

    /**
     * 레트로핏을 활용하여 서버로부터 사용자 정보를 조회한다.
     * 있으면 setMemberInfoItem(), 없으면 insertMemberInfo() 메소드를 호출한다.
     * @param phone 현재 폰의 전화번호
     */
    protected void selectMemberInfo(String phone){

        RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);

        Call<MemberInfoItem> call = remoteService.selectMemberInfo(phone);
        call.enqueue(new Callback<MemberInfoItem>() {
            @Override
            public void onResponse(Call<MemberInfoItem> call, Response<MemberInfoItem> response) {
                MemberInfoItem item = response.body();

                if(response.isSuccessful() && item.name == null) {
                    MyLog.d(TAG, "success" + response.body().toString());
                    setMemberInfoItem(item);
                }else{
                    MyLog.d(TAG,"not success");
                    goProfileActivity(item);
                }
            }

            @Override
            public void onFailure(Call<MemberInfoItem> call, Throwable t) {
                MyLog.d(TAG, "no internet connectivity");
                MyLog.d(TAG, "t.toString()");
            }
        });
    }

    /**
     * 전달받은 MemberInfoItem을 Application 객체에 저장한다.
     * 그리고 startMain() 메소드를 호출한다.
     * @param item 사용자 정보
     */
    private void setMemberInfoItem(MemberInfoItem item){
        ((MyApplication)getApplicationContext()).setMemberInfoItem(item);

        startMain();
    }

    /**
     * MainActicity를 실행하고, 현재 액티비티를 종료한다.
     */
    public void startMain(){
        Intent intent = new Intent(IndexActivity.this, MainActivity.class);
        startActivity(intent);

        finish();
    }

    /**
     * 사용자 정보를 조회하지 못한 경우, insertMemberPhone() 메소드로 전화번호를 서버에 저장하고,
     * MainActivity를 실행한 후, 사용자 정보를 저장하는 profileActivity로 이동한다.
     * 현재 액티비티를 종료한다.
     * @param item
     */
    private void goProfileActivity(MemberInfoItem item){
        if(item == null || item.seq <= 0){
            insertMemberPhone();
        }
//
//        Intent intent = new Intent(IndexActivity.this, MainActivity.class);
//        startActivity(intent);

        Intent intent2 = new Intent(IndexActivity.this,WishList.class);
        startActivity(intent2);

        finish();
    }

    /**
     * 현재 사용자의 폰 번호를 서버에 저장한다.
     */
    private void insertMemberPhone(){
        String phone = PhoneLib.getInstance().getPhoneNumber(context);
        RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);

        Call<String > call = remoteService.insertMemberPhone(phone);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    MyLog.d(TAG, "success insert id " + response.body().toString());
                }else{
                    int status = response.code();
                    ResponseBody errorBody = response.errorBody();

                    MyLog.d(TAG,"fail" + status + errorBody.toString());
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                MyLog.d(TAG,"no internet connectivity");
            }
        });
    }
}
