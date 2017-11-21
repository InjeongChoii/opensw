package org.androidtown.refrigerator.Item;

/**
 * 냉장고에 음식을 등록하는 객체
 * Created by stare on 2017-11-15.
 */

public class StorageItem {
    public int seq;
    public int mem_seq;
    public int food_seq;
<<<<<<< HEAD
    public String food_name;
=======
>>>>>>> d5ddddac854f1ea852f0539fccfe278f8fa0d36f
    public String exp_date;
    public String reg_date;

    @Override
    public String toString() {
        return "StorageItem{" +
                "seq=" + seq +
                ", mem_seq=" + mem_seq +
                ", food_seq=" + food_seq +
<<<<<<< HEAD
                ", food_name=" + food_name +
=======
>>>>>>> d5ddddac854f1ea852f0539fccfe278f8fa0d36f
                ", exp_date='" + exp_date + '\'' +
                ", reg_date='" + reg_date + '\'' +
                '}';
    }
<<<<<<< HEAD

    //getter
    public String getFood_name() {
        return food_name;
    }

    public String getExp_date() {
        return exp_date;
    }

    //setter
    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }
=======
>>>>>>> d5ddddac854f1ea852f0539fccfe278f8fa0d36f
}
