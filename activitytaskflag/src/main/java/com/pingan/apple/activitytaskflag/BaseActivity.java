package com.pingan.apple.activitytaskflag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author apple
 * @Description :
 * @date 16/10/18  下午1:40
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 将每一个新开的activity放在activity管理集合中
        ActivityManagerTool.getActivityManager().add(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManagerTool.getActivityManager().exit();
    }
}
