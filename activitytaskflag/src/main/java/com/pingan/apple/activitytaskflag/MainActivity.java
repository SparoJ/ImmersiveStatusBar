package com.pingan.apple.activitytaskflag;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtn_main;
    private Button mBtn_dump;
    private ActivityManager mActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn_main = (Button) findViewById(R.id.btn_main);
        mBtn_main.setOnClickListener(this);
        mBtn_dump = (Button) findViewById(R.id.btn_dump);
        mBtn_dump.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main :

                Intent cp = new Intent(this,ThirdActivity.class);
                ComponentName cpName = cp.resolveActivity(getPackageManager());
                Log.e("shandahua", "dumpActivity:isExist "+cpName);

                Intent main = new Intent(this,SecondActivity.class);
//                main.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(main);
                break;
            case R.id.btn_dump :
                boolean isExist = dumpActivity(SecondActivity.class);
                //判断app 是否在前台
                if (isRunningForground()) {  //在前台并且在任务栈中
                    if(isExist) {
                        if (isTopActivity()) {
                            //位于栈顶 sigletop 自动生效
                            Intent intent = new Intent(this,SecondActivity.class);
                            startActivity(intent);
                            Log.e("shandahua", "isTopActivity: 栈内且栈顶"+isTopActivity());
                        }else {
                            Intent second = new Intent(this,SecondActivity.class);
                            second.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                            startActivity(second);
                            Log.e("shandahua", "isTopActivity: 栈内非栈顶"+isTopActivity());
                        }
                    }
                }
                break;
            default :
                break;
        }
    }

    private boolean isTopActivity() {
        if(getTasks()!=null) {
            ActivityManager.RunningTaskInfo tasks = getTasks();
            Log.e("shandahua", "isTopActivity: "+tasks.topActivity);
            if(tasks.topActivity!=null && tasks.topActivity.equals(SecondActivity.class)) {
                Log.e("shandahua", "isTopActivity: inside"+tasks.topActivity);
                return true;
            }
        }
        return false;
    }

    private  ActivityManager.RunningTaskInfo getTasks() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
        if(tasks!=null) {
            ActivityManager.RunningTaskInfo taskInfo = tasks.get(0);
            return taskInfo;
        }
        return null;
    }


    private boolean isRunningForground() {
        if(getTasks()!=null) {
            ActivityManager.RunningTaskInfo taskInfo = getTasks();
            String packageName = taskInfo.topActivity.getPackageName();
            if(!TextUtils.isEmpty(packageName) && packageName.equals(getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /*private boolean dumpActivity(Class<?> cls) {

        Intent intent = new Intent(this,cls);
        ComponentName cpName = intent.resolveActivity(getPackageManager());
        Log.e("shandahua", "dumpActivity:cpName "+cpName);
        if (cpName != null) { //对应package 存在此类
            //再判断是否处于运行状态   先获取当前运行中的task 遍历
            ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
            if (tasks != null) {
                for (ActivityManager.RunningTaskInfo info: tasks) {
                    Log.e("shandahua", "dumpActivity: "+info.numActivities);
                    ComponentName baseActivity = info.baseActivity;
                    Log.e("shandahua", "baseActivity: "+baseActivity);
                    if (baseActivity.equals(cpName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }*/

    private boolean dumpActivity(Class<? extends Activity> clz) {

        boolean isExist = ActivityManagerTool.getActivityManager().tagActivityIsExist(clz);
        Log.e("shandahua", "dumpActivity:isExist "+isExist);
        return isExist;
    }

}
