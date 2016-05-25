package com.pj.test.testproject;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pj.test.util.DESTool;

/**
 * Created by Administrator on 2016/3/7.
 */
public class JniActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_encrypt;
    private Button btn_decrypt;
    private String s;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jin);
        btn_encrypt = (Button)findViewById(R.id.btn_encrypt);
        btn_encrypt.setOnClickListener(this);
        btn_decrypt = (Button)findViewById(R.id.btn_decrypt);
        btn_decrypt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_encrypt:
                String string = "1232abcd";
                 s = DESTool.encrypt(string);
                Toast.makeText(JniActivity.this,"加密后："+s,Toast.LENGTH_SHORT).show();
                Log.e("testJni",s);
                break;
            case R.id.btn_decrypt:
                String decrypt = "";
            ;if (s==null||s.equals("")){
                Toast.makeText(JniActivity.this,"请先加密",Toast.LENGTH_SHORT).show();

            }else{
                decrypt =  DESTool.decrypt(s);
                Toast.makeText(JniActivity.this,"解密后："+decrypt,Toast.LENGTH_SHORT).show();
            }
                break;
            default:
                break;
        }
    }
}
