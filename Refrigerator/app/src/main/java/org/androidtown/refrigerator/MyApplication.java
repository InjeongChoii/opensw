package org.androidtown.refrigerator;

import android.app.Application;
import android.os.StrictMode;

import org.androidtown.refrigerator.Item.MemberInfoItem;

/**
 * Created by stare on 2017-10-27.
 */

public class MyApplication extends Application {

    private MemberInfoItem memberInfoItem;

    @Override
    public void onCreate() {
        super.onCreate();

        //FileUriExposeException 문제 해결을 위한 코드
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    public MemberInfoItem getMemberInfoItem() {
        if(memberInfoItem == null)
            memberInfoItem = new MemberInfoItem();

        return memberInfoItem;
    }

    public void setMemberInfoItem(MemberInfoItem item){
        this.memberInfoItem = item;
    }

    public int getMemberSeq(){
        return memberInfoItem.seq;
    }
}

