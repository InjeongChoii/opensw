package org.androidtown.refrigerator.Item;

/**
 * 음식 객체
 * Created by stare on 2017-10-12.
 */

public class FoodItem {
    /**
     * 음식 정보 : 일련번호 / 이름 / 등록일 / 분류 / 유통기한 / 사진
     */
    public int seq;
    public String name;
    public String category;


    @Override
    public String toString(){
        return "FoodItem{" +
                "seq=" + seq +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';

    }

    public int getSeq() {
        return seq;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
