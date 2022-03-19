package com.exx.carpimtablosu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar sb;
    TextView tv;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (SeekBar) findViewById(R.id.seekBar);
        tv = (TextView) findViewById(R.id.textView);
        lv = (ListView) findViewById(R.id.listview);

        sb.setMax(20);
        //sb.setMin(1);
        sb.setProgress(10);
        tv.setText(""+10);
        myInflate( 10);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               tv.setText(""+i);
               myInflate(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void myInflate(int possition){
        ArrayList<String> tt = new ArrayList<>();
        String row = "";

        for(int i =1; i<20; i++){
           row=""+i+"*"+possition+"="+(possition*i);
           tt.add(row);

        }

        ArrayAdapter<String> adap = new ArrayAdapter<>( MainActivity.this,
                android.R.layout.simple_list_item_1, tt);
        lv.setAdapter(adap);
    }
}