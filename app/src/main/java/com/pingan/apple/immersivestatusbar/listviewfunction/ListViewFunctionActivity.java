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

import java.util.ArrayList;

import static com.pingan.apple.immersivestatusbar.R.id.btn_listview_edittext_immediate;

/**
 * @author apple
 * @Description :
 * @date 17/1/13  上午9:23
 */

public class ListViewFunctionActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnEditTextFunction;
    private Button mBtnEditTextImmediate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_function);

        process();
    }

    private void process() {
        mBtnEditTextFunction = (Button) findViewById(R.id.btn_listview_edittext_function);
        mBtnEditTextFunction.setOnClickListener(this);

        mBtnEditTextImmediate = (Button) findViewById(R.id.btn_listview_edittext_immediate);
        mBtnEditTextImmediate.setOnClickListener(this);

        ArrayList<String> a = new ArrayList();

        ArrayList<String> b = new ArrayList();

        ArrayList<String> all = new ArrayList();
        all.add("aaa");
        all.add("bbb");
        all.add("ccc");
        for (int i = 0; i < all.size(); i++) {
            b.add(all.get(i));
        }
        a.addAll(all);
//        b.addAll(all);
//        b.remove(2);
//        Test test = b.get(2);
//        Test test = new Test("ccc",35);
//        test.name = "whatwhat";
        b.set(2,"test");
        Log.e("sdh", "invalidate: "+ a  );
        Log.e("sdh", "invalidate: "+ b  );
        Log.e("sdh", "invalidate: "+ all  );

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
//        ListEditTextState.getObservable().subscribe(new Action1<ListEditTextBean>() {
//            @Override
//            public void call(ListEditTextBean editTextState) {
//                // 获取 item 判断
//                if(null != editTextState) {
//                    Log.e("sdh",editTextState.isChange+"///"+editTextState.position+"///"+editTextState.editMsg );
//                }
//            }
//        });
//
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_listview_edittext_function :
                intent.setClass(ListViewFunctionActivity.this, EditTextFunctionActivity.class);
                break;
            case btn_listview_edittext_immediate :
                intent.setClass(ListViewFunctionActivity.this, EditTextImmediateNoticeActivity.class);
                break;
        }
        startActivity(intent);
    }
}
