package com.pj.test.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_savaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_savaData = (Button)findViewById(R.id.btn_savaData);
        btn_savaData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_savaData:
                Intent intent = new Intent(MainActivity.this,SaveDataActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
