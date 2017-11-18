package org.androidtown.refrigerator;

import org.androidtown.refrigerator.Item.MemberInfoItem;

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
    String BASE_URL = "http://192.168.0.5:3000";

    //사용자 정보
    @GET("/member/{phone}")
    Call<MemberInfoItem> selectMemberInfo(@Path("phone") String phone);

    @POST("/member/info")
    Call<String> insertMemberInfo(@Body MemberInfoItem memberInfoItem);

    @FormUrlEncoded
    @POST("/member/phone")
    Call<String> insertMemberPhone(@Field("phone") String phone);

}
