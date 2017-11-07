package org.androidtown.refrigerator;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by kmucs on 17. 11. 2.
 */

public class DatePickers extends Activity {
    TextView mDate;

    int mYear, mMonth, mDay ;
    @Override


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_regist_product);
        mDate = (TextView)findViewById(R.id.txtdate);
        Calendar cal = new GregorianCalendar();

        mYear =cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        UpdateNow();
    }

    public void mOnclick() {
        new DatePickerDialog(DatePickers.this, mDateSetListener,mYear,mMonth,mDay).show();
    }

    DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

            UpdateNow();
        }
    };

    void UpdateNow(){
        mDate .setText(String.format("%d/%d//%d",mYear,mMonth+1,mDay));
    }
    }
//        extends DialogFragment implements DatePickerDialog.OnDateSetListener {
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        final Calendar c = Calendar.getInstance();
//        int year = c.get(c.YEAR);
//        int month = c.get(c.MONTH);
//        int dayOfMonth = c.get(c.DAY_OF_MONTH);
//
//        DatePickerDialog date = new DatePickerDialog(getActivity(),this,year,month,dayOfMonth);
////        AlertDialog.THEME_DEVICE_DEFAULT_DARK,,DateFormat.getDateInstance(DateFormat.LONG,Locale.KOREA)
//        TextView title = new TextView(getActivity());
//        title.setText("유통기한 설정");
//        title.setPadding(5,3,5,3);
//        title.setGravity(Gravity.CENTER_HORIZONTAL);
//        date.setCustomTitle(title);
//        return date;
//    }
//
//    @Override
//    public void onDateSet(DatePicker view, int years, int months, int days){
//        TextView t = (TextView)getActivity().findViewById(R.id.date_var);
//        t.setText(String.valueOf(years)+"-"+String.valueOf(months+1)+"-"+String.valueOf(days));
//    }
//
//}
