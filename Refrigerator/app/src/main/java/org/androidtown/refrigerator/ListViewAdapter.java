package org.androidtown.refrigerator;
/**
 * Created by stare on 2017-09-24.
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidtown.refrigerator.Item.FoodItem;
import org.androidtown.refrigerator.Item.MemberInfoItem;
import org.androidtown.refrigerator.Item.StorageItem;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList

    private final String TAG = this.getClass().getSimpleName();

    private Context context;
    private int resource;
    private ArrayList<StorageItem> storageItemList;
    private MemberInfoItem memberInfoItem;


    // ListViewAdapter의 생성자
    public ListViewAdapter(Context context, int resource, ArrayList<StorageItem> itemList){

        this.context = context;
        this.resource = resource;
        this.storageItemList = itemList;

        memberInfoItem = ((MyApplication) context.getApplicationContext()).getMemberInfoItem();
    }

    // Adapter에 사용되는 데이터의 개수를 리턴.
    @Override
    public int getCount() {
        return storageItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        //ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView dateTextView = (TextView) convertView.findViewById(R.id.textView2) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        StorageItem listViewItem = storageItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        //
        //분류별 사진 select를 해야하는데 아무것도 모르겠당
        //iconImageView.setImageDrawable(listViewItem.getS());
        titleTextView.setText(listViewItem.getFood_name());
        dateTextView.setText(listViewItem.getExp_date());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴.
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴
    @Override
    public Object getItem(int position) {
        return storageItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수
    public void addItem(Drawable icon, String title, String date) {
        StorageItem item = new StorageItem();

//        item.setIcon(icon);
        item.setFood_name(title);
        item.setExp_date(date);

        storageItemList.add(item);
    }

    public void addItemList(ArrayList<StorageItem> itemList) {
        this.storageItemList.addAll(itemList);
        notifyDataSetChanged();

        MyLog.d(TAG,"list after update : " + storageItemList.get(0));
    }
}
