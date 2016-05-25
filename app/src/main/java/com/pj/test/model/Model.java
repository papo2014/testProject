package com.pj.test.model;

import static android.os.AsyncTask.execute;

/**
 * Created by Administrator on 2016/5/25.
 */
public class Model implements IModel {
    @Override
    public void getData(final ICallback callback) {
        execute(new Runnable(){
            public void run(){             //ugly
                //这里是耗时操作
                callback.onResult("hello world");    //10 返回数据
            }
        });
    }

    @Override
    public String getData() {
        return "hello world";
    }
}
