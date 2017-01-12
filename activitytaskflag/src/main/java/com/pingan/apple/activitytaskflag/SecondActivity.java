package com.pingan.apple.activitytaskflag;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends BaseActivity{

    private Button mBtn_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        mBtn_second = (Button) findViewById(R.id.btn_second);
        mBtn_second.setOnClickListener((v)->{Intent second = new Intent(this,MainActivity.class); startActivity(second);});
    }


   /* @Override
    public void onClick(View v) {
        Intent second = new Intent(this,MainActivity.class);
        startActivity(second);
    }*/
}
