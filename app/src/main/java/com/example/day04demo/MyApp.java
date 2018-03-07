package com.example.day04demo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.day04demo.activity.been.MyBeen;

/**
 * Created by 王宇辉 on 2018/3/6.
 */
public class MyApp extends Application {

    public static MyApp myApp;
    private DaoSession daoSession;

    public static MyApp getMyApp() {
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        createDB();
    }

    private void createDB() {
        //创建数据库的辅助类对象
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "student.db");
        //数据库对象
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        //连接数据库
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
