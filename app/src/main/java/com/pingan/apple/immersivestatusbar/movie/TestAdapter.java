package com.pingan.apple.immersivestatusbar.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pingan.apple.immersivestatusbar.R;
import com.pingan.apple.immersivestatusbar.movie.bean.MovieTodayEntity;
import com.pingan.apple.immersivestatusbar.utils.CommonUtil;
import com.pingan.loader.RoundBitmapTransformer;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author apple
 * @Description :
 * @date 17/1/23  下午7:32
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private  LayoutInflater mInflater;
    private  List<MovieTodayEntity.DataBean.MoviesBean> mList;
    private  Context mContext;

    public TestAdapter(Context context, List<MovieTodayEntity.DataBean.MoviesBean> list) {
        mContext = context;
        mInflater = LayoutInflater.from(CommonUtil.checkIfNull(context));
        mList = list;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_movie_home, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mList.get(position).getImg())
                .centerInside()
                .transform(new RoundBitmapTransformer())
                .tag("img")
                .fit()
                .into(holder.mIvMovieHome);

        holder.mTvMovieHome.setText(mList.get(position).getNm());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvMovieHome;
        private TextView mTvMovieHome;

        public TestViewHolder(View itemView) {
            super(itemView);
            mIvMovieHome = (ImageView) itemView.findViewById(R.id.iv_item_rv_movie_home);
            mTvMovieHome = (TextView) itemView.findViewById(R.id.tv_item_rv_movie_home);
        }
    }
}
