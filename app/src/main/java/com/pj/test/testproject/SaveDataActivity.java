package com.pj.test.testproject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

/**
 * Created by user on 2016/2/4.
 */
public class SaveDataActivity extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;
    private Button btn_savaData;
    private SharedPreferences mSharePrefrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().setTitle("保存数据");
        mContext = this;
//        getActionBar().setTitle("保存数据");
        setContentView(R.layout.activity_savadata);
        btn_savaData = (Button)findViewById(R.id.btn_cacheData);
        btn_savaData.setOnClickListener(this);
        mSharePrefrences = mContext.getSharedPreferences("name",MODE_PRIVATE);

        Toast.makeText(mContext,mSharePrefrences.getString("name","abc"),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cacheData:
                //保存缓存数据
               File file =  mContext.getExternalCacheDir();
                //测试mSharePrefrence是否为缓存数据
                SharedPreferences.Editor editor = mSharePrefrences.edit();
                editor.putString("name","panjiang");
                editor.commit();
                break;
            default:
                break;
        }
    }
}
