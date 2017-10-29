package org.androidtown.refrigerator;

/**
 * 사용자 정보를 저장하는 객체
 */

public class MemberInfoItem {
    public int seq;
    public String phone;
    public String name;
    public String regDate;

    public String toString(){
        return "MemberInfoItem{" +
                "seq=" + seq +
                ", phone='" + phone +'\'' +
                ", regDate='" + regDate +'\'' +
                '}';
    }
}
