
package org.androidtown.refrigerator;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.androidtown.refrigerator.R.layout.activity_regist_product;

public class RegistProduct extends AppCompatActivity {

    ArrayList arraylist;
    public static String select_item = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_regist_product);
        arraylist = new ArrayList();
        arraylist.add("과일");
        arraylist.add("채소");
        arraylist.add("생선");
        arraylist.add("해산물");
        arraylist.add("견과");
        arraylist.add("쌀/잡곡");
        arraylist.add("정육");
        arraylist.add("계란류");
        arraylist.add("유제품");
        arraylist.add("음료");
        arraylist.add("간식");
        arraylist.add("냉동/간편식품");
        arraylist.add("통조림");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arraylist);
        Spinner sp = (Spinner) findViewById(R.id.type_spinner);
        sp.setPrompt("유형을 선택하세요.");
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
//                Toast.makeText(getBaseContext(), arraylist.get(arg2) + "이 설정되었습니다.",
//                        Toast.LENGTH_SHORT).show();
                select_item = String.valueOf(arraylist.get(arg2));
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });


    }
    public void onClicked(View v)
    {
        DatePickers newFragment = new DatePickers();
        newFragment.show(getFragmentManager(),"DatePickers");
    }
}

