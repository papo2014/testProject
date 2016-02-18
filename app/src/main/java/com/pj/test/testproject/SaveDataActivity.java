package com.pj.test.testproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pj.test.model.UserInfo;
import com.pj.test.util.DataBaseHelper;
import com.pj.test.util.DataCacheManager;

import java.io.File;

/**
 * Created by user on 2016/2/4.
 */
public class SaveDataActivity extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;
    private Button btn_cacheData;
    private SharedPreferences mSharePrefrences;
    private Button btn_sharePrefrenceData;
    private Button btn_sqlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().setTitle("保存数据");
        mContext = this;
//        getActionBar().setTitle("保存数据");
        setContentView(R.layout.activity_savadata);
        btn_cacheData = (Button)findViewById(R.id.btn_cacheData);
        btn_cacheData.setOnClickListener(this);
        btn_sharePrefrenceData = (Button)findViewById(R.id.btn_sharePrefrenceData);
        btn_sharePrefrenceData.setOnClickListener(this);
        btn_sqlData = (Button)findViewById(R.id.btn_sqlData);
        btn_sqlData.setOnClickListener(this);

        mSharePrefrences = mContext.getSharedPreferences("name",MODE_PRIVATE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sharePrefrenceData:

                 String data =   mSharePrefrences.getString("name","abc");

                Toast.makeText(mContext,data,Toast.LENGTH_SHORT).show();
                //测试mSharePrefrence是否为缓存
                if (data!=null && !data.equals("")) {
                    SharedPreferences.Editor editor = mSharePrefrences.edit();
                    editor.putString("name", "panjiang");
                    editor.commit();
                }
                break;
            case R.id.btn_cacheData:
                //
                DataCacheManager.getInstance(mContext).savaDataToInnerCache("o.txt",new String("abdddd"));
                DataCacheManager.getInstance(mContext).savaDataToCache("o.txt",new String("abdddd"));
                DataCacheManager.getInstance(mContext).savaDataToFilePath("o.txt",new String("abdddd"));
                DataCacheManager.getInstance(mContext).savaDataToInnerFilePath("o.txt",new String("abdddd"));
//                DataCacheManager.getInstance(mContext).savaDataToDownlaodCache("o.txt",new String("abdddd"));
                DataCacheManager.getInstance(mContext).savaDataToSdcard("o.txt",new String("abdddd"));
                break;

            case R.id.btn_sqlData:
                DataBaseHelper dataBaseHelper = new DataBaseHelper(mContext);
                SQLiteDatabase db =  dataBaseHelper.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put(UserInfo.USERID,"5645");
                db.insert(DataBaseHelper.TB_NAME,null,cv);
                db.close();

                break;
            default:
                break;
        }
    }
}
