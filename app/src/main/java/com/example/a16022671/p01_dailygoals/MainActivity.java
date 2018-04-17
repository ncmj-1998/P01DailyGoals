package com.example.a16022671.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();

        RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
        int selectedButtonId1 = rg1.getCheckedRadioButtonId();


        RadioGroup rg2 = (RadioGroup)findViewById(R.id.radioGroup2);
        int selectedButtonId2 = rg2.getCheckedRadioButtonId();

        RadioGroup rg3 = (RadioGroup)findViewById(R.id.radioGroup3);
        int selectedButtonId3 = rg3.getCheckedRadioButtonId();

        EditText et4 =(EditText)findViewById(R.id.et4);
        String et4Text = et4.getText().toString();

        prefEdit.putInt("1",selectedButtonId1);
        prefEdit.putInt("2",selectedButtonId2);
        prefEdit.putInt("3",selectedButtonId3);
        prefEdit.putString("4",et4Text);
        Log.v("on pause1",String.valueOf(selectedButtonId1));
        Log.v("on pause2",String.valueOf(selectedButtonId2));
        Log.v("on pause3",String.valueOf(selectedButtonId3));

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
        RadioGroup rg2 = (RadioGroup)findViewById(R.id.radioGroup2);
        RadioGroup rg3 = (RadioGroup)findViewById(R.id.radioGroup3);
        int loadRB1 = prefs.getInt("1",0);
        int loadRB2 = prefs.getInt("2",0);
        int loadRB3 = prefs.getInt("3",0);
        Log.v("on resume1",String.valueOf(loadRB1));
        Log.v("on resume2",String.valueOf(loadRB2));
        Log.v("on resume3",String.valueOf(loadRB3));

        rg1.check(loadRB1);
        rg2.check(loadRB2);
        rg3.check(loadRB3);

        String loadET4 = prefs.getString("4","");
        EditText et4 =(EditText)findViewById(R.id.et4);
        et4.setText(loadET4);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton)findViewById(selectedButtonId1);
                String rb1Text = rb1.getText().toString();

                RadioGroup rg2 = (RadioGroup)findViewById(R.id.radioGroup1);
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton)findViewById(selectedButtonId2);
                String rb2Text = rb2.getText().toString();

                RadioGroup rg3 = (RadioGroup)findViewById(R.id.radioGroup1);
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = (RadioButton)findViewById(selectedButtonId3);
                String rb3Text = rb3.getText().toString();

                EditText et4 =(EditText)findViewById(R.id.et4);
                String et4Text = et4.getText().toString();

                String[] intenting = {rb1Text,rb2Text,rb3Text,et4Text};
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("info",intenting);
                startActivity(i);

            }
        });
    }
}
