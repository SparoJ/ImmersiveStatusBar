package com.pingan.apple.immersivestatusbar.recyclerviewdemo.pinestickview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pingan.apple.immersivestatusbar.R;
import com.pingan.apple.immersivestatusbar.recyclerviewdemo.complexdemo.ComplexActivity;
import com.pingan.apple.immersivestatusbar.widget.CircleImageView;
import com.squareup.picasso.Picasso;


/**
 * @author apple
 * @Description :
 * @date 17/1/17  下午1:46
 */

public class PineStickActivity extends AppCompatActivity {

    private Toolbar mTbPineStick;
    private RecyclerView mRvPineStick;
    private RelativeLayout mRlSuspensionBar;
    private CircleImageView mCiv;
    private TextView mTv;
    int mRlSuspensionBarHeight;
    private LinearLayoutManager mLayoutManager;
    private int mCurrentPosition;
    private static final String TAG = PineStickActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pine_stick);

        process();
    }

    private void process() {
        mTbPineStick = (Toolbar) findViewById(R.id.tb_pine_stick);
        mRvPineStick = (RecyclerView) findViewById(R.id.rv_pine_stick);
//        setSupportActionBar(mTbPineStick);
        initSuspensionBar();
        initMenu();
        initRv();
    }

    private void initSuspensionBar() {
        mRlSuspensionBar = (RelativeLayout) findViewById(R.id.rl_suspension_bar);
        mCiv = (CircleImageView) findViewById(R.id.civ_pine_stick);
        mTv = (TextView) findViewById(R.id.tv_pine_stick);

    }

    private void initRv() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRvPineStick.setLayoutManager(mLayoutManager);
        mRvPineStick.setAdapter(new PineStickAdapter(this));
        mRvPineStick.setHasFixedSize(true);

        mRvPineStick.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /**
             * called when is scrolling
             * @param recyclerView
             * @param dx
             * @param dy
             */
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                View view = mLayoutManager.findViewByPosition(mCurrentPosition + 1);
                if(null != view) {
                    if(view.getTop()<= mRlSuspensionBarHeight) {
                        mRlSuspensionBar.setY(-(mRlSuspensionBarHeight-view.getTop()));
                    } else {
                        mRlSuspensionBar.setY(0);
                    }
                }

                if(mCurrentPosition != mLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = mLayoutManager.findFirstVisibleItemPosition();
                }
                Log.e(TAG, "onScrolled: " );
                updateSuspensionBar(mCurrentPosition);

            }



            /**
             * called when scroll state changed
             * @param recyclerView
             * @param newState
             */
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                mRlSuspensionBarHeight = mRlSuspensionBar.getHeight();
                Picasso picasso = Picasso.with(PineStickActivity.this);

                if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                    picasso.resumeTag("recycler picasso");
                    Log.e(TAG, "onScrollStateChanged: " );
                } else {
                    picasso.pauseTag("recycler picasso");
                    Log.e(TAG, "onScrollStateChanged: 1111111" );
                }
            }
        });
    }

    public void updateSuspensionBar(int position) {
        Log.e(TAG, "updateSuspensionBar: " );
        mCiv.setImageResource(getCirImgRes(position));

        mTv.setText("taeyeon "+ position);
    }

    public int getCirImgRes(int position) {
        int mImgRes = 0;
        switch (position%4) {
            case 0 :
                mImgRes = R.drawable.avatar4;
                break;
            case 1 :
                mImgRes = R.drawable.avatar1;
                break;
            case 2 :
                mImgRes = R.drawable.avatar2;
                break;
            case 3 :
                mImgRes = R.drawable.avatar3;
                break;
        }
        return mImgRes;
    }

    private void initMenu() {
        mTbPineStick.inflateMenu(R.menu.menu_pine_stick);
        mTbPineStick.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_pine_stick :
                        Snackbar.make(mTbPineStick, "test snack bar", Snackbar.LENGTH_LONG)
                                .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(PineStickActivity.this, ComplexActivity.class);
                                startActivity(intent);
                            }
                        });
                        break;
                }
                return false; // ? true no response？
            }
        });
    }
}
