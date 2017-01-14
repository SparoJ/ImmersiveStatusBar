package com.pingan.apple.immersivestatusbar.listviewfunction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pingan.apple.immersivestatusbar.R;

import rx.functions.Action1;

/**
 * @author apple
 * @Description :
 * @date 17/1/13  上午9:23
 */

public class ListViewFunctionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEditTextFunction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_function);

        process();
    }

    private void process() {
        mBtnEditTextFunction = (Button) findViewById(R.id.btn_listview_edittext_function);
        mBtnEditTextFunction.setOnClickListener(this);
        final EditText etTest = (EditText) findViewById(R.id.et_test);
        etTest.setText("test --> tessssss");
        etTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String trim = s.toString().trim();
                Log.e("sdh", "afterTextChanged:=== "+trim );
//                etTest.setText(trim);
            }
        });
        ListEditTextState.getObservable().subscribe(new Action1<ListEditTextBean>() {
            @Override
            public void call(ListEditTextBean editTextState) {
                // 获取 item 判断
                if(null != editTextState) {
                    Log.e("sdh",editTextState.isChange+"///"+editTextState.position+"///"+editTextState.editMsg );
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_listview_edittext_function :
                intent.setClass(ListViewFunctionActivity.this, EditTextFunctionActivity.class);
                break;
        }
        startActivity(intent);
    }
}
