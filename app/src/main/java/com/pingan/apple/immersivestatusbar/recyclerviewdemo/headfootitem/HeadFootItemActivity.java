package com.pingan.apple.immersivestatusbar.recyclerviewdemo.headfootitem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pingan.apple.immersivestatusbar.R;

import java.util.ArrayList;


/**
 * @author apple
 * @Description :
 *
 * @date 17/1/16  下午3:10
 */

public class HeadFootItemActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<ObjectModel> mData;
    private NormalAdapterWrapper mAdapter;
    private NormalAdapter mNoHeaderAdapter;
    private DividerItemDecoration mDecoration;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_foot_item);

        process();
    }

    private void process() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_head_foot_item);
        mDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mDecoration);

//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        mNoHeaderAdapter = new NormalAdapter(mData = initData());
        mAdapter = new NormalAdapterWrapper(mNoHeaderAdapter);
        View headerView = LayoutInflater.from(this).inflate(R.layout.item_header, mRecyclerView, false);
        View footerView = LayoutInflater.from(this).inflate(R.layout.item_footer, mRecyclerView, false);
        mAdapter.addFooterView(footerView);
        mAdapter.addHeaderView(headerView);
        mRecyclerView.setAdapter(mAdapter);

    }

    public ArrayList<ObjectModel> initData(){
        ArrayList<ObjectModel> models = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.title_array);
        for(int i=0;i<titles.length;i++){
            ObjectModel model = new ObjectModel();
            model.number = i + 1;
            model.title = titles[i];
            models.add(model);
        }
        return models;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_add:
                ObjectModel obj = new ObjectModel();
                obj.number = 0;
                obj.title = "Insert";
                mData.add(0,obj);
                mAdapter.notifyItemInserted(1);
                break;
            case R.id.item_delete:
                mData.remove(0);
                mAdapter.notifyItemRemoved(1);
                break;
            case R.id.item_change_divider:
                mDecoration.setDividerDrawable(getResources().getDrawable(R.drawable.divider));
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.item_hlistview:
                mRecyclerView.removeItemDecoration(mDecoration);
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST);
                mRecyclerView.addItemDecoration(mDecoration);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


