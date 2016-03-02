package com.pj.test.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pj.test.util.DESTool;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_savaData;
    private Button btn_jni;

    static {

        System.loadLibrary("desjni");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_savaData = (Button)findViewById(R.id.btn_savaData);
        btn_savaData.setOnClickListener(this);
        btn_jni = (Button)findViewById(R.id.btn_jni);
        btn_jni.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_savaData:
                Intent intent = new Intent(MainActivity.this,SaveDataActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_jni:
                String string = "asadsdsd";
                String s = DESTool.encrypt(string);

                Log.e("testJni",s);
                break;
            default:
                break;
        }
    }
}
