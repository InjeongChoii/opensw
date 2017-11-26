package org.androidtown.refrigerator.Item;

import retrofit2.http.HEAD;

import static org.androidtown.refrigerator.R.string.food_name;

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

    public String getExp_date() {
        return exp_date;
    }

    public int getSeq() {
        return seq;
    }

    public int getMem_seq() {
        return mem_seq;
    }

    public int getFood_seq() {
        return food_seq;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public void setMem_seq(int mem_seq) {
        this.mem_seq = mem_seq;
    }

    public void setFood_seq(int food_seq) {
        this.food_seq = food_seq;
    }
}
