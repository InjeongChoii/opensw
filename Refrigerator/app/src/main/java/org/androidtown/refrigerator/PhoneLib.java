package org.androidtown.refrigerator;

import android.content.Context;
import android.telephony.TelephonyManager;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 전화번호 반환을 위한 클래스
 * Created by stare on 2017-10-29.
 */

public class PhoneLib {
    public final String TAG = PhoneLib.class.getSimpleName();
    private volatile static PhoneLib instance;

    public static PhoneLib getInstance(){
        if(instance == null){
            synchronized (PhoneLib.class){
                if(instance == null){
                    instance = new PhoneLib();
                }
            }
        }
        return instance;
    }

    /**
     * 기기의 전화번호를 반환한다(+82)
     * @param context 컨텍스트 객체
     * @return 전화번호 문자열
     */
    public String getPhoneNumber(Context context){
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String number = tm.getLine1Number();

        if(number != null && !number.equals("") && number.length() >= 8) {
            if (Locale.getDefault().getCountry().equals("KR")){
                if(number.startsWith("82")){
                    number = "+" + number;
                }

                if(number.startsWith("0")){
                    number = "+82" + number;
                }
            }
            MyLog.d(TAG, "number " + number);
        }
        return number;
    }

    /**
     * 전화번호가 유효한 자릿수를 가지고 있는지 체크한다.
     */
    public boolean isValidPhoneNumber(String number){
        if(number == null){
            return false;
        }
        else{
            if(Pattern.matches("\\d{2}-\\d{3}-\\d{4}", number)
                    || Pattern.matches("\\d{3}-\\d{3}-\\d{4}", number)
                    || Pattern.matches("\\d{3}-\\d{4}-\\d{4}", number)
                    || Pattern.matches("\\d{10}", number)
                    || Pattern.matches("\\d{11}", number) ) {
                return true;
            } else {
                return false;
            }
        }
    }


    public String getPhoneNumberText(String number){
        String phoneText = "";

        if(number == null){
            return phoneText;
        }

        number = number.replace("-","");

        int length = number.length();

        if(number.length() >= 10){
            phoneText = number.substring(0,3) + "-"
                    + number.substring(3, length-4) + "-"
                    + number.substring(length-4, length);
        }
        return phoneText;
    }
}
