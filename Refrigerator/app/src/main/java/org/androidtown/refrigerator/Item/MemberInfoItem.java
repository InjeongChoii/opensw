package org.androidtown.refrigerator.Item;

import com.google.gson.annotations.SerializedName;

/**
 * 사용자 정보를 저장하는 객체
 */

public class MemberInfoItem {
    public int seq;
    public String phone;
    public String name;
    @SerializedName("reg_date") String regDate;

    public String toString(){
        return "MemberInfoItem{" +
                "seq=" + seq +
                ", phone='" + phone +'\'' +
                ", regDate='" + regDate +'\'' +
                '}';
    }
}
