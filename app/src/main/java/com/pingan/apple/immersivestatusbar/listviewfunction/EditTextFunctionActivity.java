package com.pingan.apple.immersivestatusbar.listviewfunction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.pingan.apple.immersivestatusbar.R;

import java.util.ArrayList;
import java.util.List;


/**
 * @author apple
 * @Description :
 * @date 17/1/13  上午9:38
 */
public class EditTextFunctionActivity extends AppCompatActivity implements EditTextChangedImpl{

    private ListView mLvEditText;
    private String[] listTitle = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
    private static final int listDefaultItemNum = 20;
    private List<ListEditTextBean> mList;
    private static final String TAG = EditTextFunctionActivity.class.getSimpleName();
    private int mLength;
    private int index = -1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext_function);
        initPageView();
        process();
    }

    private void initPageView() {
        mLvEditText = (ListView) findViewById(R.id.lv_edit_text_function);
    }

    private void process() {
        initData();
        mLvEditText.setAdapter(new MyAdapter(this));
    }

    private void initData() {
        mList = new ArrayList<>();
//        mList.clear();
        for (int i = 0; i < listDefaultItemNum; i++) {
            ListEditTextBean bean = new ListEditTextBean();
            bean.title = listTitle[i%7];
            bean.editMsg = bean.title+" item--> "+i;
            mList.add(bean);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLength = mLvEditText.getLastVisiblePosition() - mLvEditText.getFirstVisiblePosition();
    }

    @Override
    public void getEditTextMsg(ListEditTextBean bean) {
        Log.e(TAG, "getEditTextMsg: editMsg==="+ bean.editMsg+"//isChange//"+bean.isChange+"//position//"+bean.position);
        if(bean.isChange) {
            bean.isChange = false; //reset the state of the edittext msg
        }
    }


    public class MyAdapter extends BaseAdapter {

        EditTextChangedImpl mChangedImpl;
        private MyAdapter(EditTextChangedImpl changedImpl) {
            this.mChangedImpl = changedImpl;
        }

        @Override
        public int getCount() {
            return null!=mList ? mList.size(): 0;
        }

        @Override
        public ListEditTextBean getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            Log.e(TAG, "getView: position=="+position );
            ViewHolder holder = null;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_edittext_function, parent, false);
                holder.titleText = (TextView) convertView.findViewById(R.id.text_title_item);
                holder.msgEdit = (EditText) convertView.findViewById(R.id.edit_msg_item);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            final ListEditTextBean item = getItem(position);
            holder.titleText.setText(item.title);
            holder.msgEdit.setText(item.editMsg);
            holder.msgEdit.setTag(position);
            item.position = position;
            item.isChange = false;
            final ViewHolder finalHolder = holder;


            holder.msgEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    String beforeMsg = item.editMsg;
                    String currentMsg = finalHolder.msgEdit.getText().toString();
                    Log.e(TAG, "onFocusChange: ==hasFocus=="+hasFocus+"position==="+position +"///currentMsg//"+currentMsg);
                    if(hasFocus) {
                        beforeMsg = finalHolder.msgEdit.getText().toString();
                    } else {
                        if(!TextUtils.equals(beforeMsg, currentMsg)) {
                            item.editMsg = currentMsg;
                            item.isChange = true;
                            ListEditTextState.publish(item);
                        }
                        finalHolder.msgEdit.setText(currentMsg);
                        Log.e(TAG, "onFocusChange: "+"===setOnFocusChangeListener" +"==="+currentMsg+";;position;;;"+position);
//                        ListEditTextBean bean = getItem(state.position);
                    }
                }
            });

            return convertView;
        }
    }
    public static class ViewHolder {
        private TextView titleText;
        private EditText msgEdit;
    }
}
