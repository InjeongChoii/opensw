package org.androidtown.refrigerator;

/**
 * 냉장고에 음식을 등록하는 객체
 * Created by stare on 2017-11-15.
 */

public class StorageItem {
    public int seq;
    public int mem_seq;
    public int food_seq;
    public String exp_date;
    public String reg_date;

    @Override
    public String toString() {
        return "StorageItem{" +
                "seq=" + seq +
                ", mem_seq=" + mem_seq +
                ", food_seq=" + food_seq +
                ", exp_date='" + exp_date + '\'' +
                ", reg_date='" + reg_date + '\'' +
                '}';
    }
}
