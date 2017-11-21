package org.androidtown.refrigerator;

import org.androidtown.refrigerator.Item.FoodItem;
import org.androidtown.refrigerator.Item.MemberInfoItem;
import org.androidtown.refrigerator.Item.StorageItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by stare on 2017-10-27.
 * 서버에 호출할 메소드를 지정하는 인터페이스
 */
public interface RemoteService {
    String BASE_URL = "http://192.168.0.7:3000";

    //사용자 정보
    @GET("/member/{phone}")
    Call<MemberInfoItem> selectMemberInfo(@Path("phone") String phone);

    @POST("/member/info")
    Call<String> insertMemberInfo(@Body MemberInfoItem memberInfoItem);

    @FormUrlEncoded
    @POST("/member/phone")
    Call<String> insertMemberPhone(@Field("phone") String phone);


    //음식정보
    @GET("/food/{name}")
    Call<FoodItem> selectFoodInfo(@Path("name") String name);

    @POST("/food/info")
    Call<FoodItem> insertFoodInfo(@Body FoodItem foodItem);

    //저장음식 정보
    @GET("/storages/{mem_seq}")
    Call <ArrayList<StorageItem>> selectStorageListInfo (@Path("mem_seq") int mem_seq);
}
