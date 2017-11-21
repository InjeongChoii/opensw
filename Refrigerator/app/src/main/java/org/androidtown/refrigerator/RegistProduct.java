package org.androidtown.refrigerator;

import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import org.androidtown.refrigerator.Item.MemberInfoItem;
import org.androidtown.refrigerator.MyApplication;
import org.androidtown.refrigerator.R;

import java.util.ArrayList;

public class RegistProduct extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    Context context;
    ArrayList categoryList;
    EditText expirationDateText;
    Spinner categorySpinner;
    Button registButton;
    String select_item;
    DatePickerDialog datePickerDialog;

    MemberInfoItem memberInfoItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_product);

        context = this;
        memberInfoItem = ((MyApplication) getApplication()).getMemberInfoItem();

        setView();

    }

    /**
     * 액티비티 화면을 설정한다.
     */
    private void setView(){
        registButton = (Button)findViewById(R.id.register_button);

        categoryList = new ArrayList();
        categoryList.add("과일");
        categoryList.add("채소");
        categoryList.add("생선");
        categoryList.add("해산물");
        categoryList.add("견과");
        categoryList.add("쌀/잡곡");
        categoryList.add("정육");
        categoryList.add("계란류");
        categoryList.add("유제품");
        categoryList.add("음료");
        categoryList.add("간식");
        categoryList.add("냉동/간편식품");
        categoryList.add("통조림");

        expirationDateText = (EditText) findViewById(R.id.txtdate);
        expirationDateText.setInputType(InputType.TYPE_NULL);
        expirationDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDatePickerDialog();
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categoryList);

        categorySpinner = (Spinner) findViewById(R.id.type_spinner);
        categorySpinner.setPrompt("유형을 선택하세요.");
        categorySpinner.setAdapter(adapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
//                Toast.makeText(getBaseContext(), arraylist.get(arg2) + "이 설정되었습니다.",
//                        Toast.LENGTH_SHORT).show();
                select_item = String.valueOf(categoryList.get(arg2));
            }
            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

    }

    private void setDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, R.style.MyDatePicker, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                expirationDateText.setText(day + "/" + (month + 1) + "/" + year);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}

