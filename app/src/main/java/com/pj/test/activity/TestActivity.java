package com.pj.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pj.test.presenter.IPresenter;
import com.pj.test.presenter.Presenter;
import com.pj.test.testproject.R;

/**
 * Created by Administrator on 2016/5/25.
 */
public class TestActivity extends Activity implements IView {
    private IPresenter presenter;
    private Button button;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.textView);

        presenter = new Presenter(this); //2 Presenter初始化
        presenter.onCreate();   //3 将生命周期回调传给Presenter
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.performOnClick(); //4 用户输入

            }
        });
    }

    @Override
    public void setData(final String data) {
        runOnUiThread(new Runnable() {     //ugly
            public void run() {
                text.setText(data);
            }
        });
    }
}
