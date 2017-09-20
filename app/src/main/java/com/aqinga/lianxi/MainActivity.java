package com.aqinga.lianxi;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private Spinner spinner;
    private AutoCompleteTextView text;
    private TextView riqi;
    private TextView timer;
    private String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        init1();
        init2();
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] stringArray = getResources().getStringArray(R.array.languages);
                Toast.makeText(MainActivity.this, "您选择的是"+stringArray[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    //自动提示
    public void init(){
        text = (AutoCompleteTextView) findViewById(R.id.textview);
        String[] list = {"范","范晋炜","范晋炜是傻子","哈哈哈哈哈","笑死我了","这可咋整"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        text.setAdapter(adapter);
    }
    public void init1(){
        riqi = (TextView) findViewById(R.id.riqi);
        riqi.setOnClickListener(this);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String s = String.format("您选择的日期是%d年%d月%d日",
                year,dayOfMonth+1,dayOfMonth);
        riqi.setText(s);
    }
    //时间选择器
    public void init2(){
        timer = (TextView) findViewById(R.id.timer);
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        s1 = String.format("您选择的日期是%d时%d分",
                hourOfDay,minute);
        timer.setText(s1);
    }
    public void shijian(View view) {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog dialog1 = new TimePickerDialog(this,this,
                calendar.get(Calendar.HOUR_OF_DAY)
                ,calendar.get(Calendar.MINUTE),true);
        dialog1.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.riqi:
                Calendar instance = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(this,this,
                        instance.get(Calendar.YEAR),instance.get(Calendar.MONTH),
                        instance.get(Calendar.DAY_OF_MONTH));
                dialog.show();
                break;
        }
    }

}
