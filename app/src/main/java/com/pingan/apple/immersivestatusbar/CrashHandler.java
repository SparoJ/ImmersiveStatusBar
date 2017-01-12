package com.pingan.apple.immersivestatusbar;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author apple
 * @Description :
 * @date 17/1/3  上午11:16
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private Context mContext;
    private static final String CRASH_LOG = "crash_log";
    private String crash_path;
    private static final String CRASH_LOG_SUFFIX = ".trace";
    private static final String CRASH_FILE_NAME = "crash";


    /** singleton instance **/
    private CrashHandler(){}

    private Handler mHandler = new Handler();

    // 异常处理类
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        //1 存到本地
        dumpExceptionToSDCard(ex);
        //2 上传服务器
        uploadExceptionToServer(ex);
        //3 app exit
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Process.killProcess(Process.myPid());
            }
        },2000);
    }

    private void uploadExceptionToServer(Throwable ex) {
        Error error = new Error(ex.getMessage());
        //通过 Bmob 来完成error msg 的信息上传到服务器
//        error.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId, BmobException e) {
//
//            }
//        });

    }

    // 将crash 信息从手机端存储到本地
    private void dumpExceptionToSDCard(Throwable ex) {
        File file = new File(crash_path);
        if(!file.exists()) {
            file.mkdirs(); //创建目录
        }

        String time = new SimpleDateFormat("yyyy-MM-dd:hh-mm-ss").format(new Date(System.currentTimeMillis()));
        File dir = new File(file, CRASH_FILE_NAME+time+CRASH_LOG_SUFFIX);
        PrintWriter writer;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(dir)));

            PackageManager manager = mContext.getPackageManager();
            PackageInfo info = manager.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);

            writer.println("crash time :"+ time);
            writer.println("app version name :"+ info.versionName);
            writer.println("app version code :" + info.versionCode);
            writer.println("android version API :" + Build.VERSION.SDK_INT);
            writer.println("android version code :"+ Build.VERSION.RELEASE);
            writer.println("cell manufacturer :"+Build.MANUFACTURER);
            writer.println("cell model :"+Build.MODEL);
            ex.printStackTrace(writer);
            //close the stream
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class CrashHandlerInstance {
        public static final CrashHandler INSTANCE = new CrashHandler();
    }

    public CrashHandler getInstance() {
        return CrashHandlerInstance.INSTANCE;
    }

    public void init(Context context) {
        //设置当前类为crash 的处理类
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context;
        setCrashHandlerPath();
    }

    private void setCrashHandlerPath() {
        crash_path = mContext.getFilesDir().getPath()+ File.separator + CRASH_LOG + File.separator;
    }

}
