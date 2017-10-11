package org.androidtown.refrigerator;

/**
 * Created by stare on 2017-09-24.
 */
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;

public class ListViewItem {
    private Drawable iconDrawable ;
    private String titleStr ;
    private String dateStr ;


    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDate(String date)   { dateStr = date ; }


    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDate() { return this.dateStr ; }
}

