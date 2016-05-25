package com.pj.test.presenter;

import com.pj.test.activity.IView;
import com.pj.test.model.ICallback;
import com.pj.test.model.IModel;
import com.pj.test.model.Model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static android.os.AsyncTask.execute;

/**
 * Created by Administrator on 2016/5/25.
 */
public class Presenter implements IPresenter {
    private IView view;   //6 拥有View与Model
    private IModel model;

    public Presenter(IView iView) {
        this.view=iView;
        model=new Model();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void performOnClick() {

        execute(new Runnable(){
            public void run(){             //ugly!!! 从Model中移来的异步代码
                 //这里是耗时操作
                String data=model.getData();   //不需要Callback类，直接返回
                String dataFromPresenter=data+" from presenter"; //8 加工数据
                view.setData(dataFromPresenter);

            }
        });
    }

}
