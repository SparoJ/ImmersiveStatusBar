package com.pingan.apple.immersivestatusbar.recyclerviewdemo.pinestickview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pingan.apple.immersivestatusbar.R;
import com.pingan.apple.immersivestatusbar.widget.CircleImageView;
import com.squareup.picasso.Picasso;



/**
 * @author apple
 * @Description :
 * @date 17/1/17  下午2:21
 */

public class PineStickAdapter extends RecyclerView.Adapter<PineStickAdapter.ViewHolder> {

    private LayoutInflater mInflater;

    public PineStickAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_pine_stick, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.mCivItem.setImageResource(getCirImgRes(position));
//        viewHolder.mIvItem.setImageResource(getImgRes(position));
        Picasso.with(holder.itemView.getContext())
                .load(getImgRes(position))
                .centerInside()
                .tag("recycler picasso")
                .fit()
                .into(holder.mIvItem);
        holder.mTvItem.setText("taeyeon "+ position);
    }

    @Override
    public int getItemCount() {
        return 100;
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

    public int getImgRes(int position) {
        int mImgRes = 0;
        switch (position%4) {
            case 0 :
                mImgRes = R.drawable.taeyeon_four;
                break;
            case 1 :
                mImgRes = R.drawable.taeyeon_one;
                break;
            case 2 :
                mImgRes = R.drawable.taeyeon_two;
                break;
            case 3 :
                mImgRes = R.drawable.taeyeon_three;
                break;
        }
        return mImgRes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView mCivItem;
        private TextView mTvItem;
        private ImageView mIvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            mCivItem = (CircleImageView) itemView.findViewById(R.id.civ_item_pine_stick);
            mTvItem = (TextView) itemView.findViewById(R.id.tv_item_pine_stick);
            mIvItem = (ImageView)itemView.findViewById(R.id.iv_item_pine_stick);
        }
    }
}
