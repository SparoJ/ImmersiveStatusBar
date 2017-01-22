package com.pingan.apple;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * @author apple
 * @Description :
 * @date 17/1/20  下午3:57
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(initPageLayout() > 0) {
            setContentView(initPageLayout());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initView();
        initViewListener();
        process();
    }

    protected abstract void process();

    protected abstract void initViewListener();

    protected abstract void initView();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    protected abstract int initPageLayout();

    protected <T extends View> T $(int id) {
        return (T)super.findViewById(id);
    }
}
