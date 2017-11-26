package org.androidtown.refrigerator.Item;

/**
 * Created by stare on 2017-09-24.
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;

import org.androidtown.refrigerator.R;

import static org.androidtown.refrigerator.R.drawable.fruit;
import static org.androidtown.refrigerator.R.drawable.grain;

public class ListViewItem {
    Context context;
    private Drawable iconDrawable ;
    private String foodName ;
    private String exp_date ;


    public void setIcon(String type) {
        if(type.equals(fruit)){
            iconDrawable = context.getResources().getDrawable(R.drawable.fruit);
        }else if(type.equals(grain)){
            iconDrawable = context.getResources().getDrawable(R.drawable.grain);
        }
    }
    public void setFoodName(String name) {
        foodName = name ;
    }
    public void setExp_date(String date)   { exp_date = date ; }


    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getFoodName() { return this.foodName;}
    public String getExp_date() { return this.exp_date ; }
}

