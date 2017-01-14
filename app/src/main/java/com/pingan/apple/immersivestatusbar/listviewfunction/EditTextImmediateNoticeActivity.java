package com.pingan.apple.immersivestatusbar.listviewfunction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseArray;
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
 * ListView 中 嵌套 EditText 时 在某个EditText 改变发生实时回调处理 并处理了 条目复用导致文本复用问题
 * @author apple
 * @Description :
 * @date 17/1/14  下午3:14
 */

public class EditTextImmediateNoticeActivity extends AppCompatActivity implements EditTextChangedImpl{

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

    @Override
    public void getChangedEditText(EditText edit, final int position) {
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //TODO relative job
                Log.e(TAG, "afterTextChanged:string=== "+s+"sssssss==="+position );
                ListEditTextBean bean = mList.get(position);
                bean.editMsg = s.toString();
            }
        });
    }


    public class MyAdapter extends BaseAdapter {

        EditTextChangedImpl mChangedImpl;
        SparseArray<View> sparse = new SparseArray<>();
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
            if(sparse.get(position) == null) {
//              if(convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_edittext_function, parent, false);
                holder = new ViewHolder(convertView);

                convertView.setTag(holder);

            } else {
                convertView = sparse.get(position);
                holder = (ViewHolder) convertView.getTag();
            }

            final ListEditTextBean item = getItem(position);
            holder.titleText.setText(item.title);
            holder.msgEdit.setText(item.editMsg);
            holder.msgEdit.setTag(position);



            holder.msgEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    EditText ed = (EditText) v;
                    if(hasFocus) {
                        mChangedImpl.getChangedEditText(ed, (int)ed.getTag());
                    }

                }
            });

            return convertView;
        }
    }
    public static class ViewHolder {
        private TextView titleText;
        private EditText msgEdit;

        public ViewHolder(View convertView) {
            titleText = (TextView) convertView.findViewById(R.id.text_title_item);
            msgEdit = (EditText) convertView.findViewById(R.id.edit_msg_item);
        }
    }
}
